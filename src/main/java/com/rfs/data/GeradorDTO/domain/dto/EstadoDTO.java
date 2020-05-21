package com.rfs.data.GeradorDTO.domain.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class EstadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; 
    private String nome; 
    private String codigoIBGE; 
    private PaisDTO pais;
    private AuditoriaDTO auditoria;
}