package com.rfs.data.GeradorDTO.domain.dto;

import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoEndereco;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private TipoEndereco tipoEndereco; 
    private String logradouro; 
    private String complemento; 
    private Long cep; 
    private Long telefone; 
    private Long fax; 
    private String contato; 
    private String email; 
    private String bairro; 
    private String numero; 
    private String site; 
    private String emailNfe; 
    private String pontoDeReferencia; 
    private String localizacaoGeografica; 
    private CidadeDTO cidade;
    private ClienteDTO cliente;
    private FornecedorDTO fornecedor;
    private VendedorDTO vendedor;
    private AuditoriaDTO auditoria;
}