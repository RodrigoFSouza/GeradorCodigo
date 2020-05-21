package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum TipoUtilizacao {
    VENDAS('V'),
    COMPRAS('C'),
    TODOS('A');

    private Character codigo;

    TipoUtilizacao(Character codigo) {
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public static TipoUtilizacao getTipoUtilizacao(Character codigo) {
        if ('V' == codigo) {
            return VENDAS;
        } else if ('C' == codigo) {
            return COMPRAS;
        } else {
            return TODOS;
        }
    }
}

@Converter(autoApply = true)
class TipoUtilizacaoConverter implements AttributeConverter<TipoUtilizacao, Character> {
    @Override
    public Character convertToDatabaseColumn(TipoUtilizacao tipoUtilizacao) {
        return tipoUtilizacao.getCodigo();
    }

    @Override
    public TipoUtilizacao convertToEntityAttribute(Character codigo) {
        return TipoUtilizacao.getTipoUtilizacao(codigo);
    }
}
