package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.ContatoDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.ClienteMapper;
import com.rfs.data.GeradorDTO.domain.mapper.ContatoMapper;
import com.rfs.data.GeradorDTO.domain.mapper.IndiceEconomicoMapper;
import com.rfs.data.GeradorDTO.domain.models.Contato;
import org.springframework.beans.factory.annotation.Autowired;

public class ContatoMapperImpl implements ContatoMapper {
    private AuditoriaMapper auditoriaMapper;
    private ClienteMapper clienteMapper;
    private IndiceEconomicoMapper indiceEconomicoMapper;

    @Autowired
    public ContatoMapperImpl(AuditoriaMapper auditoriaMapper, ClienteMapper clienteMapper, IndiceEconomicoMapper indiceEconomicoMapper) {
        this.auditoriaMapper = auditoriaMapper;
        this.clienteMapper = clienteMapper;
        this.indiceEconomicoMapper = indiceEconomicoMapper;
    }

    @Override
    public ContatoDTO toDto(Contato contato) {
        return ContatoDTO.builder()
                .id(contato.getId())
                .nome(contato.getNome())
                .telefone(contato.getTelefone())
                .email(contato.getEmail())
                .observacao(contato.getObservacao())
                .funcao(contato.getFuncao())
                .celular(contato.getCelular())
                .fax(contato.getFax())
                .dataNascimento(contato.getDataNascimento())
                .situacao(contato.getSituacao())
                .cliente(clienteMapper.toDto(contato.getCliente()))
                .auditoria(auditoriaMapper.toDto(contato.getAuditoria()))
                .build();
    }

    @Override
    public Contato toEntity(ContatoDTO contato) {
        return Contato.builder()
                .id(contato.getId())
                .nome(contato.getNome())
                .telefone(contato.getTelefone())
                .email(contato.getEmail())
                .observacao(contato.getObservacao())
                .funcao(contato.getFuncao())
                .celular(contato.getCelular())
                .fax(contato.getFax())
                .dataNascimento(contato.getDataNascimento())
                .situacao(contato.getSituacao())
                .cliente(clienteMapper.toEntity(contato.getCliente()))
                .auditoria(auditoriaMapper.toEntity(contato.getAuditoria()))
                .build();
    }
}