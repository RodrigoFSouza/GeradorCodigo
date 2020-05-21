package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The TipoPagamentoVendedor enumeration.
 */
public enum TipoPagamentoVendedor {
    RECEBIMENTO('R'), FATURAMENTO('F'), AMBOS('A');

    private Character codigo;

    TipoPagamentoVendedor(Character codigo) {
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public static TipoPagamentoVendedor getTipoPagamentoVendedor(Character codigo) {
        if ('R' == codigo) {
            return RECEBIMENTO;
        } else if ('F' == codigo) {
            return FATURAMENTO;
        } else {
            return AMBOS;
        }
    }
}

@Converter(autoApply = true)
class TipoPagamentoVendedorConverter implements AttributeConverter<TipoPagamentoVendedor, Character> {
    @Override
    public Character convertToDatabaseColumn(TipoPagamentoVendedor tipoPagamento) {
        return tipoPagamento.getCodigo();
    }

    @Override
    public TipoPagamentoVendedor convertToEntityAttribute(Character codigo) {
        return TipoPagamentoVendedor.getTipoPagamentoVendedor(codigo);
    }
}
