package com.rfs.data.GeradorDTO.domain.repository.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class EntidadeFilter {
    private Long entidadeId;
    private String nomeDaTabela;
    private String nomeDaEntidade;
    private OffsetDateTime dataCriacaoInicio;
    private OffsetDateTime dataCriacaoFim;
}
