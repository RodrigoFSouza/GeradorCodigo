package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum TipoFrete {
    PAGO_PELA_EMPRESA('P'),
    PAGO_PELO_CLIENTE('A'),
    POR_CONTA_DE_TERCEIROS('T'),
    TRANSP_POR_CONTA_REMETENTE('R'),
    TRANSP_POR_CONTA_DESTINATARIO('D'),
    SEM_OCORRENCIA_TRANSP('S');

    private Character codigo;

    TipoFrete(Character codigo) {
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public static TipoFrete getTipoFrete(Character codigo) {
        if ('P' == codigo) {
            return PAGO_PELA_EMPRESA;
        } else if ('A' == codigo) {
            return PAGO_PELO_CLIENTE;
        } else if ('T' == codigo) {
            return POR_CONTA_DE_TERCEIROS;
        } else if ('R' == codigo) {
            return TRANSP_POR_CONTA_REMETENTE;
        } else if ('D' == codigo) {
            return TRANSP_POR_CONTA_DESTINATARIO;
        } else {
            return SEM_OCORRENCIA_TRANSP;
        }
    }
}

@Converter(autoApply = true)
class TipoFreteConverter implements AttributeConverter<TipoFrete, Character> {
    @Override
    public Character convertToDatabaseColumn(TipoFrete tipoFrete) {
        return tipoFrete.getCodigo();
    }

    @Override
    public TipoFrete convertToEntityAttribute(Character codigo) {
        return TipoFrete.getTipoFrete(codigo);
    }
}

