package com.rfs.data.GeradorDTO.domain.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "GEREGIAO")
public class Regiao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_REGIAO")
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "NM_REGIAO", length = 80, nullable = false)
    private String nome;

    @Embedded
    private Auditoria auditoria;

    public Regiao mergeForUpdate(Regiao regiao) {
        this.nome = regiao.getNome();
        return this;
    }
}
