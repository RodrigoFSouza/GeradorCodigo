package com.rfs.data.GeradorDTO.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rfs.data.GeradorDTO.domain.models.enumeration.Situacao;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "GECOMCLI")
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CD_COMPRADOR")
    private Long id;

    @Size(max = 40)
    @Column(name = "NM_COMPRADOR", length = 40)
    private String nome;

    @Size(max = 17)
    @Column(name = "NR_TELEFONE", length = 17)
    private String telefone;

    @Size(max = 2000)
    @Column(name = "DS_EMAIL", length = 2000)
    private String email;

    @Size(max = 2000)
    @Column(name = "DS_OBS", length = 2000)
    private String observacao;

    @Size(max = 30)
    @Column(name = "DS_FUNCAO", length = 30)
    private String funcao;

    @Size(max = 17)
    @Column(name = "NR_CELULAR", length = 17)
    private String celular;

    @Size(max = 17)
    @Column(name = "NR_FAX", length = 17)
    private String fax;

    @Column(name = "DT_NASC")
    private ZonedDateTime dataNascimento;

    @Column(name = "ST_SITUACAO")
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "CD_CLI")
    @JsonIgnoreProperties("contatoes")
    private Cliente cliente;

    @Embedded
    private Auditoria auditoria;

    public Contato mergeForUpdate(Contato contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.telefone = contato.getTelefone();
        this.email = contato.getEmail();
        this.observacao = contato.getObservacao();
        this.funcao = contato.getFuncao();
        this.celular = contato.getCelular();
        this.fax = contato.getFax();
        this.dataNascimento = contato.getDataNascimento();
        this.situacao = contato.getSituacao();
        this.cliente = contato.getCliente();
        return this;
    }
}
