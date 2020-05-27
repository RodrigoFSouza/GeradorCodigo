package com.rfs.data.GeradorDTO.service;

import com.rfs.data.GeradorDTO.domain.dto.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ClienteServiceImpl implements EntityService<ClienteDTO> {
    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        return null;
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        return null;
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        return null;
    }

    @Override
    public Page<ClienteDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<ClienteDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
