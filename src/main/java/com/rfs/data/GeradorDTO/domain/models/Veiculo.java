package com.rfs.data.GeradorDTO.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rfs.data.GeradorDTO.domain.models.enumeration.Situacao;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoCarroceria;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoRodado;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
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
@Table(name = "GEVEICUL")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_VEICULO")
    private Long id;

    @NotNull
    @Size(max = 8)
    @Column(name = "DS_PLACA", length = 8, nullable = false)
    private String placa;

    @NotNull
    @DecimalMax(value = "12")
    @Column(name = "QT_TARA", precision = 21, scale = 2, nullable = false)
    private BigDecimal tara;

    @NotNull
    @Column(name = "NR_ANO_FABRICACAO", nullable = false)
    private Integer anoFabricacao;

    @NotNull
    @Column(name = "NR_ANO_MODELO", nullable = false)
    private Integer anoModelo;

    @NotNull
    @Column(name = "QT_CAPACIDADE_CARGA", precision = 21, scale = 2, nullable = false)
    private BigDecimal capacidadeDeCarga;

    @Column(name = "ST_SITUACAO")
    private Situacao situacao;

    @Column(name = "TP_CARROCERIA")
    private TipoCarroceria tipoCarroceria;

    @Column(name = "TP_RODADO")
    private TipoRodado tipoRodado;

    @ManyToOne
    @JoinColumn(name = "CD_CIDADE_LICENCIAMENTO")
    @JsonIgnoreProperties("veiculos")
    private Cidade cidade;

    @Embedded
    private Auditoria auditoria;

    public Veiculo mergeForUpdate(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.placa = veiculo.getPlaca();
        this.tara = veiculo.getTara();
        this.anoFabricacao = veiculo.getAnoFabricacao();
        this.anoModelo = veiculo.getAnoModelo();
        this.capacidadeDeCarga = veiculo.getCapacidadeDeCarga();
        this.situacao = veiculo.getSituacao();
        this.tipoCarroceria = veiculo.getTipoCarroceria();
        this.tipoRodado = veiculo.getTipoRodado();
        this.cidade = veiculo.getCidade();
        return this;
    }

}
