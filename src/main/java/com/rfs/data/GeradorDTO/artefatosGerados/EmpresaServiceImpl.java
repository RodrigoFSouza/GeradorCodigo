package com.rfs.data.GeradorDTOservice.impl;

import com.rfs.data.GeradorDTOservice.AuditoriaService;
import com.rfs.data.GeradorDTOservice.EmpresaService;
import com.rfs.data.GeradorDTOdomain.Empresa;
import com.rfs.data.GeradorDTOrepository.EmpresaRepository;
import com.rfs.data.GeradorDTOservice.dto.EmpresaDTO;
import com.rfs.data.GeradorDTOservice.exceptions.DbsFlexoBusinessException;
import com.rfs.data.GeradorDTOservice.mapper.EmpresaMapper;
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
public class EmpresaServiceImpl implements EmpresaService {
    private static final String VEICULO_NAO_ENCONTRADO = "Empresa não encontrado.";
    private final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;
    private final AuditoriaService auditoriaService;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper, AuditoriaService auditoriaService) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
        this.auditoriaService = auditoriaService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public EmpresaDTO save(EmpresaDTO empresaDTO) {
        log.debug("Request to save Empresa : {}", empresaDTO);
        if (isNull(empresaDTO.getId())) {
            return create(empresaDTO);
        }
        return update(empresaDTO);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public EmpresaDTO create(EmpresaDTO empresaDTO) {
        log.debug("Criando uma nova empresa: {}", empresaDTO);

        var empresa = empresaMapper.toEntity(empresaDTO);
        empresa.setId(empresaRepository.getUltimoId().orElse(0L) + 1L);
        empresa.setAuditoria(auditoriaService.setInclusao());

        return empresaMapper.toDto(empresaRepository.save(empresa));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public EmpresaDTO update(EmpresaDTO empresaDTO) {
        log.debug("Atualizando uma empresa: {}", empresaDTO);

        var empresa = empresaMapper.toEntity(empresaDTO);
        var empresaUpdate = empresaRepository.findById(empresa.getId())
                .map(r -> {
                    r.mergeForUpdate(empresa);
                    r.setAuditoria(auditoriaService.setAlteracao(r.getAuditoria()));
                    return r;
                })
                .orElseThrow(() -> new DbsFlexoBusinessException(VEICULO_NAO_ENCONTRADO));

        return empresaMapper.toDto(empresaRepository.save(empresaUpdate));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmpresaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Empresas");
        return empresaRepository.findAll(pageable)
                .map(empresaMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EmpresaDTO> findOne(Long id) {
        log.debug("Request to get Empresa : {}", id);
        return empresaRepository.findById(id)
                .map(empresaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Empresa : {}", id);
        empresaRepository.deleteById(id);
    }
}

