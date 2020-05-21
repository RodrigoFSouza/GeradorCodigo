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
@Table(name = "GEFORPAG")
public class FormaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_FORMA_PAGTO")
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "DS_FORMA_PAGTO", length = 30, nullable = false)
    private String formaPagamento;

    @Column(name = "ST_CHEQUE")
    private SimNao cheque;

    @NotNull
    @Column(name = "ST_DESCONTADO_BANCO", nullable = false)
    private SimNao descontadoBanco;

    @NotNull
    @Column(name = "ST_BOLETO", nullable = false)
    private SimNao boleto;

    @NotNull
    @Size(max = 2)
    @Column(name = "CD_FORMA_PAGTO_RECEITA", length = 2, nullable = false)
    private String formaPagamentoReceita;

    @Embedded
    private Auditoria auditoria;

    public FormaPagamento mergeForUpdate(FormaPagamento formaPagamento) {
        this.id = formaPagamento.getId();
        this.formaPagamento = formaPagamento.getFormaPagamento();
        this.cheque = formaPagamento.getCheque();
        this.descontadoBanco = formaPagamento.getDescontadoBanco();
        this.boleto = formaPagamento.getBoleto();
        this.formaPagamentoReceita = formaPagamento.getFormaPagamentoReceita();
        return this;
    }
}
