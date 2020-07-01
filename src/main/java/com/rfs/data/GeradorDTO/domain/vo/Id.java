package com.rfs.data.GeradorDTO.domain.vo;

import java.util.HashMap;
import java.util.Map;

public class Id {
    private final String nomeDaColunaNoBanco;
    private final String nomeDaColunaNaEntity;
    private final String nomeDaEntity;
    private Map<StrategiaGeracao, String> data = new HashMap<>();

    public Id(String nomeDaColunaNoBanco, String nomeDaColunaNaEntity, String nomeDaEntity, String nomeDaEntity1) {
        this.nomeDaColunaNaEntity = nomeDaColunaNaEntity;
        this.nomeDaColunaNoBanco = nomeDaColunaNoBanco;
        this.nomeDaEntity = nomeDaEntity1;
        data.put(StrategiaGeracao.GERADO_PELA_APLICACAO, getGeradoPelaAplicacao());
    }

    private String getGeradoPelaAplicacao() {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Id\n");
        builder.append("    @Column(name = " + this.nomeDaColunaNoBanco + ")\n");
        builder.append("    private Long " + this.nomeDaColunaNaEntity + ")\n\n");

        return builder.toString();
    }

    private String getComJpaIdentity() {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Id\n");
        builder.append("    @GeneratedValue(strategy = GenerationType.IDENTITY");
        builder.append("    @Column(name = " + this.nomeDaColunaNoBanco + ")\n");
        builder.append("    private Long " + this.nomeDaColunaNaEntity + ")\n\n");

        return builder.toString();
    }

    private String getComJpaSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Id\n");
        builder.append("    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=\"" + this.nomeDaEntity.toLowerCase() + "_sequence\n\")");
        builder.append("    @SequenceGenerator(name = \"" + this.nomeDaEntity.toLowerCase() + "_sequence\", sequenceName=\"" + this.nomeDaEntity.toLowerCase() + "_seq\")");
        builder.append("    @Column(name = " + this.nomeDaColunaNoBanco + ")\n");
        builder.append("    private Long " + this.nomeDaColunaNaEntity + ")\n\n");

        return builder.toString();
    }

    private String getComJpaAuto() {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Id\n");
        builder.append("    @GeneratedValue(strategy = GenerationType.AUTO");
        builder.append("    @Column(name = " + this.nomeDaColunaNoBanco + ")\n");
        builder.append("    private Long " + this.nomeDaColunaNaEntity + ")\n\n");

        return builder.toString();
    }

    public String getData(StrategiaGeracao type) {
        return this.data.get(type);
    }
}
