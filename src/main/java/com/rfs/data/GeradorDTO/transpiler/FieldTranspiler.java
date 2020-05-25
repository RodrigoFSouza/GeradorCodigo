package com.rfs.data.GeradorDTO.transpiler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldTranspiler {
    private String nomeCampoTabela;
    private String nomeCampoEntity;
    private String tipo;
    private boolean requerido;
    private Integer tamanhoCampo;
    private Integer comprimentoMinimo;
    private Integer comprimentoMaximo;

}
