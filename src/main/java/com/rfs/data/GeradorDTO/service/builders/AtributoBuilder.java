package com.rfs.data.GeradorDTO.service.builders;

import com.rfs.data.GeradorDTO.domain.model.Atributo;

public interface AtributoBuilder {
    AtributoBuilder modificadorAcesso(String modificador);
    AtributoBuilder tipoAtributo(String tipo);
    AtributoBuilder nomeDoAtributo(String nome);
    AtributoBuilder adicionarAnotacao(String anotacao);
    AtributoBuilder comId(String id);
    Atributo build();
}
