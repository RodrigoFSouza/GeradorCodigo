package com.rfs.data.GeradorDTO.domain.dto;

import com.rfs.data.GeradorDTO.domain.models.enumeration.SimNao;
import com.rfs.data.GeradorDTO.domain.models.enumeration.Situacao;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoPagamentoVendedor;
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
public class VendedorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String nomeRazao; 
    private String nomeFantasia; 
    private TipoPessoa tipoPessoa; 
    private Situacao situacao; 
    private Long cgcCpf; 
    private String inscricaoEstadual; 
    private ZonedDateTime dataUltimaVenda; 
    private BigDecimal valorUltimaVenda; 
    private BigDecimal valorAcumuladoVenda; 
    private String observacao; 
    private BigDecimal percentualDeComissao; 
    private BigDecimal percentualDeMargemLucro; 
    private TipoPagamentoVendedor tipoPagamentoComissao; 
    private Integer numeroDiaDoMesPagamento; 
    private BigDecimal percentualEncargosComissao; 
    private SimNao ehRepresentante; 
    private Set<EnderecoDTO> enderecos;
    private FornecedorDTO fornecedor;
    private AuditoriaDTO auditoria;
}