package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The TipoEndereco enumeration.
 */
public enum TipoEndereco {
    PRINCIPAL('C'),
    RESIDENCIAL('R'),
    ENTREGA('F'),
    COBRANCA('B');

    private Character codigo;

    TipoEndereco(Character codigo) {
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public static TipoEndereco getTipoEndereco(Character codigo) {
        if ('P' == codigo) {
            return PRINCIPAL;
        } else if ('A' == codigo) {
            return RESIDENCIAL;
        } else if ('T' == codigo) {
            return ENTREGA;
        } else  {
            return COBRANCA;
        }
    }
}

@Converter(autoApply = true)
class TipoEnderecoConverter implements AttributeConverter<TipoEndereco, Character> {
    @Override
    public Character convertToDatabaseColumn(TipoEndereco tipoEndereco) {
        return tipoEndereco.getCodigo();
    }

    @Override
    public TipoEndereco convertToEntityAttribute(Character codigo) {
        return TipoEndereco.getTipoEndereco(codigo);
    }
}
