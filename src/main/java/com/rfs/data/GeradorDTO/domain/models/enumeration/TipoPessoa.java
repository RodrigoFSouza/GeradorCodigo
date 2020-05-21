package com.rfs.data.GeradorDTO.domain.models.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The TipoPessoa enumeration.
 */
public enum TipoPessoa {
    FISICA('F'),
    JURIDICA('J'),
    ESTRANGEIRO('E'),
    PROSPECT('P');

    private Character codigo;

    TipoPessoa(Character codigo) {
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }

    public static TipoPessoa getESituacao(Character codigo) {
        if ('F' == codigo) {
            return FISICA;
        } else if ('J' == codigo) {
            return JURIDICA;
        } else if ('E' == codigo) {
            return ESTRANGEIRO;
        } else {
            return PROSPECT;
        }
    }
}

@Converter(autoApply = true)
class TipoPessoaConverter implements AttributeConverter<TipoPessoa, Character> {
    @Override
    public Character convertToDatabaseColumn(TipoPessoa tipoPessoa) {
        return tipoPessoa.getCodigo();
    }

    @Override
    public TipoPessoa convertToEntityAttribute(Character codigo) {
        return TipoPessoa.getESituacao(codigo);
    }
}
