package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum TipoPagamento {
    OUTROS('S'),
    A_VISTA('V'),
    A_PRAZO('P'),
    SEM_CONDICAO('S');

    private Character codigo;

    TipoPagamento(Character codigo) {
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public static TipoPagamento getTipoPagamento(Character codigo) {
        if ('V' == codigo) {
            return A_VISTA;
        } else if ('P' == codigo) {
            return A_PRAZO;
        } else if ('S' == codigo) {
            return SEM_CONDICAO;
        } else {
            return OUTROS;
        }
    }
    }

@Converter(autoApply = true)
class TipoPagamentoConverter implements AttributeConverter<TipoPagamento, Character> {
    @Override
    public Character convertToDatabaseColumn(TipoPagamento tipoPagamento) {
        return tipoPagamento.getCodigo();
    }

    @Override
    public TipoPagamento convertToEntityAttribute(Character codigo) {
        return TipoPagamento.getTipoPagamento(codigo);
    }
}
