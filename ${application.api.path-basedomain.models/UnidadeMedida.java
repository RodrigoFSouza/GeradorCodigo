${application.api.package-basedomain.models;
import javax.validation.constraints.*;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import lombok.Builder;

@Data
@Entity
@Table(name = "GEUNIDADE")
@Builder
public class UnidadeMedida implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "CD_UNIDADE")
    private LONG id;

    @NotNull
    Size(max = 60)
    @Column(name = "NM_UNIDADE")
    private String nome;

nullnullnullnull    public UnidadeMedida mergeForUpdate(UnidadeMedida UnidadeMedida) {
        this.id = UnidadeMedida.getId();
        this.nome = UnidadeMedida.getNome();
        return this;
    }
}