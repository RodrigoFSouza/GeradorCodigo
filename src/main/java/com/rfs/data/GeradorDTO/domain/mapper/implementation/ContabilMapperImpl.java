package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.ContabilDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.ClienteMapper;
import com.rfs.data.GeradorDTO.domain.mapper.ContabilMapper;
import com.rfs.data.GeradorDTO.domain.mapper.IndiceEconomicoMapper;
import com.rfs.data.GeradorDTO.domain.models.Contabil;
import org.springframework.beans.factory.annotation.Autowired;

public class ContabilMapperImpl implements ContabilMapper {
    private AuditoriaMapper auditoriaMapper;
    private ClienteMapper clienteMapper;

    @Autowired
    public ContabilMapperImpl(AuditoriaMapper auditoriaMapper, ClienteMapper clienteMapper) {
        this.auditoriaMapper = auditoriaMapper;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ContabilDTO toDto(Contabil contabil) {
        return ContabilDTO.builder()
                .id(contabil.getId())
                .codigoEmpresa(contabil.getCodigoEmpresa())
                .cliente(clienteMapper.toDto(contabil.getCliente()))
                .auditoria(auditoriaMapper.toDto(contabil.getAuditoria()))
                .build();
    }

    @Override
    public Contabil toEntity(ContabilDTO contabil) {
        return Contabil.builder()
                .id(contabil.getId())
                .codigoEmpresa(contabil.getCodigoEmpresa())
                .cliente(clienteMapper.toEntity(contabil.getCliente()))
                .auditoria(auditoriaMapper.toEntity(contabil.getAuditoria()))
                .build();
    }
}