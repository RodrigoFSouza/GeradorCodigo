package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.dto.CondicaoPagamentoDTO;
import com.rfs.data.GeradorDTO.domain.models.CondicaoPagamento;

public interface CondicaoPagamentoMapper {
    CondicaoPagamentoDTO toDto(CondicaoPagamento condicaoPagamento);
    CondicaoPagamento toEntity(CondicaoPagamentoDTO condicaoPagamentoDTO);
    default CondicaoPagamento fromId(Long id) {
        if (id == null) {
            return null;
        }
        CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
        condicaoPagamento.setId(id);
        return condicaoPagamento;
    }
}
