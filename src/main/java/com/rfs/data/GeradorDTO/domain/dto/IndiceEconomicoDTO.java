package com.rfs.data.GeradorDTO.domain.dto;

import com.rfs.data.GeradorDTO.domain.models.enumeration.SimNao;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class IndiceEconomicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String indiceEconomico; 
    private SimNao tipoIndice; 
    private SimNao periodo; 
    private AuditoriaDTO auditoria;
}