package com.rfs.data.GeradorDTO.domain.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class AuditoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String usuarioInclusao; 
    private String usuarioAlteracao; 
    private LocalDateTime dataInclusao; 
    private LocalDateTime dataAlteracao; 
}