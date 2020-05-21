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
public class FormaPagamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; 
    private String formaPagamento; 
    private SimNao cheque; 
    private SimNao descontadoBanco; 
    private SimNao boleto; 
    private String formaPagamentoReceita; 
    private AuditoriaDTO auditoria;
}