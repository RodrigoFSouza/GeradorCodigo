package com.rfs.data.GeradorDTO.domain.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ContratoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private ZonedDateTime dataInicio;
    private ZonedDateTime dataFinal;
    private BigDecimal valorContrato; 
    private BigDecimal percentualAumento; 
    private BigDecimal valorReajuste; 
    private IndiceEconomicoDTO indiceEconomico;
    private ClienteDTO cliente;
    private AuditoriaDTO auditoria;
}