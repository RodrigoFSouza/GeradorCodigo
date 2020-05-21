package com.rfs.data.GeradorDTO.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "GECIDADE")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_CIDADE")
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "NM_CIDADE", length = 30, nullable = false)
    private String nome;

    @NotNull
    @Max(value = 4)
    @Column(name = "CD_DDD", nullable = false)
    private Integer ddd;

    @NotNull
    @Size(max = 8)
    @Column(name = "CD_CEP_GERAL", length = 8, nullable = false)
    private String cepGeral;

    @Size(max = 7)
    @Column(name = "CD_IBGE", length = 7)
    private String codigoIBGE;

    @Column(name = "CD_PAIS")
    private Long pais;

    @NotNull(message = "Campo estado não informado")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CD_ESTADO")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estado estado;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CD_REGIAO")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Regiao regiao;

    @Embedded
    private Auditoria auditoria;

    public Cidade mergeForUpdate(Cidade cidade) {
        this.id = cidade.getId();
        this.nome = cidade.getNome();
        this.ddd = cidade.getDdd();
        this.cepGeral = cidade.getCepGeral();
        this.codigoIBGE = cidade.getCodigoIBGE();
        this.estado = cidade.getEstado();
        this.regiao = cidade.getRegiao();
        return this;
    }
}
