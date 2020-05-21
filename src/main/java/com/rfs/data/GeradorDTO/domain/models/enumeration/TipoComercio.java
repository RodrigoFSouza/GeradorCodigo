package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The TipoComercio enumeration.
 */
public enum TipoComercio {
    REVENDEDOR('R'), CONSUMIDOR_FINAL('C');
    private Character codigo;

    TipoComercio(Character codigo) {
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public static TipoComercio getTipoComercio(Character codigo) {
        if ('R' == codigo) {
            return REVENDEDOR;
        }
        return CONSUMIDOR_FINAL;
    }
}

@Converter(autoApply = true)
class TipoComercioConverter implements AttributeConverter<TipoComercio, Character> {
    @Override
    public Character convertToDatabaseColumn(TipoComercio tipoComercio) {
        return tipoComercio.getCodigo();
    }

    @Override
    public TipoComercio convertToEntityAttribute(Character codigo) {
        return TipoComercio.getTipoComercio(codigo);
    }
}
