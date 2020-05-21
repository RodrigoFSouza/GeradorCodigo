package com.rfs.data.GeradorDTO.domain.mapper.implementation;

import com.rfs.data.GeradorDTO.domain.dto.VeiculoDTO;
import com.rfs.data.GeradorDTO.domain.mapper.AuditoriaMapper;
import com.rfs.data.GeradorDTO.domain.mapper.CidadeMapper;
import com.rfs.data.GeradorDTO.domain.mapper.VeiculoMapper;
import com.rfs.data.GeradorDTO.domain.models.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;

public class VeiculoMapperImpl implements VeiculoMapper {
    private CidadeMapper cidadeMapper;
    private AuditoriaMapper auditoriaMapper;

    @Autowired
    public VeiculoMapperImpl(CidadeMapper cidadeMapper, AuditoriaMapper auditoriaMapper) {
        this.cidadeMapper = cidadeMapper;
        this.auditoriaMapper = auditoriaMapper;
    }

    @Override
    public VeiculoDTO toDto(Veiculo veiculo) {
        return VeiculoDTO.builder()
                .id(veiculo.getId())
                .placa(veiculo.getPlaca())
                .tara(veiculo.getTara())
                .anoFabricacao(veiculo.getAnoFabricacao())
                .anoModelo(veiculo.getAnoModelo())
                .capacidadeDeCarga(veiculo.getCapacidadeDeCarga())
                .situacao(veiculo.getSituacao())
                .tipoCarroceria(veiculo.getTipoCarroceria())
                .tipoRodado(veiculo.getTipoRodado())
                .cidade(cidadeMapper.toDto(veiculo.getCidade()))
                .auditoria(auditoriaMapper.toDto(veiculo.getAuditoria()))
                .build();
    }

    @Override
    public Veiculo toEntity(VeiculoDTO veiculo) {
        return Veiculo.builder()
                .id(veiculo.getId())
                .placa(veiculo.getPlaca())
                .tara(veiculo.getTara())
                .anoFabricacao(veiculo.getAnoFabricacao())
                .anoModelo(veiculo.getAnoModelo())
                .capacidadeDeCarga(veiculo.getCapacidadeDeCarga())
                .situacao(veiculo.getSituacao())
                .tipoCarroceria(veiculo.getTipoCarroceria())
                .tipoRodado(veiculo.getTipoRodado())
                .cidade(cidadeMapper.toEntity(veiculo.getCidade()))
                .auditoria(auditoriaMapper.toEntity(veiculo.getAuditoria()))
                .build();
    }
}