package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.dto.ConcorrenteDTO;
import com.rfs.data.GeradorDTO.domain.models.Concorrente;

public interface ConcorrenteMapper {
    ConcorrenteDTO toDto(Concorrente concorrente);
    Concorrente toEntity(ConcorrenteDTO concorrenteDTO);

    default Concorrente fromId(Long id) {
        if (id == null) {
            return null;
        }
        Concorrente concorrente = new Concorrente();
        concorrente.setId(id);
        return concorrente;
    }
}
