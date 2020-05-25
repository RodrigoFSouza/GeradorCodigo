package com.rfs.data.GeradorDTO.transpiler;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class EntityTranspiler {
    private String nomeDaTabela;
    private String nomeEntity;
    private Set<FieldTranspiler> fields;
    private List<Relacionamento> relacionamentos;
    private boolean geraId;
    private boolean usaLoombok;
    private boolean geraBuilderEntidade;
    private boolean geraMergeForUpdate;
    private boolean geraRepository;
    private boolean geraService;
    private boolean geraDTO;
    private boolean geraPesquisa;
    private boolean geraTeste;
    private boolean geraLiquibase;
}


