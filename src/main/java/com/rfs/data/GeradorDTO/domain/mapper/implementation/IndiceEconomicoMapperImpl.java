package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.IndiceEconomicoDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.IndiceEconomicoMapper;
import com.rfs.data.GeradorDTO.domain.models.IndiceEconomico;
import org.springframework.beans.factory.annotation.Autowired;

public class IndiceEconomicoMapperImpl implements IndiceEconomicoMapper {
    private AuditoriaMapper auditoriaMapper;

    @Autowired
    public IndiceEconomicoMapperImpl(AuditoriaMapper auditoriaMapper) {
        this.auditoriaMapper = auditoriaMapper;
    }


    @Override
    public IndiceEconomicoDTO toDto(IndiceEconomico indiceEconomico) {
        return IndiceEconomicoDTO.builder()
                .id(indiceEconomico.getId())
                .indiceEconomico(indiceEconomico.getIndiceEconomico())
                .tipoIndice(indiceEconomico.getTipoIndice())
                .periodo(indiceEconomico.getPeriodo())
                .auditoria(auditoriaMapper.toDto(indiceEconomico.getAuditoria()))
                .build();
    }

    @Override
    public IndiceEconomico toEntity(IndiceEconomicoDTO indiceEconomico) {
        return IndiceEconomico.builder()
                .id(indiceEconomico.getId())
                .indiceEconomico(indiceEconomico.getIndiceEconomico())
                .tipoIndice(indiceEconomico.getTipoIndice())
                .periodo(indiceEconomico.getPeriodo())
                .auditoria(auditoriaMapper.toEntity(indiceEconomico.getAuditoria()))
                .build();
    }
}