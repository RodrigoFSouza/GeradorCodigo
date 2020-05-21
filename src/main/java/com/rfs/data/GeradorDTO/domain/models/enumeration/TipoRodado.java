package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The TipoRodado enumeration.
 */
public enum TipoRodado {
    TRUCK("01"),
    TOCO("02"),
    CAVALO_MECANICO("03"),
    VAN("04"),
    UTILITARIO("05");

    private String codigo;

    TipoRodado(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static TipoRodado getTipoRodado(String codigo) {
        if ("01".equals(codigo)) {
            return TRUCK;
        } else if ("02".equals(codigo)) {
            return TOCO;
        } else if ("03".equals(codigo)) {
            return CAVALO_MECANICO;
        } else if ("04".equals(codigo)) {
            return VAN;
        } else {
            return UTILITARIO;
        }
    }
}

@Converter(autoApply = true)
class TipoRodadoConverter implements AttributeConverter<TipoRodado, String> {
    @Override
    public String convertToDatabaseColumn(TipoRodado tipoPessoa) {
        return tipoPessoa.getCodigo();
    }

    @Override
    public TipoRodado convertToEntityAttribute(String codigo) {
        return TipoRodado.getTipoRodado(codigo);
    }
}
