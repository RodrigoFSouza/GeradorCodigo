package com.rfs.data.GeradorDTO.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Atributo implements Serializable {
    @Id
    @SequenceGenerator(name = "campo_seq", sequenceName = "campo_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campo_seq")
    private Long id;

    @NotBlank(message = "Informe um modificador de acesso")
    private String modificadorDeAcesso;

    @NotBlank(message = "Informe o nome do campo no banco de dados")
    private String nomeCampoTabela;

    @NotBlank(message = "Informe o nome do campo no java")
    private String nomeCampoEntity;

    @NotBlank(message = "Informe o tipo de dado que sera armazenado neste campo")
    private String tipo;

    @NotBlank(message = "Informe se o campo poderá armazenar valores nulos ou vazios")
    private boolean requerido;

    private String campoId;

    private BigInteger tamanhoCampo;

    private BigInteger comprimentoMinimo;

    private BigInteger comprimentoMaximo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidade")
    private Entidade entidade;

    private List<Anotacao> anotacoes;

    public String imprimeAtributo() {
        return "";
    }

    public void addAnotacao(Anotacao anotacao) {
        this.anotacoes.add(anotacao);
    }

    public Atributo mergeForUpdate(Atributo atributo) {
        return this;
    }
}
