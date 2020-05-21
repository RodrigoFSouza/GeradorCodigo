package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.AuditoriaDTO;
import com.rfs.data.GeradorDTO.domain.dto.PaisDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.PaisMapper;
import com.rfs.data.GeradorDTO.domain.models.Pais;
import org.springframework.beans.factory.annotation.Autowired;

public class PaisMapperImpl implements PaisMapper {
    private AuditoriaMapper auditoriaMapper;

    @Autowired
    public PaisMapperImpl(AuditoriaMapper auditoriaMapper) {
        this.auditoriaMapper = auditoriaMapper;
    }

    @Override
    public PaisDTO toDto(Pais pais) {
        return PaisDTO.builder()
                .id(pais.getId())
                .nome(pais.getNome())
                .codigoIBGE(pais.getCodigoIBGE())
                .auditoria(auditoriaMapper.toDto(pais.getAuditoria()))
                .build();
    }

    @Override
    public Pais toEntity(PaisDTO pais) {
        return Pais.builder()
                .id(pais.getId())
                .nome(pais.getNome())
                .codigoIBGE(pais.getCodigoIBGE())
                .auditoria(auditoriaMapper.toEntity(pais.getAuditoria()))
                .build();
    }
}