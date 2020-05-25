package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.dto.ContabilDTO;
import com.rfs.data.GeradorDTO.domain.models.Contabil;

public interface ContabilMapper {
    ContabilDTO toDto(Contabil contabil);
    Contabil toEntity(ContabilDTO contabilDTO);
    default Contabil fromId(Long id) {
        if (id == null) {
            return null;
        }
        Contabil contabil = new Contabil();
        contabil.setId(id);
        return contabil;
    }
}
