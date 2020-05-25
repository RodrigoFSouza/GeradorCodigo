package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.dto.ClienteDTO;
import com.rfs.data.GeradorDTO.domain.models.Cliente;

public interface ClienteMapper {
    ClienteDTO toDto(Cliente cliente);
    Cliente toEntity(ClienteDTO clienteDTO);
    default Cliente fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return cliente;
    }
}
