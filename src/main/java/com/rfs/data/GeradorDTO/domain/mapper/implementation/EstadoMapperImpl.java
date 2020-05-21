package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.EstadoDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.EstadoMapper;
import com.rfs.data.GeradorDTO.domain.mapper.PaisMapper;
import com.rfs.data.GeradorDTO.domain.models.Estado;
import org.springframework.beans.factory.annotation.Autowired;

public class EstadoMapperImpl implements EstadoMapper {
    private AuditoriaMapper auditoriaMapper;
    private PaisMapper paisMapper;

    @Autowired
    public EstadoMapperImpl(AuditoriaMapper auditoriaMapper, PaisMapper paisMapper) {
        this.auditoriaMapper = auditoriaMapper;
        this.paisMapper = paisMapper;
    }
    @Override
    public EstadoDTO toDto(Estado estado) {
        return EstadoDTO.builder()
                .id(estado.getId())
                .nome(estado.getNome())
                .codigoIBGE(estado.getCodigoIBGE())
                .pais(paisMapper.toDto(estado.getPais()))
                .auditoria(auditoriaMapper.toDto(estado.getAuditoria()))
                .build();
    }

    @Override
    public Estado toEntity(EstadoDTO estado) {
        return Estado.builder()
                .id(estado.getId())
                .nome(estado.getNome())
                .codigoIBGE(estado.getCodigoIBGE())
                .pais(paisMapper.toEntity(estado.getPais()))
                .auditoria(auditoriaMapper.toEntity(estado.getAuditoria()))
                .build();
    }
}