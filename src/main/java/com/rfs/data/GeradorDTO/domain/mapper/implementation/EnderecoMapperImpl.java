package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.EnderecoDTO;
import com.rfs.data.GeradorDTO.domain.mapper.*;
import com.rfs.data.GeradorDTO.domain.models.Endereco;
import org.springframework.beans.factory.annotation.Autowired;

public class EnderecoMapperImpl implements EnderecoMapper {
    private CidadeMapper mapperCidade;
    private ClienteMapper clienteMapper;
    private FornecedorMapper fornecedorMapper;
    private VendedorMapper vendedorMapper;
    private AuditoriaMapper auditoriaMapper;

    @Autowired
    public EnderecoMapperImpl(CidadeMapper mapperCidade, ClienteMapper clienteMapper, FornecedorMapper fornecedorMapper, VendedorMapper vendedorMapper, AuditoriaMapper auditoriaMapper) {
        this.mapperCidade = mapperCidade;
        this.clienteMapper = clienteMapper;
        this.fornecedorMapper = fornecedorMapper;
        this.vendedorMapper = vendedorMapper;
        this.auditoriaMapper = auditoriaMapper;
    }


    @Override
    public EnderecoDTO toDto(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .tipoEndereco(endereco.getTipoEndereco())
                .logradouro(endereco.getLogradouro())
                .complemento(endereco.getComplemento())
                .cep(endereco.getCep())
                .telefone(endereco.getTelefone())
                .fax(endereco.getFax())
                .contato(endereco.getContato())
                .email(endereco.getEmail())
                .bairro(endereco.getBairro())
                .numero(endereco.getNumero())
                .site(endereco.getSite())
                .emailNfe(endereco.getEmailNfe())
                .pontoDeReferencia(endereco.getPontoDeReferencia())
                .localizacaoGeografica(endereco.getLocalizacaoGeografica())
                .cidade(mapperCidade.toDto(endereco.getCidade()))
                .cliente(clienteMapper.toDto(endereco.getCliente()))
                .fornecedor(fornecedorMapper.toDto(endereco.getFornecedor()))
                .vendedor(vendedorMapper.toDto(endereco.getVendedor()))
                .auditoria(auditoriaMapper.toDto(endereco.getAuditoria()))
                .build();
    }

    @Override
    public Endereco toEntity(EnderecoDTO endereco) {
        return Endereco.builder()
                .id(endereco.getId())
                .tipoEndereco(endereco.getTipoEndereco())
                .logradouro(endereco.getLogradouro())
                .complemento(endereco.getComplemento())
                .cep(endereco.getCep())
                .telefone(endereco.getTelefone())
                .fax(endereco.getFax())
                .contato(endereco.getContato())
                .email(endereco.getEmail())
                .bairro(endereco.getBairro())
                .numero(endereco.getNumero())
                .site(endereco.getSite())
                .emailNfe(endereco.getEmailNfe())
                .pontoDeReferencia(endereco.getPontoDeReferencia())
                .localizacaoGeografica(endereco.getLocalizacaoGeografica())
                .cidade(mapperCidade.toEntity(endereco.getCidade()))
                .cliente(clienteMapper.toEntity(endereco.getCliente()))
                .fornecedor(fornecedorMapper.toEntity(endereco.getFornecedor()))
                .vendedor(vendedorMapper.toEntity(endereco.getVendedor()))
                .auditoria(auditoriaMapper.toEntity(endereco.getAuditoria()))
                .build();
    }
}