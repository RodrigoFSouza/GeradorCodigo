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
public class PaisDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String nome; 
    private Integer codigoIBGE; 
    private AuditoriaDTO auditoria;
}