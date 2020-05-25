package com.rfs.data.GeradorDTO.domain.models;


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
@Table(name = "GETIPATI")
public class TipoAtividade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_TP_ATIVIDADE")
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "DS_TP_ATIVIDADE", length = 30, nullable = false)
    private String tipoAtividade;

    @Embedded
    private Auditoria auditoria;

    public TipoAtividade mergeForUpdate(TipoAtividade tipoAtividade) {
        this.id = tipoAtividade.getId();
        this.tipoAtividade = tipoAtividade.getTipoAtividade();
        return this;
    }
}
