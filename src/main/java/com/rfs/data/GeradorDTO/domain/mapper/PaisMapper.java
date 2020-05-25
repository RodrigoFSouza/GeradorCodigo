package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.dto.PaisDTO;
import com.rfs.data.GeradorDTO.domain.models.Pais;

public interface PaisMapper {
    PaisDTO toDto(Pais pais);
    Pais toEntity(PaisDTO paisDTO);
    default Pais fromId(Long id) {
        if (id == null) {
            return null;
        }
        Pais pais = new Pais();
        pais.setId(id);
        return pais;
    }
}
