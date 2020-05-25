package com.rfs.data.GeradorDTO.service;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ClasseEntity {
    private String nome;
    private String nomeDaTabela;
    private Set<String> imports = new HashSet<>();
    private String nomeDoPacote;
    private Set<String> anotationsClasse = new HashSet<>();
    private Set<Atributo> atritubos = new HashSet<>();
    private String getsAndSetters;
    private String equalsHashCode;
    private String constructor;
    private String constructorAllArgs;
    private String toString;
    private String mergeForUpdate;

    public ClasseEntity() {
    }

    public String getTemplate() {
        StringBuilder builder = new StringBuilder();
        StringBuilder imports = new StringBuilder();
        StringBuilder anotacoesClasse = new StringBuilder();

        for (String imp: this.imports) {
            imports.append(imp);
        }

        for (String anotacao: this.anotationsClasse) {
            anotacoesClasse.append(anotacao);
        }

        StringBuilder atributos = new StringBuilder();

        for (Atributo atributo: this.atritubos) {
            atributos.append(atributo.imprimeAtributo());
        }

        builder
                .append(this.nomeDoPacote)
                .append("\n")
                .append(imports.toString())
                .append("\n")
                .append(anotacoesClasse.toString())
                .append(this.nome)
                .append("\n")
                .append(atributos.toString())
                .append(this.constructor)
                .append(this.getsAndSetters)
                .append(this.equalsHashCode)
                .append(this.toString)
                .append(this.mergeForUpdate)
                .append("\n")

                .append("}");

        return builder.toString();
    }
}
