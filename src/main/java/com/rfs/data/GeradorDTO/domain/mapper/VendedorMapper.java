package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.dto.VendedorDTO;
import com.rfs.data.GeradorDTO.domain.models.Vendedor;

public interface VendedorMapper {
    VendedorDTO toDto(Vendedor vendedor);
    Vendedor toEntity(VendedorDTO vendedorDTO);
    default Vendedor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Vendedor vendedor = new Vendedor();
        vendedor.setId(id);
        return vendedor;
    }
}
