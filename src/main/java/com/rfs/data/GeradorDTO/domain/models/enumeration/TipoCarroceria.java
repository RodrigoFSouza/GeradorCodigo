package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The TipoCarroceria enumeration.
 */
public enum TipoCarroceria {
    NAO_APLICAVEL("00"),
    FECHADA_BAU("01"),
    ABERTA("02"),
    GRANELEIRA("03"),
    PORTA_CONTAINER("04"),
    SIDER("05");

    private String codigo;

    TipoCarroceria(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static TipoCarroceria getTipoCarroceria(String codigo) {
        if ("00".equals(codigo)) {
            return NAO_APLICAVEL;
        } else if ("01".equals(codigo)) {
            return FECHADA_BAU;
        } else if ("02".equals(codigo)) {
            return ABERTA;
        } else if ("03".equals(codigo)) {
            return GRANELEIRA;
        } else if ("04".equals(codigo)) {
            return PORTA_CONTAINER;
        } else {
            return SIDER;
        }
    }
}

@Converter(autoApply = true)
class TipoCarroceriaConverter implements AttributeConverter<TipoCarroceria, String> {
    @Override
    public String convertToDatabaseColumn(TipoCarroceria tipoCarroceria) {
        return tipoCarroceria.getCodigo();
    }

    @Override
    public TipoCarroceria convertToEntityAttribute(String codigo) {
        return TipoCarroceria.getTipoCarroceria(codigo);
    }
}

