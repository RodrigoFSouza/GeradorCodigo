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
public class CidadeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String nome; 
    private Integer ddd; 
    private String cepGeral; 
    private String codigoIBGE; 
    private Long pais; 
    private EstadoDTO estado;
    private RegiaoDTO regiao;
    private AuditoriaDTO auditoria;
}