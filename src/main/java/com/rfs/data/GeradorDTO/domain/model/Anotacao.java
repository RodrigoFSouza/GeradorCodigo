package com.rfs.data.GeradorDTO.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
public class Anotacao {
    @Id
    @SequenceGenerator(name = "entidade_seq", sequenceName = "entidade_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entidade_seq")
    private Long id;

    private String nome;
    private String corpo;
}
