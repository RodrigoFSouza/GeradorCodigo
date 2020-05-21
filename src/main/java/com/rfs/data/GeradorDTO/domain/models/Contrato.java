package com.rfs.data.GeradorDTO.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "GECONCLI")
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_CONTRATO")
    private Long id;

    @NotNull
    @Column(name = "DT_INICIO", nullable = false)
    private ZonedDateTime dataInicio;

    @NotNull
    @Column(name = "DT_FINAL", nullable = false)
    private ZonedDateTime dataFinal;

    @NotNull
    @Column(name = "VL_CONTRATO", precision = 21, scale = 2, nullable = false)
    private BigDecimal valorContrato;

    @NotNull
    @Column(name = "PC_AUMENTO", precision = 21, scale = 2, nullable = false)
    private BigDecimal percentualAumento;

    @NotNull
    @Column(name = "VL_REAJUSTE", precision = 21, scale = 2, nullable = false)
    private BigDecimal valorReajuste;

    @ManyToOne
    @JoinColumn(name = "CD_INDECO")
    @JsonIgnoreProperties("contratoes")
    private IndiceEconomico indiceEconomico;

    @ManyToOne
    @JoinColumn(name = "CD_CLI")
    @JsonIgnoreProperties("contratoes")
    private Cliente cliente;

    @Embedded
    private Auditoria auditoria;

    public Contrato mergeForUpdate(Contrato contrato) {
        this.id = contrato.getId();
        this.dataInicio = contrato.getDataInicio();
        this.dataFinal = contrato.getDataFinal();
        this.valorContrato = contrato.getValorContrato();
        this.percentualAumento = contrato.getPercentualAumento();
        this.valorReajuste = contrato.getValorReajuste();
        this.indiceEconomico = contrato.getIndiceEconomico();
        this.cliente = contrato.getCliente();
        return this;
    }
}
