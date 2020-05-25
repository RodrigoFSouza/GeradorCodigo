package com.rfs.data.GeradorDTO.service.builders;

import com.rfs.data.GeradorDTO.service.Atributo;
import com.rfs.data.GeradorDTO.service.enuns.ModificadorDeAcesso;
import org.apache.commons.lang3.StringUtils;

public class AtributoBuilderImpl implements  AtributoBuilder {
    private Atributo atributo;

    public AtributoBuilderImpl() {
        this.atributo = new Atributo();
    }

    @Override
    public AtributoBuilder modificadorAcesso(ModificadorDeAcesso modificador) {
        this.atributo.setModificadorDeAcesso(modificador);
        return this;
    }

    @Override
    public AtributoBuilder tipoAtributo(String tipo) {
        this.atributo.setTipo(tipo);
        return this;
    }

    @Override
    public AtributoBuilder nomeDoAtributo(String nome) {
        this.atributo.setNome(StringUtils.uncapitalize(nome));
        return this;
    }

    @Override
    public AtributoBuilder adicionarAnotacao(String anotacao) {
        this.atributo.adicionarAnotacao(anotacao);
        return this;
    }

    @Override
    public Atributo build() {

        return this.atributo;
    }
}
