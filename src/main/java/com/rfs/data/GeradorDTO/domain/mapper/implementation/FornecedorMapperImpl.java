package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.FornecedorDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.EnderecoMapper;
import com.rfs.data.GeradorDTO.domain.mapper.FornecedorMapper;
import com.rfs.data.GeradorDTO.domain.mapper.TipoAtividadeMapper;
import com.rfs.data.GeradorDTO.domain.models.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class FornecedorMapperImpl implements FornecedorMapper {
    private AuditoriaMapper auditoriaMapper;
    private EnderecoMapper enderecoMapper;
    private TipoAtividadeMapper tipoAtividadeMapper;

    @Autowired
    public FornecedorMapperImpl(AuditoriaMapper auditoriaMapper, EnderecoMapper enderecoMapper, TipoAtividadeMapper tipoAtividadeMapper) {
        this.auditoriaMapper = auditoriaMapper;
        this.enderecoMapper = enderecoMapper;
        this.tipoAtividadeMapper = tipoAtividadeMapper;
    }
    @Override
    public FornecedorDTO toDto(Fornecedor fornecedor) {
        return FornecedorDTO.builder()
                .id(fornecedor.getId())
                .nomeRazao(fornecedor.getNomeRazao())
                .nomeFantasia(fornecedor.getNomeFantasia())
                .tipoPessoa(fornecedor.getTipoPessoa())
                .situacao(fornecedor.getSituacao())
                .tipoFornecimento(fornecedor.getTipoFornecimento())
                .cgcCpf(fornecedor.getCgcCpf())
                .valorAcumuladoCompra(fornecedor.getValorAcumuladoCompra())
                .dataUltimaCompra(fornecedor.getDataUltimaCompra())
                .valorUltimaCompra(fornecedor.getValorUltimaCompra())
                .observacao(fornecedor.getObservacao())
                .incricaoEstadual(fornecedor.getIncricaoEstadual())
                .emailNfe(fornecedor.getEmailNfe())
                .inscricaoMunicipal(fornecedor.getInscricaoMunicipal())
                .enderecos(fornecedor.getEnderecos().stream().map(f -> enderecoMapper.toDto(f)).collect(Collectors.toSet()))
                .tipoAtividade(tipoAtividadeMapper.toDto(fornecedor.getTipoAtividade()))
                .auditoria(auditoriaMapper.toDto(fornecedor.getAuditoria()))
                .build();
    }

    @Override
    public Fornecedor toEntity(FornecedorDTO fornecedor) {
        return Fornecedor.builder()
                .id(fornecedor.getId())
                .nomeRazao(fornecedor.getNomeRazao())
                .nomeFantasia(fornecedor.getNomeFantasia())
                .tipoPessoa(fornecedor.getTipoPessoa())
                .situacao(fornecedor.getSituacao())
                .tipoFornecimento(fornecedor.getTipoFornecimento())
                .cgcCpf(fornecedor.getCgcCpf())
                .valorAcumuladoCompra(fornecedor.getValorAcumuladoCompra())
                .dataUltimaCompra(fornecedor.getDataUltimaCompra())
                .valorUltimaCompra(fornecedor.getValorUltimaCompra())
                .observacao(fornecedor.getObservacao())
                .incricaoEstadual(fornecedor.getIncricaoEstadual())
                .emailNfe(fornecedor.getEmailNfe())
                .inscricaoMunicipal(fornecedor.getInscricaoMunicipal())
                .enderecos(fornecedor.getEnderecos().stream().map(f -> enderecoMapper.toEntity(f)).collect(Collectors.toSet()))
                .tipoAtividade(tipoAtividadeMapper.toEntity(fornecedor.getTipoAtividade()))
                .auditoria(auditoriaMapper.toEntity(fornecedor.getAuditoria()))
                .build();
    }
}