package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.dto.CidadeDTO;
import com.rfs.data.GeradorDTO.domain.models.Cidade;

public interface CidadeMapper {
    CidadeDTO toDto(Cidade cidade);
    Cidade toEntity(CidadeDTO cidadeDTO);
    default Cidade fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cidade cidade = new Cidade();
        cidade.setId(id);
        return cidade;
    }
}
