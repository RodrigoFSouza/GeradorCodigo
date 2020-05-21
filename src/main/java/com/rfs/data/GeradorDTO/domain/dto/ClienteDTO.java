package com.rfs.data.GeradorDTO.domain.dto;

import com.rfs.data.GeradorDTO.domain.models.enumeration.*;
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
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String nomeRazao; 
    private String nomeFantasia; 
    private TipoPessoa tipoPessoa; 
    private SimNao bloqueado; 
    private Situacao situacao; 
    private Long cgcCpf; 
    private String inscricaoEstadual; 
    private BigDecimal valorLimiteCredito; 
    private Integer numeroDiasAtraso; 
    private ZonedDateTime dataUltimoAtraso; 
    private BigDecimal valorUltimoAtraso; 
    private BigDecimal valorMaiorFatura; 
    private ZonedDateTime dataMaiorFatura; 
    private BigDecimal valorAcumuladoFatura; 
    private String marca; 
    private String observacao; 
    private BigDecimal quantidadeDiasDestino; 
    private String inscricaoMunicipal; 
    private SimNao indiceIpiNoIcms; 
    private String emailNfe; 
    private TipoComercio tipoComercializacao; 
    private BigDecimal percentualDeMargemLucro; 
    private SimNao observacaoClienteFaturamento; 
    private SimNao diferimentoICMS; 
    private SimNao suspensaoIpi; 
    private TipoFrete tipoFrete; 
    private ZonedDateTime clienteDesde; 
    private ClassificacaoCliente classificacaoCliente; 
    private String observacaoTributaria; 
    private String emailNfeXml; 
    private SimNao situacaoSuspensaoIcms; 
    private String mensagemLaudo; 
    private Set<ContatoDTO> contatos;
    private Set<EnderecoDTO> enderecos;
    private Set<ContabilDTO> contas;
    private Set<ContratoDTO> contratos;
    private TipoAtividadeDTO tipoAtividade;
    private FormaPagamentoDTO formaPagamento;
    private CondicaoPagamentoDTO condicaoPagamento;
    private FornecedorDTO fornecedor;
    private AuditoriaDTO auditoria;
}