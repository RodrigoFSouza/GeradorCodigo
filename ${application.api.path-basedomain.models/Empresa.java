${application.api.package-basedomain.models;
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


    @NotNull
    Size(max = 240)
    @Column(name = "DS_EMAIL")
    private String email;

    @NotNull
    @Column(name = "DS_DATA_FUNDACAO")
    private LocalDate dataFundacao;

    @NotNull
    Size(max = 22)
    @Column(name = "DS_TELEFONE")
    private String telefone;

    @Id
    @Column(name = "CD_EMPRESA")
    private LONG id;

    @NotNull
    Size(max = 60)
    @Column(name = "NM_EMPRESA")
    private String nomeEmpresa;

nullnullnullnull    public Empresa mergeForUpdate(Empresa Empresa) {
        this.email = Empresa.getEmail();
        this.dataFundacao = Empresa.getDataFundacao();
        this.telefone = Empresa.getTelefone();
        this.id = Empresa.getId();
        this.nomeEmpresa = Empresa.getNomeEmpresa();
        return this;
    }
}