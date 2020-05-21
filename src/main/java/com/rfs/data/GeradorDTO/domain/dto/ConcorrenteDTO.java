package com.rfs.data.GeradorDTO.domain.dto;

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
public class ConcorrenteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String nomeRazao; 
    private String nomeFantasia; 
    private BigDecimal cnpj; 
    private BigDecimal inscricaoEstadual; 
    private AuditoriaDTO auditoria;
}