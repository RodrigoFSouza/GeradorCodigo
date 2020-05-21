package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.Auditoria;
import com.rfs.data.GeradorDTO.domain.dto.AuditoriaDTO;

public interface AuditoriaMapper {
    AuditoriaDTO toDto(Auditoria auditoria);
    Auditoria toEntity(AuditoriaDTO auditoriaDTO);
}
