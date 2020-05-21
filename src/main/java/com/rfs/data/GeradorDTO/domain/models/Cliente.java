package com.rfs.data.GeradorDTO.domain.models;

import com.rfs.data.GeradorDTO.domain.models.enumeration.*;
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
@Table(name = "geclient")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_CLI")
    private Long id;

    @NotNull
    @Size(min = 4, max = 60)
    @Column(name = "NM_RAZAO", length = 60, nullable = false)
    private String nomeRazao;

    @NotNull
    @Size(min = 4, max = 60)
    @Column(name = "NM_FANTASIA", length = 60, nullable = false)
    private String nomeFantasia;

    @NotNull
    @Column(name = "TP_CLI", nullable = false)
    private TipoPessoa tipoPessoa;

    @NotNull
    @Column(name = "ST_BLOQUEADO", nullable = false)
    private SimNao bloqueado;

    @NotNull
    @Column(name = "ST_SITUACAO", nullable = false)
    private Situacao situacao;

    @Column(name = "NR_CGC_CPF")
    private Long cgcCpf;

    @Size(max = 20)
    @Column(name = "NR_INSC_EST", length = 20)
    private String inscricaoEstadual;

    @Column(name = "VL_LIMIT_CRED", precision = 21, scale = 2)
    private BigDecimal valorLimiteCredito;

    @Column(name = "NR_DIAS_ATRASO")
    private Integer numeroDiasAtraso;

    @Column(name = "DT_ULT_ATRASO")
    private ZonedDateTime dataUltimoAtraso;

    @Column(name = "VL_ULT_ATRASO", precision = 21, scale = 2)
    private BigDecimal valorUltimoAtraso;

    @Column(name = "VL_MAIOR_FAT", precision = 21, scale = 2)
    private BigDecimal valorMaiorFatura;

    @Column(name = "DT_MAIOR_FAT")
    private ZonedDateTime dataMaiorFatura;

    @Column(name = "VL_ACUM_FAT", precision = 21, scale = 2)
    private BigDecimal valorAcumuladoFatura;

    @Size(max = 30)
    @Column(name = "DS_MARCA", length = 30)
    private String marca;

    @Size(max = 500)
    @Column(name = "OB_CLIENTE", length = 500)
    private String observacao;

    @Column(name = "QT_DIAS_DESTINO", precision = 21, scale = 2)
    private BigDecimal quantidadeDiasDestino;

    @Size(max = 15)
    @Column(name = "NR_INSC_MUNICIPAL", length = 15)
    private String inscricaoMunicipal;

    @NotNull
    @Column(name = "ST_INCIDE_IPI_NO_ICMS", nullable = false)
    private SimNao indiceIpiNoIcms;

    @Size(max = 2000)
    @Column(name = "DS_EMAIL_NFE", length = 2000)
    private String emailNfe;

    @NotNull
    @Column(name = "TP_COMERCIALIZACAO", nullable = false)
    private TipoComercio tipoComercializacao;

    @Column(name = "PC_MARGEM_LUCRO", precision = 21, scale = 2)
    private BigDecimal percentualDeMargemLucro;

    @Column(name = "ST_OBS_CLIENTE_FATURAMENTO")
    private SimNao observacaoClienteFaturamento;

    @Column(name = "ST_DIFERIMENTO_ICMS")
    private SimNao diferimentoICMS;

    @Column(name = "ST_SUSPENSAO_IPI")
    private SimNao suspensaoIpi;

    @Column(name = "TP_FRETE")
    private TipoFrete tipoFrete;

    @Column(name = "DT_CLIENTE_DESDE")
    private ZonedDateTime clienteDesde;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_CLASS_CLI")
    private ClassificacaoCliente classificacaoCliente;

    @Size(max = 500)
    @Column(name = "OB_TRIBUTARIA", length = 500)
    private String observacaoTributaria;

    @Size(max = 60)
    @Column(name = "DS_EMAIL_NFE_XML", length = 60)
    private String emailNfeXml;

    @NotNull

    @Column(name = "ST_SUSPENSAO_ICMS", nullable = false)
    private SimNao situacaoSuspensaoIcms;

    @Size(max = 600)
    @Column(name = "DS_MENSAGEM_LAUDO", length = 600)
    private String mensagemLaudo;

    @OneToMany(mappedBy = "cliente")
    private Set<Contato> contatos = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private Set<Contabil> contas = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private Set<Contrato> contratos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "CD_TP_ATIVIDADE")
    @JsonIgnoreProperties("clientes")
    private TipoAtividade tipoAtividade;

    @ManyToOne
    @JoinColumn(name = "CD_FORMA_PAGTO")
    @JsonIgnoreProperties("clientes")
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "CD_PGTO")
    @JsonIgnoreProperties("clientes")
    private CondicaoPagamento condicaoPagamento;

    @ManyToOne
    @JoinColumn(name = "CD_FOR_TRANSP")
    @JsonIgnoreProperties("clientes")
    private Fornecedor fornecedor;

    @Enumerated
    private Auditoria auditoria;

    public Cliente mergeForUpdate(Cliente cliente) {
        this.id = cliente.getId();
        this.nomeRazao = cliente.getNomeRazao();
        this.nomeFantasia = cliente.getNomeFantasia();
        this.tipoPessoa = cliente.getTipoPessoa();
        this.bloqueado = cliente.getBloqueado();
        this.situacao = cliente.getSituacao();
        this.cgcCpf = cliente.getCgcCpf();
        this.inscricaoEstadual = cliente.getInscricaoEstadual();
        this.valorLimiteCredito = cliente.getValorLimiteCredito();
        this.numeroDiasAtraso = cliente.getNumeroDiasAtraso();
        this.dataUltimoAtraso = cliente.getDataUltimoAtraso();
        this.valorUltimoAtraso = cliente.getValorUltimoAtraso();
        this.valorMaiorFatura = cliente.getValorMaiorFatura();
        this.dataMaiorFatura = cliente.getDataMaiorFatura();
        this.valorAcumuladoFatura = cliente.getValorAcumuladoFatura();
        this.marca = cliente.getMarca();
        this.observacao = cliente.getObservacao();
        this.quantidadeDiasDestino = cliente.getQuantidadeDiasDestino();
        this.inscricaoMunicipal = cliente.getInscricaoMunicipal();
        this.indiceIpiNoIcms = cliente.getIndiceIpiNoIcms();
        this.emailNfe = cliente.getEmailNfe();
        this.tipoComercializacao = cliente.getTipoComercializacao();
        this.percentualDeMargemLucro = cliente.getPercentualDeMargemLucro();
        this.observacaoClienteFaturamento = cliente.getObservacaoClienteFaturamento();
        this.diferimentoICMS = cliente.getDiferimentoICMS();
        this.suspensaoIpi = cliente.getSuspensaoIpi();
        this.tipoFrete = cliente.getTipoFrete();
        this.clienteDesde = cliente.getClienteDesde();
        this.classificacaoCliente = cliente.getClassificacaoCliente();
        this.observacaoTributaria = cliente.getObservacaoTributaria();
        this.emailNfeXml = cliente.getEmailNfeXml();
        this.situacaoSuspensaoIcms = cliente.getSituacaoSuspensaoIcms();
        this.mensagemLaudo = cliente.getMensagemLaudo();
        this.contatos = cliente.getContatos();
        this.enderecos = cliente.getEnderecos();
        this.contas = cliente.getContas();
        this.contratos = cliente.getContratos();
        this.tipoAtividade = cliente.getTipoAtividade();
        this.formaPagamento = cliente.getFormaPagamento();
        this.condicaoPagamento = cliente.getCondicaoPagamento();
        this.fornecedor = cliente.getFornecedor();
        return this;
    }
}
