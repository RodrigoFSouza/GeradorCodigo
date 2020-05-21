package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.FormaPagamentoDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.FormaPagamentoMapper;
import com.rfs.data.GeradorDTO.domain.models.FormaPagamento;
import org.springframework.beans.factory.annotation.Autowired;

public class FormaPagamentoMapperImpl implements FormaPagamentoMapper {
    private AuditoriaMapper auditoriaMapper;

    @Autowired
    public FormaPagamentoMapperImpl(AuditoriaMapper auditoriaMapper) {
        this.auditoriaMapper = auditoriaMapper;
    }

    @Override
    public FormaPagamentoDTO toDto(FormaPagamento formaPagamento) {
        return FormaPagamentoDTO.builder()
                .id(formaPagamento.getId())
                .formaPagamento(formaPagamento.getFormaPagamento())
                .cheque(formaPagamento.getCheque())
                .descontadoBanco(formaPagamento.getDescontadoBanco())
                .boleto(formaPagamento.getBoleto())
                .formaPagamentoReceita(formaPagamento.getFormaPagamentoReceita())
                .auditoria(auditoriaMapper.toDto(formaPagamento.getAuditoria()))
                .build();
    }

    @Override
    public FormaPagamento toEntity(FormaPagamentoDTO formaPagamento) {
        return FormaPagamento.builder()
                .id(formaPagamento.getId())
                .formaPagamento(formaPagamento.getFormaPagamento())
                .cheque(formaPagamento.getCheque())
                .descontadoBanco(formaPagamento.getDescontadoBanco())
                .boleto(formaPagamento.getBoleto())
                .formaPagamentoReceita(formaPagamento.getFormaPagamentoReceita())
                .auditoria(auditoriaMapper.toEntity(formaPagamento.getAuditoria()))
                .build();
    }
}