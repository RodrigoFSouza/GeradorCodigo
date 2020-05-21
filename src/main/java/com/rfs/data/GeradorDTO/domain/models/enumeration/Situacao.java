package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum Situacao {
    ATIVO('A'),
    INATIVO('I');

    private Character codigo;

    Situacao(Character codigo) {
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public static Situacao getEStatus(Character codigo) {
        if ('A' == codigo) {
            return ATIVO;
        }
        return INATIVO;
    }
}

@Converter(autoApply = true)
class SituacaoConverter implements AttributeConverter<Situacao, Character> {
    @Override
    public Character convertToDatabaseColumn(Situacao eSituacao) {
        return eSituacao.getCodigo();
    }

    @Override
    public Situacao convertToEntityAttribute(Character codigo) {
        return Situacao.getEStatus(codigo);
    }
}


