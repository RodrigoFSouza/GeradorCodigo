package com.rfs.data.GeradorDTO.domain.dto;

import com.rfs.data.GeradorDTO.domain.models.enumeration.Situacao;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoFornecimento;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoPessoa;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class FornecedorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String nomeRazao; 
    private String nomeFantasia; 
    private TipoPessoa tipoPessoa; 
    private Situacao situacao; 
    private TipoFornecimento tipoFornecimento; 
    private Long cgcCpf; 
    private BigDecimal valorAcumuladoCompra; 
    private ZonedDateTime dataUltimaCompra; 
    private BigDecimal valorUltimaCompra; 
    private String observacao; 
    private String incricaoEstadual; 
    private String emailNfe; 
    private String inscricaoMunicipal; 
    private Set<EnderecoDTO> enderecos;
    private TipoAtividadeDTO tipoAtividade;
    private AuditoriaDTO auditoria;
}