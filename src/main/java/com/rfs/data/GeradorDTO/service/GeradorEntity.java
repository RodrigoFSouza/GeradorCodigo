package com.rfs.data.GeradorDTO.service;

import com.google.gson.Gson;
import com.rfs.data.GeradorDTO.service.builders.AtributoBuilderImpl;
import com.rfs.data.GeradorDTO.service.builders.EntityBuilderImpl;
import com.rfs.data.GeradorDTO.service.enuns.ModificadorDeAcesso;
import com.rfs.data.GeradorDTO.transpiler.EntityTranspiler;
import com.rfs.data.GeradorDTO.transpiler.FieldTranspiler;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.nonNull;

@Service
public class GeradorEntity {
    public static final String PACKAGE_NAME = "package com.rfs.data.GeradorDTO.domain.models;\n";
    public static final String PATH_NAME = "/home/rodrigo/Documentos/projetos-spring/codeGenerator/codeGenerator/src/main/java/com/rfs/data/GeradorDTO/scripts";

    public static void main(String[] args) {
        lendoArquivos();
    }

    public static void lendoArquivos() {
        File diretorio = new File(PATH_NAME);

        try {
            if (diretorio.isDirectory()) {
                File arquivos[] = diretorio.listFiles();
                for (File arquivo : arquivos) {
                    System.out.println("************************* LENDO JSON - COM GSON **************************");
                    Gson gson = new Gson();
                    EntityTranspiler entityTranspiler = gson.fromJson(new FileReader(arquivo), EntityTranspiler.class);
                    System.out.println("************************* ARQUIVO JSON - LIDO  **************************");
                    System.out.println("************************* GERANDO ENTITY  **************************");
                    criaEntity(entityTranspiler);
                    System.out.println("************************* ENTITY GERADA  **************************");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void criaEntity(EntityTranspiler entityTranspiler) {
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
                .nomeDoPacote(PACKAGE_NAME)
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

        if (entityTranspiler.isGeraDTO()) {

        }

        if (entityTranspiler.isGeraBuilderEntidade()) {

        }

        var classeEntity = entityBuilder.build();

        System.out.println(classeEntity.getTemplate());
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
                    atributoBuilder.adicionarAnotacao("    Size(max = " + field.getTamanhoCampo() + ")\n");
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
