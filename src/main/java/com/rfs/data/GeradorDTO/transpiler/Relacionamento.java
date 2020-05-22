package com.rfs.data.GeradorDTO.transpiler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Relacionamento {
    private String tipo;
    private String direcao;
    private String tabelaReferencia;
    private String nomeEntidade;
    private String nomeAtributoReferencia;
    private String colunaReferencia;
}
