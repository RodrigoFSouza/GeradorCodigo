package com.rfs.data.GeradorDTO.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rfs.data.GeradorDTO.domain.models.enumeration.TipoEndereco;
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
@Table(name = "GEENDERE")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_END")
    private Long id;

    @NotNull
    @Column(name = "TP_ENDERECO", nullable = false)
    private TipoEndereco tipoEndereco;

    @NotNull
    @Size(max = 40)
    @Column(name = "DS_LOGRADOURO", length = 40, nullable = false)
    private String logradouro;

    @Size(max = 40)
    @Column(name = "DS_COMPLEMENTO", length = 40)
    private String complemento;

    @NotNull
    @Column(name = "NR_CEP", nullable = false)
    private Long cep;

    @Column(name = "NR_TELEFONE")
    private Long telefone;

    @Column(name = "NR_FAX")
    private Long fax;

    @Size(max = 40)
    @Column(name = "NM_CONTATO", length = 40)
    private String contato;

    @Size(max = 40)
    @Column(name = "DS_EMAIL", length = 40)
    private String email;

    @NotNull
    @Size(max = 60)
    @Column(name = "DS_BAIRRO", length = 60, nullable = false)
    private String bairro;

    @NotNull
    @Size(max = 20)
    @Column(name = "NR_LOGRADOURO", length = 20, nullable = false)
    private String numero;

    @Size(max = 2000)
    @Column(name = "DS_SITE", length = 2000)
    private String site;

    @Size(max = 2000)
    @Column(name = "DS_EMAIL_NFE", length = 2000)
    private String emailNfe;

    @Size(max = 100)
    @Column(name = "DS_REFERENCIA", length = 100)
    private String pontoDeReferencia;

    @Size(max = 2000)
    @Column(name = "DS_LOCALIZACAO_GEOGRAFICA", length = 2000)
    private String localizacaoGeografica;

    @ManyToOne
    @JoinColumn(name = "CD_CIDADE")
    @JsonIgnoreProperties("enderecos")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "CD_CLI")
    @JsonIgnoreProperties("enderecos")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "CD_FOR")
    @JsonIgnoreProperties("enderecos")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "CD_VEND")
    @JsonIgnoreProperties("enderecos")
    private Vendedor vendedor;

    @Embedded
    private Auditoria auditoria;

    public Endereco mergeForUpdate(Endereco endereco) {
        this.id = endereco.getId();
        this.tipoEndereco = endereco.getTipoEndereco();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.cep = endereco.getCep();
        this.telefone = endereco.getTelefone();
        this.fax = endereco.getFax();
        this.contato = endereco.getContato();
        this.email = endereco.getEmail();
        this.bairro = endereco.getBairro();
        this.numero = endereco.getNumero();
        this.site = endereco.getSite();
        this.emailNfe = endereco.getEmailNfe();
        this.pontoDeReferencia = endereco.getPontoDeReferencia();
        this.localizacaoGeografica = endereco.getLocalizacaoGeografica();
        this.cidade = endereco.getCidade();
        this.cliente = endereco.getCliente();
        this.fornecedor = endereco.getFornecedor();
        this.vendedor = endereco.getVendedor();
        return this;
    }
}
