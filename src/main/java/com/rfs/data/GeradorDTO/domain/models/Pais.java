package com.rfs.data.GeradorDTO.domain.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "GEPAIS")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_PAIS")
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "NM_PAIS", length = 30, nullable = false)
    private String nome;

    @Max(value = 4)
    @Column(name = "CD_IBGE")
    private Integer codigoIBGE;

    @Embedded
    private Auditoria auditoria;

    public Pais mergeForUpdate(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
        this.codigoIBGE = pais.getCodigoIBGE();
        return this;
    }
}
