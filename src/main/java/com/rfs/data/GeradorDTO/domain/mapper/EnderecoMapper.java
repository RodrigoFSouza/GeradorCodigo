package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.Endereco;
import com.rfs.data.GeradorDTO.domain.dto.EnderecoDTO;

public interface EnderecoMapper {
    EnderecoDTO toDto(Endereco endereco);
    Endereco toEntity(EnderecoDTO enderecoDTO);
    default Endereco fromId(Long id) {
        if (id == null) {
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setId(id);
        return endereco;
    }
}
