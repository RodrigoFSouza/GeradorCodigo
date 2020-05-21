package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.FormaPagamento;
import com.rfs.data.GeradorDTO.domain.dto.FormaPagamentoDTO;

public interface FormaPagamentoMapper {
    FormaPagamentoDTO toDto(FormaPagamento formaPagamento);
    FormaPagamento toEntity(FormaPagamentoDTO formaPagamentoDTO);
    default FormaPagamento fromId(Long id) {
        if (id == null) {
            return null;
        }
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setId(id);
        return formaPagamento;
    }
}
