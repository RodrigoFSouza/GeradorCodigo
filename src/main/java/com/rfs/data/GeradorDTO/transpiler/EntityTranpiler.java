package com.rfs.data.GeradorDTO.transpiler;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class EntityTranpiler {
    private String nomeDaTabela;
    private String nomeEntity;
    private Set<FieldTranspiler> fields;
    private List<Relacionamento> relacionamentos;
    private Boolean geraId;
    private Boolean usaLoombok;
    private Boolean geraRepositorio;
    private Boolean geraService;
    private Boolean geraDto;
    private Boolean geraPesquisa;
    private Boolean geraTeste;
    private Boolean geraLiquibase;
}


