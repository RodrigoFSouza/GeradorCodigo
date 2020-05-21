package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.VendedorDTO;
import com.rfs.data.GeradorDTO.domain.mapper.*;
import com.rfs.data.GeradorDTO.domain.models.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class VendedorMapperImpl implements VendedorMapper {
    private FornecedorMapper fornecedorMapper;
    private AuditoriaMapper auditoriaMapper;
    private EnderecoMapper enderecoMapper;

    @Autowired
    public VendedorMapperImpl(FornecedorMapper fornecedorMapper, AuditoriaMapper auditoriaMapper, EnderecoMapper enderecoMapper) {
        this.fornecedorMapper = fornecedorMapper;
        this.auditoriaMapper = auditoriaMapper;
        this.enderecoMapper = enderecoMapper;
    }

    @Override
    public VendedorDTO toDto(Vendedor vendedor) {
        return VendedorDTO.builder()
                .id(vendedor.getId())
                .nomeRazao(vendedor.getNomeRazao())
                .nomeFantasia(vendedor.getNomeFantasia())
                .tipoPessoa(vendedor.getTipoPessoa())
                .situacao(vendedor.getSituacao())
                .cgcCpf(vendedor.getCgcCpf())
                .inscricaoEstadual(vendedor.getInscricaoEstadual())
                .dataUltimaVenda(vendedor.getDataUltimaVenda())
                .valorUltimaVenda(vendedor.getValorUltimaVenda())
                .valorAcumuladoVenda(vendedor.getValorAcumuladoVenda())
                .observacao(vendedor.getObservacao())
                .percentualDeComissao(vendedor.getPercentualDeComissao())
                .percentualDeMargemLucro(vendedor.getPercentualDeMargemLucro())
                .tipoPagamentoComissao(vendedor.getTipoPagamentoComissao())
                .numeroDiaDoMesPagamento(vendedor.getNumeroDiaDoMesPagamento())
                .percentualEncargosComissao(vendedor.getPercentualEncargosComissao())
                .ehRepresentante(vendedor.getEhRepresentante())
                .enderecos(
                        vendedor.getEnderecos()
                                .stream()
                                .map(e -> enderecoMapper.toDto(e))
                                .collect(Collectors.toSet())
                )
                .fornecedor(fornecedorMapper.toDto(vendedor.getFornecedor()))
                .auditoria(auditoriaMapper.toDto(vendedor.getAuditoria()))
                .build();
    }

    @Override
    public Vendedor toEntity(VendedorDTO vendedor) {
        return Vendedor.builder()
                .id(vendedor.getId())
                .nomeRazao(vendedor.getNomeRazao())
                .nomeFantasia(vendedor.getNomeFantasia())
                .tipoPessoa(vendedor.getTipoPessoa())
                .situacao(vendedor.getSituacao())
                .cgcCpf(vendedor.getCgcCpf())
                .inscricaoEstadual(vendedor.getInscricaoEstadual())
                .dataUltimaVenda(vendedor.getDataUltimaVenda())
                .valorUltimaVenda(vendedor.getValorUltimaVenda())
                .valorAcumuladoVenda(vendedor.getValorAcumuladoVenda())
                .observacao(vendedor.getObservacao())
                .percentualDeComissao(vendedor.getPercentualDeComissao())
                .percentualDeMargemLucro(vendedor.getPercentualDeMargemLucro())
                .tipoPagamentoComissao(vendedor.getTipoPagamentoComissao())
                .numeroDiaDoMesPagamento(vendedor.getNumeroDiaDoMesPagamento())
                .percentualEncargosComissao(vendedor.getPercentualEncargosComissao())
                .ehRepresentante(vendedor.getEhRepresentante())
                .enderecos(
                        vendedor.getEnderecos()
                                .stream()
                                .map(e -> enderecoMapper.toEntity(e))
                                .collect(Collectors.toSet())
                )
                .fornecedor(fornecedorMapper.toEntity(vendedor.getFornecedor()))
                .auditoria(auditoriaMapper.toEntity(vendedor.getAuditoria()))
                .build();
    }
}