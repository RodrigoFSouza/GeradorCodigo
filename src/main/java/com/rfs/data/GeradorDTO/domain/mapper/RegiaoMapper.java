package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.Regiao;
import com.rfs.data.GeradorDTO.domain.dto.RegiaoDTO;

public interface RegiaoMapper {
    RegiaoDTO toDto(Regiao regiao);
    Regiao toEntity(RegiaoDTO regiaoDTO);
    default Regiao fromId(Long id) {
        if (id == null) {
            return null;
        }
        Regiao regiao = new Regiao();
        regiao.setId(id);
        return regiao;
    }
}
