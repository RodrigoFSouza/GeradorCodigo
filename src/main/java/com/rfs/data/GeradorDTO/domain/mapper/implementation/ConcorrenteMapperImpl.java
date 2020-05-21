package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.ConcorrenteDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.ConcorrenteMapper;
import com.rfs.data.GeradorDTO.domain.models.Concorrente;
import org.springframework.beans.factory.annotation.Autowired;

public class ConcorrenteMapperImpl implements ConcorrenteMapper {
    private AuditoriaMapper auditoriaMapper;

    @Autowired
    public ConcorrenteMapperImpl(AuditoriaMapper auditoriaMapper) {
        this.auditoriaMapper = auditoriaMapper;
    }
    @Override
    public ConcorrenteDTO toDto(Concorrente concorrente) {
        return ConcorrenteDTO.builder()
                .id(concorrente.getId())
                .nomeRazao(concorrente.getNomeRazao())
                .nomeFantasia(concorrente.getNomeFantasia())
                .cnpj(concorrente.getCnpj())
                .inscricaoEstadual(concorrente.getInscricaoEstadual())
                .auditoria(auditoriaMapper.toDto(concorrente.getAuditoria()))
                .build();
    }

    @Override
    public Concorrente toEntity(ConcorrenteDTO concorrente) {
        return Concorrente.builder()
                .id(concorrente.getId())
                .nomeRazao(concorrente.getNomeRazao())
                .nomeFantasia(concorrente.getNomeFantasia())
                .cnpj(concorrente.getCnpj())
                .inscricaoEstadual(concorrente.getInscricaoEstadual())
                .auditoria(auditoriaMapper.toEntity(concorrente.getAuditoria()))
                .build();
    }
}