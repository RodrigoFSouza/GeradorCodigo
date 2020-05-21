package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.AuditoriaDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.models.Auditoria;

public class AuditoriaMapperImpl implements AuditoriaMapper {
    @Override
    public AuditoriaDTO toDto(Auditoria auditoria) {
        return AuditoriaDTO.builder()
                .usuarioInclusao(auditoria.getUsuarioInclusao())
                .usuarioAlteracao(auditoria.getUsuarioAlteracao())
                .dataInclusao(auditoria.getDataInclusao())
                .dataAlteracao(auditoria.getDataAlteracao())
                .build();
    }

    @Override
    public Auditoria toEntity(AuditoriaDTO auditoria) {
        return Auditoria.builder()
                .usuarioInclusao(auditoria.getUsuarioInclusao())
                .usuarioAlteracao(auditoria.getUsuarioAlteracao())
                .dataInclusao(auditoria.getDataInclusao())
                .dataAlteracao(auditoria.getDataAlteracao())
                .build();
    }
}