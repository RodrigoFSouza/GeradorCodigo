package com.rfs.data.GeradorDTO.service.geradores;

import com.rfs.data.GeradorDTO.config.ApplicationProperties;
import com.rfs.data.GeradorDTO.transpiler.EntityTranspiler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeradorService {
    private ApplicationProperties applicationProperties;
    private WriteTemplate writeTemplate;

    @Autowired
    public GeradorService(ApplicationProperties applicationProperties, WriteTemplate writeTemplate) {
        this.applicationProperties = applicationProperties;
        this.writeTemplate = writeTemplate;
    }

    private String template = """
            package <packageNameBase>service.impl;
                        
            import <packageNameBase>service.AuditoriaService;
            import <packageNameBase>service.<entityName>Service;
            import <packageNameBase>domain.<entityName>;
            import <packageNameBase>repository.<entityName>Repository;
            import <packageNameBase>service.dto.<entityName>DTO;
            import <packageNameBase>service.exceptions.DbsFlexoBusinessException;
            import <packageNameBase>service.mapper.<entityName>Mapper;
            import org.slf4j.Logger;
            import org.slf4j.LoggerFactory;
                        
            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.data.domain.Page;
            import org.springframework.data.domain.Pageable;
            import org.springframework.stereotype.Service;
            import org.springframework.transaction.annotation.Propagation;
            import org.springframework.transaction.annotation.Transactional;
                        
            import java.util.Optional;
                        
            import static java.util.Objects.isNull;
                        
            @Service
            @Transactional
            public class <entityName>ServiceImpl implements <entityName>Service {
                private static final String VEICULO_NAO_ENCONTRADO = "<entityName> não encontrado.";
                private final Logger log = LoggerFactory.getLogger(<entityName>ServiceImpl.class);
                private final <entityName>Repository <entityNameUncapitalize>Repository;
                private final <entityName>Mapper <entityNameUncapitalize>Mapper;
                private final AuditoriaService auditoriaService;
                        
                @Autowired
                public <entityName>ServiceImpl(<entityName>Repository <entityNameUncapitalize>Repository, <entityName>Mapper <entityNameUncapitalize>Mapper, AuditoriaService auditoriaService) {
                    this.<entityNameUncapitalize>Repository = <entityNameUncapitalize>Repository;
                    this.<entityNameUncapitalize>Mapper = <entityNameUncapitalize>Mapper;
                    this.auditoriaService = auditoriaService;
                }
                        
                @Override
                @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
                public <entityName>DTO save(<entityName>DTO <entityNameUncapitalize>DTO) {
                    log.debug("Request to save <entityName> : {}", <entityNameUncapitalize>DTO);
                    if (isNull(<entityNameUncapitalize>DTO.getId())) {
                        return create(<entityNameUncapitalize>DTO);
                    }
                    return update(<entityNameUncapitalize>DTO);
                }
                        
                @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
                public <entityName>DTO create(<entityName>DTO <entityNameUncapitalize>DTO) {
                    log.debug("Criando uma nova <entityNameUncapitalize>: {}", <entityNameUncapitalize>DTO);
                        
                    var <entityNameUncapitalize> = <entityNameUncapitalize>Mapper.toEntity(<entityNameUncapitalize>DTO);
                    <entityNameUncapitalize>.setId(<entityNameUncapitalize>Repository.getUltimoId().orElse(0L) + 1L);
                    <entityNameUncapitalize>.setAuditoria(auditoriaService.setInclusao());
                        
                    return <entityNameUncapitalize>Mapper.toDto(<entityNameUncapitalize>Repository.save(<entityNameUncapitalize>));
                }
                        
                @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
                public <entityName>DTO update(<entityName>DTO <entityNameUncapitalize>DTO) {
                    log.debug("Atualizando uma <entityNameUncapitalize>: {}", <entityNameUncapitalize>DTO);
                        
                    var <entityNameUncapitalize> = <entityNameUncapitalize>Mapper.toEntity(<entityNameUncapitalize>DTO);
                    var <entityNameUncapitalize>Update = <entityNameUncapitalize>Repository.findById(<entityNameUncapitalize>.getId())
                            .map(r -> {
                                r.mergeForUpdate(<entityNameUncapitalize>);
                                r.setAuditoria(auditoriaService.setAlteracao(r.getAuditoria()));
                                return r;
                            })
                            .orElseThrow(() -> new DbsFlexoBusinessException(VEICULO_NAO_ENCONTRADO));
                        
                    return <entityNameUncapitalize>Mapper.toDto(<entityNameUncapitalize>Repository.save(<entityNameUncapitalize>Update));
                }
                        
                @Override
                @Transactional(readOnly = true)
                public Page<<entityName>DTO> findAll(Pageable pageable) {
                    log.debug("Request to get all <entityName>s");
                    return <entityNameUncapitalize>Repository.findAll(pageable)
                            .map(<entityNameUncapitalize>Mapper::toDto);
                }
                        
                @Override
                @Transactional(readOnly = true)
                public Optional<<entityName>DTO> findOne(Long id) {
                    log.debug("Request to get <entityName> : {}", id);
                    return <entityNameUncapitalize>Repository.findById(id)
                            .map(<entityNameUncapitalize>Mapper::toDto);
                }
                        
                @Override
                public void delete(Long id) {
                    log.debug("Request to delete <entityName> : {}", id);
                    <entityNameUncapitalize>Repository.deleteById(id);
                }
            }
                        
            """;

    public void gerarService(List<EntityTranspiler> transpilers) {
        String packageBase = applicationProperties.getPackageBase();
        for (EntityTranspiler entityTranspiler: transpilers) {
            var templateService = template.replaceAll("<packageNameBase>", packageBase)
                    .replaceAll("<entityName>", StringUtils.capitalize(entityTranspiler.getNomeEntity()))
                    .replaceAll("<entityNameUncapitalize>", StringUtils.uncapitalize(entityTranspiler.getNomeEntity()));

            var nomeArquivo = entityTranspiler.getNomeEntity() + "ServiceImpl.java";
            var packageDiretorio = packageBase + "service.impl";

            writeTemplate.adicionaTemplateNoArquivo(templateService, nomeArquivo, packageDiretorio);
        }
    }
}
