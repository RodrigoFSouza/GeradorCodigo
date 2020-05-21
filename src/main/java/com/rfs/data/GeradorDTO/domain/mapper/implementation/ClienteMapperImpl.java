package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.ClienteDTO;
import com.rfs.data.GeradorDTO.domain.mapper.*;
import com.rfs.data.GeradorDTO.domain.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class ClienteMapperImpl implements ClienteMapper {
    private AuditoriaMapper auditoriaMapper;
    private TipoAtividadeMapper tipoAtividadeMapper;
    private EnderecoMapper enderecoMapper;
    private ContatoMapper contatoMapper;
    private ContratoMapper contratoMapper;
    private ContabilMapper contabilMapper;
    private FormaPagamentoMapper formaPagamentoMapper;
    private CondicaoPagamentoMapper condicaoPagamentoMapper;
    private FornecedorMapper fornecedorMapper;

    @Autowired
    public ClienteMapperImpl(AuditoriaMapper auditoriaMapper, TipoAtividadeMapper tipoAtividadeMapper, EnderecoMapper enderecoMapper, ContatoMapper contatoMapper, ContratoMapper contratoMapper, ContabilMapper contabilMapper, FormaPagamentoMapper formaPagamentoMapper, CondicaoPagamentoMapper condicaoPagamentoMapper, FornecedorMapper fornecedorMapper) {
        this.auditoriaMapper = auditoriaMapper;
        this.tipoAtividadeMapper = tipoAtividadeMapper;
        this.enderecoMapper = enderecoMapper;
        this.contatoMapper = contatoMapper;
        this.contratoMapper = contratoMapper;
        this.contabilMapper = contabilMapper;
        this.formaPagamentoMapper = formaPagamentoMapper;
        this.condicaoPagamentoMapper = condicaoPagamentoMapper;
        this.fornecedorMapper = fornecedorMapper;
    }
    @Override
    public ClienteDTO toDto(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nomeRazao(cliente.getNomeRazao())
                .nomeFantasia(cliente.getNomeFantasia())
                .tipoPessoa(cliente.getTipoPessoa())
                .bloqueado(cliente.getBloqueado())
                .situacao(cliente.getSituacao())
                .cgcCpf(cliente.getCgcCpf())
                .inscricaoEstadual(cliente.getInscricaoEstadual())
                .valorLimiteCredito(cliente.getValorLimiteCredito())
                .numeroDiasAtraso(cliente.getNumeroDiasAtraso())
                .dataUltimoAtraso(cliente.getDataUltimoAtraso())
                .valorUltimoAtraso(cliente.getValorUltimoAtraso())
                .valorMaiorFatura(cliente.getValorMaiorFatura())
                .dataMaiorFatura(cliente.getDataMaiorFatura())
                .valorAcumuladoFatura(cliente.getValorAcumuladoFatura())
                .marca(cliente.getMarca())
                .observacao(cliente.getObservacao())
                .quantidadeDiasDestino(cliente.getQuantidadeDiasDestino())
                .inscricaoMunicipal(cliente.getInscricaoMunicipal())
                .indiceIpiNoIcms(cliente.getIndiceIpiNoIcms())
                .emailNfe(cliente.getEmailNfe())
                .tipoComercializacao(cliente.getTipoComercializacao())
                .percentualDeMargemLucro(cliente.getPercentualDeMargemLucro())
                .observacaoClienteFaturamento(cliente.getObservacaoClienteFaturamento())
                .diferimentoICMS(cliente.getDiferimentoICMS())
                .suspensaoIpi(cliente.getSuspensaoIpi())
                .tipoFrete(cliente.getTipoFrete())
                .clienteDesde(cliente.getClienteDesde())
                .classificacaoCliente(cliente.getClassificacaoCliente())
                .observacaoTributaria(cliente.getObservacaoTributaria())
                .emailNfeXml(cliente.getEmailNfeXml())
                .situacaoSuspensaoIcms(cliente.getSituacaoSuspensaoIcms())
                .mensagemLaudo(cliente.getMensagemLaudo())
                .contatos(cliente.getContatos().stream().map(c -> contatoMapper.toDto(c)).collect(Collectors.toSet()))
                .enderecos(cliente.getEnderecos().stream().map(e -> enderecoMapper.toDto(e)).collect(Collectors.toSet()))
                .contas(cliente.getContas().stream().map(c -> contabilMapper.toDto(c)).collect(Collectors.toSet()))
                .contratos(cliente.getContratos().stream().map(c -> contratoMapper.toDto(c)).collect(Collectors.toSet()))
                .tipoAtividade(tipoAtividadeMapper.toDto(cliente.getTipoAtividade()))
                .formaPagamento(formaPagamentoMapper.toDto(cliente.getFormaPagamento()))
                .condicaoPagamento(condicaoPagamentoMapper.toDto(cliente.getCondicaoPagamento()))
                .fornecedor(fornecedorMapper.toDto(cliente.getFornecedor()))
                .auditoria(auditoriaMapper.toDto(cliente.getAuditoria()))
                .build();
    }

    @Override
    public Cliente toEntity(ClienteDTO cliente) {
        return Cliente.builder()
                .id(cliente.getId())
                .nomeRazao(cliente.getNomeRazao())
                .nomeFantasia(cliente.getNomeFantasia())
                .tipoPessoa(cliente.getTipoPessoa())
                .bloqueado(cliente.getBloqueado())
                .situacao(cliente.getSituacao())
                .cgcCpf(cliente.getCgcCpf())
                .inscricaoEstadual(cliente.getInscricaoEstadual())
                .valorLimiteCredito(cliente.getValorLimiteCredito())
                .numeroDiasAtraso(cliente.getNumeroDiasAtraso())
                .dataUltimoAtraso(cliente.getDataUltimoAtraso())
                .valorUltimoAtraso(cliente.getValorUltimoAtraso())
                .valorMaiorFatura(cliente.getValorMaiorFatura())
                .dataMaiorFatura(cliente.getDataMaiorFatura())
                .valorAcumuladoFatura(cliente.getValorAcumuladoFatura())
                .marca(cliente.getMarca())
                .observacao(cliente.getObservacao())
                .quantidadeDiasDestino(cliente.getQuantidadeDiasDestino())
                .inscricaoMunicipal(cliente.getInscricaoMunicipal())
                .indiceIpiNoIcms(cliente.getIndiceIpiNoIcms())
                .emailNfe(cliente.getEmailNfe())
                .tipoComercializacao(cliente.getTipoComercializacao())
                .percentualDeMargemLucro(cliente.getPercentualDeMargemLucro())
                .observacaoClienteFaturamento(cliente.getObservacaoClienteFaturamento())
                .diferimentoICMS(cliente.getDiferimentoICMS())
                .suspensaoIpi(cliente.getSuspensaoIpi())
                .tipoFrete(cliente.getTipoFrete())
                .clienteDesde(cliente.getClienteDesde())
                .classificacaoCliente(cliente.getClassificacaoCliente())
                .observacaoTributaria(cliente.getObservacaoTributaria())
                .emailNfeXml(cliente.getEmailNfeXml())
                .situacaoSuspensaoIcms(cliente.getSituacaoSuspensaoIcms())
                .mensagemLaudo(cliente.getMensagemLaudo())
                .contatos(cliente.getContatos().stream().map(c -> contatoMapper.toEntity(c)).collect(Collectors.toSet()))
                .enderecos(cliente.getEnderecos().stream().map(e -> enderecoMapper.toEntity(e)).collect(Collectors.toSet()))
                .contas(cliente.getContas().stream().map(c -> contabilMapper.toEntity(c)).collect(Collectors.toSet()))
                .contratos(cliente.getContratos().stream().map(c -> contratoMapper.toEntity(c)).collect(Collectors.toSet()))
                .tipoAtividade(tipoAtividadeMapper.toEntity(cliente.getTipoAtividade()))
                .formaPagamento(formaPagamentoMapper.toEntity(cliente.getFormaPagamento()))
                .condicaoPagamento(condicaoPagamentoMapper.toEntity(cliente.getCondicaoPagamento()))
                .fornecedor(fornecedorMapper.toEntity(cliente.getFornecedor()))
                .auditoria(auditoriaMapper.toEntity(cliente.getAuditoria()))
                .build();
    }
}