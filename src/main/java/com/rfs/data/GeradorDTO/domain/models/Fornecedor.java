package com.rfs.data.GeradorDTO.domain.models;


import com.rfs.data.GeradorDTO.domain.models.enumeration.Situacao;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoFornecimento;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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
@Table(name = "gefornec")
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_FOR")
    private Long id;

    @NotNull
    @Size(max = 60)
    @Column(name = "NM_RAZAO", length = 60, nullable = false)
    private String nomeRazao;

    @NotNull
    @Size(max = 60)
    @Column(name = "NM_FANTASIA", length = 60, nullable = false)
    private String nomeFantasia;

    @NotNull
    @Column(name = "TP_FOR", nullable = false)
    private TipoPessoa tipoPessoa;

    @NotNull
    @Column(name = "ST_SITUACAO", nullable = false)
    private Situacao situacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TP_FORNECIMENTO", nullable = false)
    private TipoFornecimento tipoFornecimento;

    @Column(name = "NR_CGC_CPF")
    private Long cgcCpf;

    @Column(name = "VL_ACUM_COMPRA", precision = 12, scale = 2)
    private BigDecimal valorAcumuladoCompra;

    @Column(name = "DT_ULT_COMPRA")
    private ZonedDateTime dataUltimaCompra;

    @Column(name = "VL_ULT_COMPRA", precision = 12, scale = 2)
    private BigDecimal valorUltimaCompra;

    @Size(max = 40)
    @Column(name = "OB_FOR")
    private String observacao;

    @Size(max = 20)
    @Column(name = "NR_INSC_EST", length = 20)
    private String incricaoEstadual;

    @Size(max = 2000)
    @Column(name = "DS_EMAIL_NFE", length = 2000)
    private String emailNfe;

    @Size(max = 15)
    @Column(name = "NR_INSC_MUNICIPAL", length = 15)
    private String inscricaoMunicipal;

    @OneToMany(mappedBy = "fornecedor")
    private Set<Endereco> enderecos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "CD_TP_ATIVIDADE")
    @JsonIgnoreProperties("fornecedors")
    private TipoAtividade tipoAtividade;

    @Embedded
    private Auditoria auditoria;

    public Fornecedor mergeForUpdate(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.nomeRazao = fornecedor.getNomeRazao();
        this.nomeFantasia = fornecedor.getNomeFantasia();
        this.tipoPessoa = fornecedor.getTipoPessoa();
        this.situacao = fornecedor.getSituacao();
        this.tipoFornecimento = fornecedor.getTipoFornecimento();
        this.cgcCpf = fornecedor.getCgcCpf();
        this.valorAcumuladoCompra = fornecedor.getValorAcumuladoCompra();
        this.dataUltimaCompra = fornecedor.getDataUltimaCompra();
        this.valorUltimaCompra = fornecedor.getValorUltimaCompra();
        this.observacao = fornecedor.getObservacao();
        this.incricaoEstadual = fornecedor.getIncricaoEstadual();
        this.emailNfe = fornecedor.getEmailNfe();
        this.inscricaoMunicipal = fornecedor.getInscricaoMunicipal();
        this.enderecos = fornecedor.getEnderecos();
        this.tipoAtividade = fornecedor.getTipoAtividade();
        return this;
    }
}
