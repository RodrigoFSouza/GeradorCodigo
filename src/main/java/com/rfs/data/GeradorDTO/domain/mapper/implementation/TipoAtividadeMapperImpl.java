package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.TipoAtividadeDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.TipoAtividadeMapper;
import com.rfs.data.GeradorDTO.domain.models.TipoAtividade;
import org.springframework.beans.factory.annotation.Autowired;

public class TipoAtividadeMapperImpl implements TipoAtividadeMapper {
    private AuditoriaMapper auditoriaMapper;

    @Autowired
    public TipoAtividadeMapperImpl(AuditoriaMapper auditoriaMapper) {
        this.auditoriaMapper = auditoriaMapper;
    }

    @Override
    public TipoAtividadeDTO toDto(TipoAtividade tipoAtividade) {
        return TipoAtividadeDTO.builder()
                .id(tipoAtividade.getId())
                .tipoAtividade(tipoAtividade.getTipoAtividade())
                .auditoria(auditoriaMapper.toDto(tipoAtividade.getAuditoria()))
                .build();
    }

    @Override
    public TipoAtividade toEntity(TipoAtividadeDTO tipoAtividade) {
        return TipoAtividade.builder()
                .id(tipoAtividade.getId())
                .tipoAtividade(tipoAtividade.getTipoAtividade())
                .auditoria(auditoriaMapper.toEntity(tipoAtividade.getAuditoria()))
                .build();
    }
}