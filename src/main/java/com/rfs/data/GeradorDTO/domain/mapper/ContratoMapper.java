package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.dto.ContratoDTO;
import com.rfs.data.GeradorDTO.domain.models.Contrato;

public interface ContratoMapper {
    ContratoDTO toDto(Contrato contrato);
    Contrato toEntity(ContratoDTO contratoDTO);
    default Contrato fromId(Long id) {
        if (id == null) {
            return null;
        }
        Contrato contrato = new Contrato();
        contrato.setId(id);
        return contrato;
    }
}
