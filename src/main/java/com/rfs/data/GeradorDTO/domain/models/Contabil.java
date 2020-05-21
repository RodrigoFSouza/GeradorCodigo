package com.rfs.data.GeradorDTO.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "GECLICTA")
public class Contabil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_FIL")
    private Long id;

    @Column(name = "CD_CTARED")
    private Long codigoEmpresa;

    @ManyToOne
    @JoinColumn(name = "CD_CLI")
    @JsonIgnoreProperties("contabils")
    private Cliente cliente;

    @Embedded
    private Auditoria auditoria;

    public Contabil mergeForUpdate(Contabil contabil) {
        this.id = contabil.getId();
        this.codigoEmpresa = contabil.getCodigoEmpresa();
        this.cliente = contabil.getCliente();
        return this;
    }
}
