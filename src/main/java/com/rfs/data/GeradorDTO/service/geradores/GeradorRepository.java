package com.rfs.data.GeradorDTO.service.geradores;

import com.rfs.data.GeradorDTO.transpiler.EntityTranspiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeradorRepository {
    @Value("${api.packageBase}")
    private String packageBase;

    private WriteTemplate writeTemplate;

    @Autowired
    public GeradorRepository(WriteTemplate writeTemplate) {
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

    public void gerarRepository(List<EntityTranspiler> transpilers) {
        for (EntityTranspiler entityTranspiler: transpilers) {
            var template = templateRepository
                    .replaceAll("<packageBase>", packageBase)
                    .replaceAll("<entityBase>", entityTranspiler.getNomeEntity());

            var nomeDoArquivo = entityTranspiler.getNomeEntity() + "Repository.java";
            var diretorioPackage = "repository";
            this.writeTemplate.adicionaTemplateNoArquivo(template, nomeDoArquivo, diretorioPackage);
        }
    }
}
