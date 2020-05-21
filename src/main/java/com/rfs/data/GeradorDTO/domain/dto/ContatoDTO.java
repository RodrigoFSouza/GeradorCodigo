package com.rfs.data.GeradorDTO.domain.dto;

import com.rfs.data.GeradorDTO.domain.models.enumeration.Situacao;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ContatoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String nome; 
    private String telefone; 
    private String email; 
    private String observacao; 
    private String funcao; 
    private String celular; 
    private String fax; 
    private ZonedDateTime dataNascimento;
    private Situacao situacao; 
    private ClienteDTO cliente;
    private AuditoriaDTO auditoria;
}