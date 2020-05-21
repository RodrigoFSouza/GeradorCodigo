package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum SimNao {
    SIM('S'),
    NAO('N');

    private Character codigo;

    SimNao(Character codigo) {
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public static SimNao getEStatus(Character codigo) {
        if ('S' == codigo) {
            return SIM;
        }
        return NAO;
    }
}

@Converter(autoApply = true)
class SimNaoConverter implements AttributeConverter<SimNao, Character> {
    @Override
    public Character convertToDatabaseColumn(SimNao eSituacao) {
        return eSituacao.getCodigo();
    }

    @Override
    public SimNao convertToEntityAttribute(Character codigo) {
        return SimNao.getEStatus(codigo);
    }
}
