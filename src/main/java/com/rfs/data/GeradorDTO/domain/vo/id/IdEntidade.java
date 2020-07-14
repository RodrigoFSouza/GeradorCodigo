package com.rfs.data.GeradorDTO.domain.vo.id;

public class IdEntidade {

    public static String codigoGeradoPelaAplicacao(String nomeDaColunaNaEntity, String nomeDaColunaNoBanco) {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Id\n");
        builder.append("    @Column(name = " + nomeDaColunaNoBanco + ")\n");
        builder.append("    private Long " + nomeDaColunaNaEntity + ")\n\n");

        return builder.toString();
    }

    public static String jpaIdentity(String nomeDaColunaNaEntity, String nomeDaColunaNoBanco) {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Id\n");
        builder.append("    @GeneratedValue(strategy = GenerationType.IDENTITY");
        builder.append("    @Column(name = " + nomeDaColunaNoBanco + ")\n");
        builder.append("    private Long " + nomeDaColunaNaEntity + ")\n\n");

        return builder.toString();
    }

    public static String jpaSequence(String nomeDaColunaNaEntity, String nomeDaColunaNoBanco, String nomeDaEntity) {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Id\n");
        builder.append("    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=\"" + nomeDaEntity.toLowerCase() + "_sequence\n\")");
        builder.append("    @SequenceGenerator(name = \"" + nomeDaEntity.toLowerCase() + "_sequence\", sequenceName=\"" + nomeDaEntity.toLowerCase() + "_seq\")");
        builder.append("    @Column(name = " + nomeDaColunaNoBanco + ")\n");
        builder.append("    private Long " + nomeDaColunaNaEntity + ")\n\n");

        return builder.toString();
    }

    public static String jpaAuto(String nomeDaColunaNaEntity, String nomeDaColunaNoBanco) {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Id\n");
        builder.append("    @GeneratedValue(strategy = GenerationType.AUTO)");
        builder.append("    @Column(name = " + nomeDaColunaNoBanco + ")\n");
        builder.append("    private Long " + nomeDaColunaNaEntity + ")\n\n");

        return builder.toString();
    }

    public static String jpaTable(String nomeDaColunaNaEntity, String nomeDaColunaNoBanco, String nomeDaEntity) {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Id\n");
        builder.append("    @GeneratedValue(strategy = GenerationType.TABLE, generator = \"table_id_" + nomeDaEntity.toLowerCase() + "\")");
        builder.append("    @TableGenerator(name = \"table_id_" + nomeDaEntity.toLowerCase() + "\")");
        builder.append("    @Column(name = " + nomeDaColunaNoBanco + ")\n");
        builder.append("    private Long " + nomeDaColunaNaEntity + ")\n\n");

        return builder.toString();
    }
}
