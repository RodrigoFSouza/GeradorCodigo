package com.rfs.data.GeradorDTOdomain.models;
import javax.validation.constraints.*;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import lombok.Builder;

@Data
@Entity
@Builder
@Table(name = "GEEMPRESA")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "CD_EMPRESA")
    private LONG id;

    @NotNull
    Size(max = 240)
    @Column(name = "DS_EMAIL")
    private String email;

    @NotNull
    Size(max = 60)
    @Column(name = "NM_EMPRESA")
    private String nomeEmpresa;

    @NotNull
    @Column(name = "DS_DATA_FUNDACAO")
    private LocalDate dataFundacao;

    @NotNull
    Size(max = 22)
    @Column(name = "DS_TELEFONE")
    private String telefone;

   public Empresa mergeForUpdate(Empresa Empresa) {
        this.id = Empresa.getId();
        this.email = Empresa.getEmail();
        this.nomeEmpresa = Empresa.getNomeEmpresa();
        this.dataFundacao = Empresa.getDataFundacao();
        this.telefone = Empresa.getTelefone();
        return this;
    }
}