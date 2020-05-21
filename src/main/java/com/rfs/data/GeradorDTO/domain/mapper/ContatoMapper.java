package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.Contato;
import com.rfs.data.GeradorDTO.domain.dto.ContatoDTO;

public interface ContatoMapper {
    ContatoDTO toDto(Contato contato);
    Contato toEntity(ContatoDTO contatoDTO);
    default Contato fromId(Long id) {
        if (id == null) {
            return null;
        }
        Contato contato = new Contato();
        contato.setId(id);
        return contato;
    }
}
