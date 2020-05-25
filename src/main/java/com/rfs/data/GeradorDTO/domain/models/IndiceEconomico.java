package com.rfs.data.GeradorDTO.domain.models;


import com.rfs.data.GeradorDTO.domain.models.enumeration.SimNao;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "GEINDECO")
public class IndiceEconomico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_INDECO")
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "DS_INDECO", length = 20, nullable = false)
    private String indiceEconomico;

    @NotNull
    @Column(name = "TP_INDECO", nullable = false)
    private SimNao tipoIndice;

    @NotNull
    @Column(name = "TP_PERIODO", nullable = false)
    private SimNao periodo;

    @Embedded
    private Auditoria auditoria;

    public IndiceEconomico mergeForUpdate(IndiceEconomico indiceEconomico) {
        this.id = indiceEconomico.getId();
        this.indiceEconomico = indiceEconomico.getIndiceEconomico();
        this.tipoIndice = indiceEconomico.getTipoIndice();
        this.periodo = indiceEconomico.getPeriodo();
        return this;
    }
}
