package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.CondicaoPagamentoDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.CondicaoPagamentoMapper;
import com.rfs.data.GeradorDTO.domain.models.CondicaoPagamento;
import org.springframework.beans.factory.annotation.Autowired;

public class CondicaoPagamentoMapperImpl implements CondicaoPagamentoMapper {
    private AuditoriaMapper auditoriaMapper;

    @Autowired
    public CondicaoPagamentoMapperImpl(AuditoriaMapper auditoriaMapper) {
        this.auditoriaMapper = auditoriaMapper;
    }
    @Override
    public CondicaoPagamentoDTO toDto(CondicaoPagamento condicaoPagamento) {
        return CondicaoPagamentoDTO.builder()
                .id(condicaoPagamento.getId())
                .descricao(condicaoPagamento.getDescricao())
                .tipoPagamento(condicaoPagamento.getTipoPagamento())
                .tipoUtilizacao(condicaoPagamento.getTipoUtilizacao())
                .encargosFinanceiros(condicaoPagamento.getEncargosFinanceiros())
                .auditoria(auditoriaMapper.toDto(condicaoPagamento.getAuditoria()))
                .build();
    }

    @Override
    public CondicaoPagamento toEntity(CondicaoPagamentoDTO condicaoPagamento) {
        return CondicaoPagamento.builder()
                .id(condicaoPagamento.getId())
                .descricao(condicaoPagamento.getDescricao())
                .tipoPagamento(condicaoPagamento.getTipoPagamento())
                .tipoUtilizacao(condicaoPagamento.getTipoUtilizacao())
                .encargosFinanceiros(condicaoPagamento.getEncargosFinanceiros())
                .auditoria(auditoriaMapper.toEntity(condicaoPagamento.getAuditoria()))
                .build();
    }
}