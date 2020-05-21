package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.Veiculo;
import com.rfs.data.GeradorDTO.domain.dto.VeiculoDTO;

public interface VeiculoMapper {
    VeiculoDTO toDto(Veiculo veiculo);
    Veiculo toEntity(VeiculoDTO veiculoDTO);
    default Veiculo fromId(Long id) {
        if (id == null) {
            return null;
        }
        Veiculo veiculo = new Veiculo();
        veiculo.setId(id);
        return veiculo;
    }
}
