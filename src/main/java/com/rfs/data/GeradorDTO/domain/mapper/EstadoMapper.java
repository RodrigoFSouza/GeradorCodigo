package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.Estado;
import com.rfs.data.GeradorDTO.domain.dto.EstadoDTO;

public interface EstadoMapper {
    EstadoDTO toDto(Estado estado);
    Estado toEntity(EstadoDTO estadoDTO);

    default Estado fromId(String id) {
        if (id == null) {
            return null;
        }
        Estado estado = new Estado();
        estado.setId(id);
        return estado;
    }
}
