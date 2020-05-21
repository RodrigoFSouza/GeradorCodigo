package com.rfs.data.GeradorDTO.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "geestado")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_ESTADO")
    private String id;

    @NotNull
    @Size(max = 30)
    @Column(name = "NM_ESTADO", length = 30, nullable = false)
    private String nome;

    @Size(max = 4)
    @Column(name = "CD_IBGE", length = 4)
    private String codigoIBGE;

    @ManyToOne
    @JoinColumn(name = "CD_PAIS")
    @JsonIgnoreProperties("estados")
    private Pais pais;

    @Embedded
    private Auditoria auditoria;

    public Estado mergeForUpdate(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.codigoIBGE = estado.getCodigoIBGE();
        this.pais = estado.getPais();
        return this;
    }
}
