package com.rfs.data.GeradorDTO.service;

import com.rfs.data.GeradorDTO.service.enuns.ModificadorDeAcesso;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Atributo {
    private String nome;
    private String tipo;
    private ModificadorDeAcesso modificadorDeAcesso;
    private List<String> anotationsAtributo = new LinkedList<>();

    public void adicionarAnotacao(String anotacao) {
        this.anotationsAtributo.add(anotacao);
    }

    public String imprimeAtributo() {
        StringBuilder atributo = new StringBuilder();
        StringBuilder anotacoesAtributo = new StringBuilder();
        for (String anotacao: this.anotationsAtributo) {
            anotacoesAtributo.append(anotacao.toString());
        }

        atributo
                .append(anotacoesAtributo)
                .append("    ")
                .append(modificadorDeAcesso.toString().toLowerCase())
                .append(" ")
                .append(tipo)
                .append(" ")
                .append(nome)
                .append(";\n\n");
        return atributo.toString();
    }
}