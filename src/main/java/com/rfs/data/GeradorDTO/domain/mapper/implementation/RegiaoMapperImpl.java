package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.RegiaoDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.RegiaoMapper;
import com.rfs.data.GeradorDTO.domain.models.Regiao;
import org.springframework.beans.factory.annotation.Autowired;

public class RegiaoMapperImpl implements RegiaoMapper {
    private AuditoriaMapper auditoriaMapper;

    @Autowired
    public RegiaoMapperImpl(AuditoriaMapper auditoriaMapper) {
        this.auditoriaMapper = auditoriaMapper;
    }

    @Override
    public RegiaoDTO toDto(Regiao regiao) {
        return RegiaoDTO.builder()
                .id(regiao.getId())
                .nome(regiao.getNome())
                .auditoria(auditoriaMapper.toDto(regiao.getAuditoria()))
                .build();
    }

    @Override
    public Regiao toEntity(RegiaoDTO regiao) {
        return Regiao.builder()
                .id(regiao.getId())
                .nome(regiao.getNome())
                .auditoria(auditoriaMapper.toEntity(regiao.getAuditoria()))
                .build();
    }
}