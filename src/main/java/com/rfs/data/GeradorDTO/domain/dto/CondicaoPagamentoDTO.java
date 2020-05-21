package com.rfs.data.GeradorDTO.domain.dto;

import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoPagamento;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoUtilizacao;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class CondicaoPagamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String descricao; 
    private TipoPagamento tipoPagamento; 
    private TipoUtilizacao tipoUtilizacao; 
    private BigDecimal encargosFinanceiros; 
    private AuditoriaDTO auditoria;
}