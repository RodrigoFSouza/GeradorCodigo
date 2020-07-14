package com.rfs.data.GeradorDTO.service.geradores;

import com.rfs.data.GeradorDTO.config.ApplicationProperties;
import com.rfs.data.GeradorDTO.domain.model.Entidade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeradorRepository {
    private ApplicationProperties applicationProperties;
    private WriteTemplate writeTemplate;

    @Autowired
    public GeradorRepository(ApplicationProperties applicationProperties, WriteTemplate writeTemplate) {
        this.applicationProperties = applicationProperties;
        this.writeTemplate = writeTemplate;
    }

    private String templateRepository = """
                    package <package-base>.repository;
                        
                    import <package-base>.domain.<entity-base>;
                        
                    import org.springframework.data.jpa.repository.*;
                    import org.springframework.stereotype.Repository;
                        
                    import java.util.Optional;
                     
                    @Repository
                    public interface <entity-base>Repository extends JpaRepository<<entity-base>, Long>, JpaSpecificationExecutor<<entity-base>> {
                        @Query(value = "SELECT MAX(e.id) FROM <entity-base> e")
                        Optional<Long> getUltimoId();
                    }
                        
            """;

    public void gerarRepository(List<Entidade> entidades) {
        String packageBase = applicationProperties.getPackageBase();
        for (Entidade entityTranspiler: entidades) {
            var template = templateRepository
                    .replaceAll("<package-base>", packageBase)
                    .replaceAll("<entity-base>", StringUtils.capitalize(entityTranspiler.getNomeEntity()));

            var nomeDoArquivo = entityTranspiler.getNomeEntity() + "Repository.java";
            var diretorioPackage = "repository";
            this.writeTemplate.adicionaTemplateNoArquivo(template, nomeDoArquivo, diretorioPackage);
        }
    }
}
