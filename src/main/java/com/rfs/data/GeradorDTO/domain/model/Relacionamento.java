package com.rfs.data.GeradorDTO.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
public class Relacionamento {

    @Id
    @SequenceGenerator(name = "entidade_seq", sequenceName = "entidade_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entidade_seq")
    private Long id;
    private String tipo;
    private String direcao;
    private String tabelaReferencia;
    private String nomeEntidade;
    private String nomeAtributoReferencia;
    private String colunaReferencia;
}
