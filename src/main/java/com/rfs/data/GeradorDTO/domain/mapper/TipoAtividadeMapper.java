package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.TipoAtividade;
import com.rfs.data.GeradorDTO.domain.dto.TipoAtividadeDTO;

public interface TipoAtividadeMapper {
    TipoAtividadeDTO toDto(TipoAtividade tipoAtividade);
    TipoAtividade toEntity(TipoAtividadeDTO tipoAtividadeDTO);
    default TipoAtividade fromId(Long id) {
        if (id == null) {
            return null;
        }
        TipoAtividade tipoAtividade = new TipoAtividade();
        tipoAtividade.setId(id);
        return tipoAtividade;
    }
}
