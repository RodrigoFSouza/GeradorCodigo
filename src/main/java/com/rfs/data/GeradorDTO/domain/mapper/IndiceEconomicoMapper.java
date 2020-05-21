package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.IndiceEconomico;
import com.rfs.data.GeradorDTO.domain.dto.IndiceEconomicoDTO;

public interface IndiceEconomicoMapper {
    IndiceEconomicoDTO toDto(IndiceEconomico indiceEconomico);
    IndiceEconomico toEntity(IndiceEconomicoDTO indiceEconomicoDTO);
    default IndiceEconomico fromId(Long id) {
        if (id == null) {
            return null;
        }
        IndiceEconomico indiceEconomico = new IndiceEconomico();
        indiceEconomico.setId(id);
        return indiceEconomico;
    }
}
