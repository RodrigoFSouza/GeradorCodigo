package com.rfs.data.GeradorDTO.service.builders;

import com.rfs.data.GeradorDTO.service.Atributo;
import com.rfs.data.GeradorDTO.service.enuns.ModificadorDeAcesso;

public interface AtributoBuilder {
    AtributoBuilder modificadorAcesso(ModificadorDeAcesso modificador);
    AtributoBuilder tipoAtributo(String tipo);
    AtributoBuilder nomeDoAtributo(String nome);
    AtributoBuilder adicionarAnotacao(String anotacao);
    Atributo build();
}
