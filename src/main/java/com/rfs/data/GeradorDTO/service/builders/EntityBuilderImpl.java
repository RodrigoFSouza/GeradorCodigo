package com.rfs.data.GeradorDTO.service.builders;

import com.rfs.data.GeradorDTO.service.Atributo;
import com.rfs.data.GeradorDTO.service.ClasseEntity;
import com.rfs.data.GeradorDTO.transpiler.EntityTranspiler;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

public class EntityBuilderImpl implements EntityBuilder {
    private ClasseEntity classeEntity;

    public EntityBuilderImpl() {
        this.classeEntity = new ClasseEntity();
    }

    @Override
    public EntityBuilder nomeDaEntity(String nomeDaEntity) {
        var nomeCapitalize = StringUtils.capitalize(nomeDaEntity);
        this.classeEntity.setNome("public class " +
                nomeCapitalize +
                " implements Serializable {\n" +
                "    private static final long serialVersionUID = 1L;\n\n"
        );
        return this;
    }

    @Override
    public EntityBuilder nomeDaTabela(String nomeDaTabela) {
        var nomeMaiusculo = StringUtils.upperCase(nomeDaTabela);
        this.classeEntity.setNomeDaTabela(nomeMaiusculo);
        return this;
    }

    @Override
    public EntityBuilder nomeDoPacote(String nomeDoPacote) {
        this.classeEntity.setNomeDoPacote(nomeDoPacote);
        return this;
    }

    @Override
    public EntityBuilder anotationsDaClasse(Set<String> anotationsDaClasse) {
        this.classeEntity.setAnotationsClasse(anotationsDaClasse);
        return this;
    }

    @Override
    public EntityBuilder atributosDaClasse(Set<Atributo> atributos) {
        this.classeEntity.setAtritubos(atributos);
        return this;
    }

    @Override
    public EntityBuilder adicionaGetAndSetters() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");

        for (Atributo atributo : this.classeEntity.getAtritubos()) {
            String templateGet = "    public TIPO NOME_METODO_GET() {\n" +
                    "        return this.CAMPO;\n" +
                    "    }\n\n";

            String templateSet = "    public void NOME_METODO_SET(TIPO CAMPO) {\n" +
                    "        this.CAMPO = CAMPO;\n" +
                    "    }\n\n";

            String nomeMetodoGet = "get" + StringUtils.capitalize(atributo.getNome());
            String nomeMetodoSet = "set" + StringUtils.capitalize(atributo.getNome());

            builder.append(templateGet
                    .replaceAll("TIPO", atributo.getTipo())
                    .replaceAll("CAMPO", atributo.getNome())
                    .replaceAll("NOME_METODO_GET", nomeMetodoGet));

            builder.append(templateSet
                    .replaceAll("TIPO", atributo.getTipo())
                    .replaceAll("CAMPO", atributo.getNome())
                    .replaceAll("NOME_METODO_SET", nomeMetodoSet));
        }

        this.classeEntity.setGetsAndSetters(builder.toString());
        return this;
    }

    @Override
    public EntityBuilder adicionaEqualsAndHashCode(EntityTranspiler transpiler) {
        var nomeEntity = StringUtils.capitalize(transpiler.getNomeEntity());
        String equals = "   @Override\n" +
            "    public boolean equals(Object o) {\n" +
            "        if (this == o) return true;\n" +
            "        if (o == null || getClass() != o.getClass()) return false;\n" +
            "        " + nomeEntity + " "
                       + transpiler.getNomeEntity() + " = ("
                       + nomeEntity + ") o;\n" +
            "        return id.equals(" + transpiler.getNomeEntity() + ".id);\n" +
            "    }\n\n";

        String hashCode = "    @Override\n" +
            "    public int hashCode() {\n" +
            "        return Objects.hash(id);\n" +
            "    }\n\n";

        this.classeEntity.setEqualsHashCode(equals.concat(hashCode));
        return this;
    }

    @Override
    public EntityBuilder adicionaConstructor(EntityTranspiler transpiler) {
        var nomeEntity = StringUtils.capitalize(transpiler.getNomeEntity());
        String constructor = "    public " + nomeEntity + "() {\n" +
                "    }";

        this.classeEntity.setConstructor(constructor);
        return this;
    }

    @Override
    public EntityBuilder adicionaToString(EntityTranspiler transpiler) {
        StringBuilder builderTemplate = new StringBuilder();
        builderTemplate
                .append("    @Override\n")
                .append("    public String toString() {\n")
                .append("        return " + transpiler.getNomeEntity() + " {\n");



        for (Atributo atributo: this.classeEntity.getAtritubos()) {
            builderTemplate.append("            \"")
                    .append(atributo.getNome())
                    .append("\" = this.")
                    .append(atributo.getNome())
                    .append(",\n");
        }

        builderTemplate.append("    }\n\n");

        this.classeEntity.setToString(builderTemplate.toString());
        return this;
    }

    @Override
    public EntityBuilder adicionaMergeForUpdate(EntityTranspiler transpiler) {
        StringBuilder builderTemplate  = new StringBuilder();
        var nomeEntity = transpiler.getNomeEntity();
        var nomeEntityCapitalize = StringUtils.capitalize(nomeEntity);

        builderTemplate
                .append("    public ")
                .append(nomeEntityCapitalize)
                .append(" mergeForUpdate(")
                .append(nomeEntityCapitalize)
                .append(" ")
                .append(nomeEntity)
                .append(") {\n");

        for (Atributo atributo: this.classeEntity.getAtritubos()) {
            builderTemplate
                    .append("        this.")
                    .append(atributo.getNome())
                    .append(" = ")
                    .append(nomeEntity)
                    .append(".get")
                    .append(StringUtils.capitalize(atributo.getNome()))
                    .append("();\n");
        }

        builderTemplate
                .append("        return this;\n")
                .append("    }");

        this.classeEntity.setMergeForUpdate(builderTemplate.toString());
        return this;
    }

    @Override
    public EntityBuilder imports(Set<String> imports) {
        this.classeEntity.setImports(imports);
        return this;
    }

    @Override
    public ClasseEntity build() {
        return this.classeEntity;
    }

}
