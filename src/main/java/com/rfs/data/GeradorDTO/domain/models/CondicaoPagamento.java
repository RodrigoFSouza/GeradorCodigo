package com.rfs.data.GeradorDTO.domain.models;

import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoPagamento;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoUtilizacao;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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
@Table(name = "geconpag")
public class CondicaoPagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_PGTO")
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "DS_PGTO", length = 30, nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "TP_PGTO", nullable = false)
    private TipoPagamento tipoPagamento;

    @Column(name = "TP_UTILIZACAO")
    private TipoUtilizacao tipoUtilizacao;

    @DecimalMax(value = "5")
    @Column(name = "PC_ENCARGOS_FINANCEIROS", precision = 5, scale = 2)
    private BigDecimal encargosFinanceiros;

    @Embedded
    private Auditoria auditoria;

    public CondicaoPagamento mergeForUpdate(CondicaoPagamento condicaoPagamento) {
        this.id = condicaoPagamento.getId();
        this.descricao = condicaoPagamento.getDescricao();
        this.tipoPagamento = condicaoPagamento.getTipoPagamento();
        this.tipoUtilizacao = condicaoPagamento.getTipoUtilizacao();
        this.encargosFinanceiros = condicaoPagamento.getEncargosFinanceiros();
        return this;
    }
}
