package com.rfs.data.GeradorDTO.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rfs.data.GeradorDTO.domain.models.enumeration.SimNao;
import com.rfs.data.GeradorDTO.domain.models.enumeration.Situacao;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoPagamentoVendedor;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoPessoa;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "gevended")
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_VEND")
    private Long id;

    @NotNull
    @Size(max = 40)
    @Column(name = "NM_RAZAO", length = 40, nullable = false)
    private String nomeRazao;

    @NotNull
    @Size(max = 20)
    @Column(name = "NM_FANTASIA", length = 20, nullable = false)
    private String nomeFantasia;

    @NotNull
    @Column(name = "TP_VEND", nullable = false)
    private TipoPessoa tipoPessoa;

    @NotNull
    @Column(name = "ST_SITUACAO", nullable = false)
    private Situacao situacao;

    @Column(name = "NR_CGC_CPF")
    private Long cgcCpf;

    @Size(max = 20)
    @Column(name = "NR_INSC_EST", length = 20)
    private String inscricaoEstadual;

    @Column(name = "DT_ULT_VENDA")
    private ZonedDateTime dataUltimaVenda;

    @Column(name = "VL_ULT_VENDA", precision = 21, scale = 2)
    private BigDecimal valorUltimaVenda;

    @Column(name = "VL_ACUM_VENDA", precision = 21, scale = 2)
    private BigDecimal valorAcumuladoVenda;

    @Size(max = 40)
    @Column(name = "OB_VEND", length = 40)
    private String observacao;

    @NotNull
    @Column(name = "PC_COMISSAO", precision = 21, scale = 2, nullable = false)
    private BigDecimal percentualDeComissao;

    @Column(name = "PC_MARGEM_LUCRO", precision = 21, scale = 2)
    private BigDecimal percentualDeMargemLucro;

    @Column(name = "TP_PGTO_COMISSAO")
    private TipoPagamentoVendedor tipoPagamentoComissao;

    @Column(name = "NR_DIA_PGTO_COMISSAO")
    private Integer numeroDiaDoMesPagamento;

    @Column(name = "PC_ENCARGOS_COMISSAO", precision = 21, scale = 2)
    private BigDecimal percentualEncargosComissao;

    @Column(name = "ST_REPRESENTANTE")
    private SimNao ehRepresentante;

    @OneToMany(mappedBy = "vendedor")
    private Set<Endereco> enderecos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "CD_FOR")
    @JsonIgnoreProperties("vendedors")
    private Fornecedor fornecedor;

    @Embedded
    private Auditoria auditoria;

    public Vendedor mergeForUpdate(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nomeRazao = vendedor.getNomeRazao();
        this.nomeFantasia = vendedor.getNomeFantasia();
        this.tipoPessoa = vendedor.getTipoPessoa();
        this.situacao = vendedor.getSituacao();
        this.cgcCpf = vendedor.getCgcCpf();
        this.inscricaoEstadual = vendedor.getInscricaoEstadual();
        this.dataUltimaVenda = vendedor.getDataUltimaVenda();
        this.valorUltimaVenda = vendedor.getValorUltimaVenda();
        this.valorAcumuladoVenda = vendedor.getValorAcumuladoVenda();
        this.observacao = vendedor.getObservacao();
        this.percentualDeComissao = vendedor.getPercentualDeComissao();
        this.percentualDeMargemLucro = vendedor.getPercentualDeMargemLucro();
        this.tipoPagamentoComissao = vendedor.getTipoPagamentoComissao();
        this.numeroDiaDoMesPagamento = vendedor.getNumeroDiaDoMesPagamento();
        this.percentualEncargosComissao = vendedor.getPercentualEncargosComissao();
        this.ehRepresentante = vendedor.getEhRepresentante();
        this.enderecos = vendedor.getEnderecos();
        this.fornecedor = vendedor.getFornecedor();
        return this;
    }
}
