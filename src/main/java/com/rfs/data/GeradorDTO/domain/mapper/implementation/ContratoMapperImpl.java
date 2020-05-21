package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.ContratoDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.ClienteMapper;
import com.rfs.data.GeradorDTO.domain.mapper.ContratoMapper;
import com.rfs.data.GeradorDTO.domain.mapper.IndiceEconomicoMapper;
import com.rfs.data.GeradorDTO.domain.models.Contrato;
import org.springframework.beans.factory.annotation.Autowired;

public class ContratoMapperImpl implements ContratoMapper {
    private AuditoriaMapper auditoriaMapper;
    private ClienteMapper clienteMapper;
    private IndiceEconomicoMapper indiceEconomicoMapper;

    @Autowired
    public ContratoMapperImpl(AuditoriaMapper auditoriaMapper, ClienteMapper clienteMapper, IndiceEconomicoMapper indiceEconomicoMapper) {
        this.auditoriaMapper = auditoriaMapper;
        this.clienteMapper = clienteMapper;
        this.indiceEconomicoMapper = indiceEconomicoMapper;
    }

    @Override
    public ContratoDTO toDto(Contrato contrato) {
        return ContratoDTO.builder()
                .id(contrato.getId())
                .dataInicio(contrato.getDataInicio())
                .dataFinal(contrato.getDataFinal())
                .valorContrato(contrato.getValorContrato())
                .percentualAumento(contrato.getPercentualAumento())
                .valorReajuste(contrato.getValorReajuste())
                .indiceEconomico(indiceEconomicoMapper.toDto(contrato.getIndiceEconomico()))
                .cliente(clienteMapper.toDto(contrato.getCliente()))
                .auditoria(auditoriaMapper.toDto(contrato.getAuditoria()))
                .build();
    }

    @Override
    public Contrato toEntity(ContratoDTO contrato) {
        return Contrato.builder()
                .id(contrato.getId())
                .dataInicio(contrato.getDataInicio())
                .dataFinal(contrato.getDataFinal())
                .valorContrato(contrato.getValorContrato())
                .percentualAumento(contrato.getPercentualAumento())
                .valorReajuste(contrato.getValorReajuste())
                .indiceEconomico(indiceEconomicoMapper.toEntity(contrato.getIndiceEconomico()))
                .cliente(clienteMapper.toEntity(contrato.getCliente()))
                .auditoria(auditoriaMapper.toEntity(contrato.getAuditoria()))
                .build();
    }
}