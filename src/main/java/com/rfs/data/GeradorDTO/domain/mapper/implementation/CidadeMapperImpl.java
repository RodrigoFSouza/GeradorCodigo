package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.CidadeDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.CidadeMapper;
import com.rfs.data.GeradorDTO.domain.mapper.EstadoMapper;
import com.rfs.data.GeradorDTO.domain.mapper.RegiaoMapper;
import com.rfs.data.GeradorDTO.domain.models.Cidade;
import org.springframework.beans.factory.annotation.Autowired;

public class CidadeMapperImpl implements CidadeMapper {
    private AuditoriaMapper auditoriaMapper;
    private EstadoMapper estadoMapper;
    private RegiaoMapper regiaoMapper;

    @Autowired
    public CidadeMapperImpl(AuditoriaMapper auditoriaMapper, EstadoMapper estadoMapper, RegiaoMapper regiaoMapper) {
        this.auditoriaMapper = auditoriaMapper;
        this.estadoMapper = estadoMapper;
        this.regiaoMapper = regiaoMapper;
    }

    @Override
    public CidadeDTO toDto(Cidade cidade) {
        return CidadeDTO.builder()
                .id(cidade.getId())
                .nome(cidade.getNome())
                .ddd(cidade.getDdd())
                .cepGeral(cidade.getCepGeral())
                .codigoIBGE(cidade.getCodigoIBGE())
                .pais(cidade.getPais())
                .estado(estadoMapper.toDto(cidade.getEstado()))
                .regiao(regiaoMapper.toDto(cidade.getRegiao()))
                .auditoria(auditoriaMapper.toDto(cidade.getAuditoria()))
                .build();
    }

    @Override
    public Cidade toEntity(CidadeDTO cidade) {
        return Cidade.builder()
                .id(cidade.getId())
                .nome(cidade.getNome())
                .ddd(cidade.getDdd())
                .cepGeral(cidade.getCepGeral())
                .codigoIBGE(cidade.getCodigoIBGE())
                .pais(cidade.getPais())
                .estado(estadoMapper.toEntity(cidade.getEstado()))
                .regiao(regiaoMapper.toEntity(cidade.getRegiao()))
                .auditoria(auditoriaMapper.toEntity(cidade.getAuditoria()))
                .build();
    }
}