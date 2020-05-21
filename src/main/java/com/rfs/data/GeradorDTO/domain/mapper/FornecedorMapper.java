package com.rfs.data.GeradorDTO.domain.mapper;
import com.rfs.data.GeradorDTO.domain.models.Fornecedor;
import com.rfs.data.GeradorDTO.domain.dto.FornecedorDTO;

public interface FornecedorMapper {
    FornecedorDTO toDto(Fornecedor fornecedor);
    Fornecedor toEntity(FornecedorDTO fornecedorDTO);
    default Fornecedor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id);
        return fornecedor;
    }
}
