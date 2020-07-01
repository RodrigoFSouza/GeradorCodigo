package com.rfs.data.GeradorDTO.service.geradores;

import com.rfs.data.GeradorDTO.config.ApplicationProperties;
import com.rfs.data.GeradorDTO.service.Atributo;
import com.rfs.data.GeradorDTO.service.builders.AtributoBuilderImpl;
import com.rfs.data.GeradorDTO.service.builders.EntityBuilderImpl;
import com.rfs.data.GeradorDTO.service.enuns.ModificadorDeAcesso;
import com.rfs.data.GeradorDTO.transpiler.EntityTranspiler;
import com.rfs.data.GeradorDTO.transpiler.FieldTranspiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.nonNull;

@Service
public class GeradorEntity {
    private Logger log = LoggerFactory.getLogger(GeradorEntity.class);
    private ApplicationProperties applicationProperties;
    private WriteTemplate writeTemplate;

    @Autowired
    public GeradorEntity(ApplicationProperties applicationProperties, WriteTemplate writeTemplate) {
        this.applicationProperties = applicationProperties;
        this.writeTemplate = writeTemplate;
    }

    public void criaEntity(List<EntityTranspiler> transpilers) {
        for (EntityTranspiler entityTranspiler : transpilers) {
            Set<String> anotationsClasse = new HashSet<>();
            Set<String> imports = new HashSet<>();

            imports.add("import javax.persistence.*;\n");
            imports.add("import javax.validation.constraints.*;\n");
            imports.add("import java.io.Serializable;\n");

            if (entityTranspiler.isUsaLoombok()) {
                anotationsClasse.add("@Data\n");
                anotationsClasse.add("@Builder\n");
                imports.add("import lombok.Builder;\n");
                imports.add("import lombok.Data;\n");
            }
            anotationsClasse.add("@Entity\n");

            var table = "@Table(name = \"" + entityTranspiler.getNomeDaTabela().toUpperCase() + "\")\n";
            anotationsClasse.add(table);

            var atributosDaClasse = geraAtributosDaClasse(entityTranspiler);

            var entityBuilder = new EntityBuilderImpl()
                    .nomeDaEntity(entityTranspiler.getNomeEntity())
                    .nomeDaTabela(entityTranspiler.getNomeDaTabela())
                    .nomeDoPacote("package" + applicationProperties.getPackageBase() + "domain.models;")
                    .anotationsDaClasse(anotationsClasse)
                    .imports(imports)
                    .atributosDaClasse(atributosDaClasse);

            if (!entityTranspiler.isUsaLoombok()) {
                entityBuilder
                        .adicionaGetAndSetters()
                        .adicionaConstructor(entityTranspiler)
                        .adicionaEqualsAndHashCode(entityTranspiler)
                        .adicionaToString(entityTranspiler);
            }

            if (entityTranspiler.isGeraMergeForUpdate()) {
                entityBuilder.adicionaMergeForUpdate(entityTranspiler);
            }

            var classeEntity = entityBuilder.build();

            String nomeArquivo = entityTranspiler.getNomeEntity() + ".java";
            String diretorioPackage = "domain.models";
            writeTemplate.adicionaTemplateNoArquivo(classeEntity.getTemplate(), nomeArquivo, diretorioPackage);
        }
    }

    private static Set<Atributo> geraAtributosDaClasse(EntityTranspiler entityTranspiler) {
        Set<Atributo> atributos = new HashSet<>();
        for (FieldTranspiler field: entityTranspiler.getFields()) {
            if ("id".equals(field.getNomeCampoEntity())) {
                if (!entityTranspiler.isGeraId()) {
                    atributos.add(new AtributoBuilderImpl()
                            .modificadorAcesso(ModificadorDeAcesso.PRIVATE)
                            .tipoAtributo(field.getTipo())
                            .nomeDoAtributo(field.getNomeCampoEntity())
                            .adicionarAnotacao("    @Id\n")
                            .adicionarAnotacao("    @Column(name = \"" + field.getNomeCampoTabela() + "\")\n")
                            .build()
                    );
                }
            } else {
                var atributoBuilder = new AtributoBuilderImpl();
                if (field.isRequerido()) {
                    atributoBuilder.adicionarAnotacao("    @NotNull\n");
                }
                if (nonNull(field.getTamanhoCampo())) {
                    atributoBuilder.adicionarAnotacao("    @Size(max = " + field.getTamanhoCampo() + ", " +
                            "message = \"O " + field.getNomeCampoEntity() +
                            " não pode ter mais do que " + field.getTamanhoCampo() +
                            " caracteres\")\n");
                }

                atributoBuilder
                        .modificadorAcesso(ModificadorDeAcesso.PRIVATE)
                        .tipoAtributo(field.getTipo())
                        .nomeDoAtributo(field.getNomeCampoEntity())
                        .adicionarAnotacao("    @Column(name = \"" + field.getNomeCampoTabela() + "\")\n");

                atributos.add(atributoBuilder.build());
            }
        }

        return atributos;
    }


}
