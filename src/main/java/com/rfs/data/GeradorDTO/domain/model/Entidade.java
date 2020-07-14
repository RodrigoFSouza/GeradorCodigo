package com.rfs.data.GeradorDTO.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode
@Entity
public class Entidade implements Serializable {

    @Id
    @SequenceGenerator(name = "entidade_seq", sequenceName = "entidade_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entidade_seq")
    private Long id;

    @NotBlank(message = "O nome da tabela é uma informação obrigatória")
    private String nomeDaTabela;

    @NotBlank(message = "O nome da Entidade é uma informação obrigatória")
    private String nomeEntity;


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
    private boolean usaJpa;

    @OneToMany(mappedBy = "entidade")
    private Set<Atributo> atributos;

    private List<Relacionamento> relacionamentos;

    public Entidade mergeForUpdate(Entidade entidade) {
        return this;
    }
}
