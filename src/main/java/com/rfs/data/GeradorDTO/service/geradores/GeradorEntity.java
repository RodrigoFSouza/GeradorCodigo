package com.rfs.data.GeradorDTO.service.geradores;

import com.rfs.data.GeradorDTO.config.ApplicationProperties;
import com.rfs.data.GeradorDTO.domain.model.Atributo;
import com.rfs.data.GeradorDTO.domain.model.Entidade;
import com.rfs.data.GeradorDTO.domain.vo.id.IdEntidade;
import com.rfs.data.GeradorDTO.service.builders.AtributoBuilderImpl;
import com.rfs.data.GeradorDTO.service.builders.EntityBuilderImpl;
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

    public void criaEntity(List<Entidade> transpilers) {
        for (Entidade entidade : transpilers) {
            Set<String> anotationsClasse = new HashSet<>();
            Set<String> imports = new HashSet<>();

            adicionaImportsDaJPA(imports);

            if (entidade.isUsaLoombok()) {
                adicionaImportsDoLombok(anotationsClasse, imports);
            }

            if (entidade.isUsaJpa()) {
                adicionaAnotacaoJpaAEntidade(entidade, anotationsClasse);
            }

            var entityBuilder = new EntityBuilderImpl()
                    .nomeDaEntity(entidade.getNomeEntity())
                    .nomeDaTabela(entidade.getNomeDaTabela())
                    .nomeDoPacote("package" + applicationProperties.getPackageBase() + "domain.models;")
                    .anotationsDaClasse(anotationsClasse)
                    .imports(imports)
                    .atributosDaClasse(entidade.getAtributos());

            if (!entidade.isUsaLoombok()) {
                entityBuilder
                        .adicionaGetAndSetters()
                        .adicionaConstructor(entidade)
                        .adicionaEqualsAndHashCode(entidade)
                        .adicionaToString(entidade);
            }

            if (entidade.isGeraMergeForUpdate()) {
                entityBuilder.adicionaMergeForUpdate(entidade);
            }

            var classeEntity = entityBuilder.build();

            String nomeArquivo = entidade.getNomeEntity() + ".java";
            String diretorioPackage = "domain.models";
            writeTemplate.adicionaTemplateNoArquivo(classeEntity.getTemplate(), nomeArquivo, diretorioPackage);
        }
    }

    private static Set<Atributo> geraAtributosDaClasse(Entidade entidade) {
        Set<Atributo> atributos = new HashSet<>();
        for (Atributo atributo: entidade.getAtributos()) {
            var atributoBuilder = new AtributoBuilderImpl();
            if ("id".equals(atributo.getNomeCampoEntity())) {
                atributoBuilder.comId(IdEntidade.codigoGeradoPelaAplicacao(atributo.getNomeCampoEntity(), atributo.getNomeCampoTabela()));
            }

            if (!"id".equals(atributo.getNomeCampoEntity())) {
                if (atributo.isRequerido()) {
                    atributoBuilder.adicionarAnotacao("    @NotNull\n");
                }
                if (nonNull(atributo.getTamanhoCampo())) {
                    atributoBuilder.adicionarAnotacao("    @Size(max = " + atributo.getTamanhoCampo() + ", " +
                            "message = \"O " + atributo.getNomeCampoEntity() +
                            " não pode ter mais do que " + atributo.getTamanhoCampo() +
                            " caracteres\")\n");
                }

                atributoBuilder
                        .modificadorAcesso(atributo.getModificadorDeAcesso())
                        .tipoAtributo(atributo.getTipo())
                        .nomeDoAtributo(atributo.getNomeCampoEntity())
                        .adicionarAnotacao("    @Column(name = \"" + atributo.getNomeCampoTabela() + "\")\n");
            }
        }

        return atributos;
    }

    private void adicionaAnotacaoJpaAEntidade(Entidade entidade, Set<String> anotationsClasse) {
        anotationsClasse.add("@Entity\n");

        var table = "@Table(name = \"" + entidade.getNomeDaTabela().toUpperCase() + "\")\n";
        anotationsClasse.add(table);
    }

    private void adicionaImportsDoLombok(Set<String> anotationsClasse, Set<String> imports) {
        anotationsClasse.add("@Data\n");
        anotationsClasse.add("@Builder\n");
        imports.add("import lombok.Builder;\n");
        imports.add("import lombok.Data;\n");
    }

    private void adicionaImportsDaJPA(Set<String> imports) {
        imports.add("import javax.persistence.*;\n");
        imports.add("import javax.validation.constraints.*;\n");
        imports.add("import java.io.Serializable;\n");
    }
}
