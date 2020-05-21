package com.rfs.data.GeradorDTO.domain.dto;

import com.rfs.data.GeradorDTO.domain.models.enumeration.Situacao;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoCarroceria;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoRodado;
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
public class VeiculoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String placa; 
    private BigDecimal tara; 
    private Integer anoFabricacao; 
    private Integer anoModelo; 
    private BigDecimal capacidadeDeCarga; 
    private Situacao situacao; 
    private TipoCarroceria tipoCarroceria; 
    private TipoRodado tipoRodado; 
    private CidadeDTO cidade;
    private AuditoriaDTO auditoria;
}