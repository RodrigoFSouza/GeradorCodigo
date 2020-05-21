package com.rfs.data.GeradorDTO.domain.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "GECONCOR")
public class Concorrente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_CONCORRENTE")
    private Long id;

    @NotNull
    @Size(max = 60)
    @Column(name = "NM_RAZAO", length = 60, nullable = false)
    private String nomeRazao;

    @NotNull
    @Size(max = 60)
    @Column(name = "NM_FANTASIA", length = 60, nullable = false)
    private String nomeFantasia;

    @Max(value = 14)
    @Column(name = "NR_CNPJ")
    private BigDecimal cnpj;

    @Column(name = "NR_INSC_EST", precision = 21, scale = 2)
    private BigDecimal inscricaoEstadual;

    @Embedded
    private Auditoria auditoria;

    public Concorrente mergeForUpdate(Concorrente concorrente) {
        this.id = concorrente.getId();
        this.nomeRazao = concorrente.getNomeRazao();
        this.nomeFantasia = concorrente.getNomeFantasia();
        this.cnpj = concorrente.getCnpj();
        this.inscricaoEstadual = concorrente.getInscricaoEstadual();
        return this;
    }
}
