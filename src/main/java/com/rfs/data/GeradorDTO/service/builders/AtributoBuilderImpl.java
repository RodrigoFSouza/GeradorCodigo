package com.rfs.data.GeradorDTO.service.builders;

import com.rfs.data.GeradorDTO.domain.model.Anotacao;
import com.rfs.data.GeradorDTO.domain.model.Atributo;
import org.apache.commons.lang3.StringUtils;

public class AtributoBuilderImpl implements  AtributoBuilder {
    private Atributo atributo;

    public AtributoBuilderImpl() {
        this.atributo = new Atributo();
    }

    @Override
    public AtributoBuilder modificadorAcesso(String modificador) {
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
        this.atributo.setNomeCampoTabela(StringUtils.uncapitalize(nome));
        return this;
    }

    @Override
    public AtributoBuilder adicionarAnotacao(String anotacao) {
        this.atributo.addAnotacao(new Anotacao());
        return this;
    }

    @Override
    public AtributoBuilder comId(String id) {
        this.atributo.setCampoId(id);
        return this;
    }

    @Override
    public Atributo build() {

        return this.atributo;
    }


}
