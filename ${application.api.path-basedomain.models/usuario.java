${application.api.package-basedomain.models;
import javax.validation.constraints.*;
import javax.persistence.*;
import java.io.Serializable;

@Table(name = "GEFUNCIO ")
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;


    Size(max = 600)
    @Column(name = "DS_EMAIL")
    private String email;

    @Column(name = "ST_EXPIRA_SENHA")
    private SimNao senhaExpira;

    @NotNull
    Size(max = 40)
    @Column(name = "NM_FUNC")
    private String nome;

    @NotNull
    @Column(name = "ST_ACESSO_FILA_PRODUCAO")
    private SimNao acessaFilaDeProducao;

    Size(max = 200)
    @Column(name = "NM_CAMINHO_ASSINATURA")
    private String caminhoAssinatura;

    Size(max = 6)
    @Column(name = "DS_SENHA_CRITICA")
    private String senhaCritica;

    @Column(name = "DT_EXPIRA_SENHA")
    private LocalDateTime dataExpiraSenha;

    @NotNull
    @Column(name = "ST_TREINAMENTO")
    private SimNao treinamento;

    Size(max = 30)
    @Column(name = "DS_ACESSO")
    private String acesso;

    @NotNull
    @Column(name = "CD_FIL")
    private Long empresa;

    @NotNull
    @Column(name = "ST_VENDEDOR")
    private SimNao vendedor;

    @NotNull
    @Column(name = "ST_ALTERA_PC_COMISSAO_VENDA")
    private SimNao alteraPercentualComissaoVenda;

    @NotNull
    @Column(name = "ST_ADMINISTRADOR")
    private SimNao administrador;

    @Column(name = "ST_SITUACAO")
    private Situacao situacao;

    @NotNull
    @Column(name = "ST_TROCA_FILIAL")
    private SimNao trocaFilial;

    @NotNull
    @Column(name = "ST_LIBERA_CRITICA")
    private SimNao liberaCritica;

    @Column(name = "ST_USUARIO_MASTER")
    private SimNao usuarioMaster;

    @NotNull
    @Column(name = "ST_USO_SISTEMA")
    private SimNao usaSistema;

    @Column(name = "TP_USUARIO_ORCAMENTO")
    private SimNao usuarioOrcamento;

    @Id
    @Column(name = "CD_FUNC")
    private LONG id;

    @NotNull
    @Column(name = "ST_GERA_CONTRATO")
    private SimNao geraContrtao;

    public Usuario() {
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SimNao getSenhaExpira() {
        return this.senhaExpira;
    }

    public void setSenhaExpira(SimNao senhaExpira) {
        this.senhaExpira = senhaExpira;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SimNao getAcessaFilaDeProducao() {
        return this.acessaFilaDeProducao;
    }

    public void setAcessaFilaDeProducao(SimNao acessaFilaDeProducao) {
        this.acessaFilaDeProducao = acessaFilaDeProducao;
    }

    public String getCaminhoAssinatura() {
        return this.caminhoAssinatura;
    }

    public void setCaminhoAssinatura(String caminhoAssinatura) {
        this.caminhoAssinatura = caminhoAssinatura;
    }

    public String getSenhaCritica() {
        return this.senhaCritica;
    }

    public void setSenhaCritica(String senhaCritica) {
        this.senhaCritica = senhaCritica;
    }

    public LocalDateTime getDataExpiraSenha() {
        return this.dataExpiraSenha;
    }

    public void setDataExpiraSenha(LocalDateTime dataExpiraSenha) {
        this.dataExpiraSenha = dataExpiraSenha;
    }

    public SimNao getTreinamento() {
        return this.treinamento;
    }

    public void setTreinamento(SimNao treinamento) {
        this.treinamento = treinamento;
    }

    public String getAcesso() {
        return this.acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public Long getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public SimNao getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(SimNao vendedor) {
        this.vendedor = vendedor;
    }

    public SimNao getAlteraPercentualComissaoVenda() {
        return this.alteraPercentualComissaoVenda;
    }

    public void setAlteraPercentualComissaoVenda(SimNao alteraPercentualComissaoVenda) {
        this.alteraPercentualComissaoVenda = alteraPercentualComissaoVenda;
    }

    public SimNao getAdministrador() {
        return this.administrador;
    }

    public void setAdministrador(SimNao administrador) {
        this.administrador = administrador;
    }

    public Situacao getSituacao() {
        return this.situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public SimNao getTrocaFilial() {
        return this.trocaFilial;
    }

    public void setTrocaFilial(SimNao trocaFilial) {
        this.trocaFilial = trocaFilial;
    }

    public SimNao getLiberaCritica() {
        return this.liberaCritica;
    }

    public void setLiberaCritica(SimNao liberaCritica) {
        this.liberaCritica = liberaCritica;
    }

    public SimNao getUsuarioMaster() {
        return this.usuarioMaster;
    }

    public void setUsuarioMaster(SimNao usuarioMaster) {
        this.usuarioMaster = usuarioMaster;
    }

    public SimNao getUsaSistema() {
        return this.usaSistema;
    }

    public void setUsaSistema(SimNao usaSistema) {
        this.usaSistema = usaSistema;
    }

    public SimNao getUsuarioOrcamento() {
        return this.usuarioOrcamento;
    }

    public void setUsuarioOrcamento(SimNao usuarioOrcamento) {
        this.usuarioOrcamento = usuarioOrcamento;
    }

    public LONG getId() {
        return this.id;
    }

    public void setId(LONG id) {
        this.id = id;
    }

    public SimNao getGeraContrtao() {
        return this.geraContrtao;
    }

    public void setGeraContrtao(SimNao geraContrtao) {
        this.geraContrtao = geraContrtao;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return usuario {
            "email" = this.email,
            "senhaExpira" = this.senhaExpira,
            "nome" = this.nome,
            "acessaFilaDeProducao" = this.acessaFilaDeProducao,
            "caminhoAssinatura" = this.caminhoAssinatura,
            "senhaCritica" = this.senhaCritica,
            "dataExpiraSenha" = this.dataExpiraSenha,
            "treinamento" = this.treinamento,
            "acesso" = this.acesso,
            "empresa" = this.empresa,
            "vendedor" = this.vendedor,
            "alteraPercentualComissaoVenda" = this.alteraPercentualComissaoVenda,
            "administrador" = this.administrador,
            "situacao" = this.situacao,
            "trocaFilial" = this.trocaFilial,
            "liberaCritica" = this.liberaCritica,
            "usuarioMaster" = this.usuarioMaster,
            "usaSistema" = this.usaSistema,
            "usuarioOrcamento" = this.usuarioOrcamento,
            "id" = this.id,
            "geraContrtao" = this.geraContrtao,
    }

    public Usuario mergeForUpdate(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senhaExpira = usuario.getSenhaExpira();
        this.nome = usuario.getNome();
        this.acessaFilaDeProducao = usuario.getAcessaFilaDeProducao();
        this.caminhoAssinatura = usuario.getCaminhoAssinatura();
        this.senhaCritica = usuario.getSenhaCritica();
        this.dataExpiraSenha = usuario.getDataExpiraSenha();
        this.treinamento = usuario.getTreinamento();
        this.acesso = usuario.getAcesso();
        this.empresa = usuario.getEmpresa();
        this.vendedor = usuario.getVendedor();
        this.alteraPercentualComissaoVenda = usuario.getAlteraPercentualComissaoVenda();
        this.administrador = usuario.getAdministrador();
        this.situacao = usuario.getSituacao();
        this.trocaFilial = usuario.getTrocaFilial();
        this.liberaCritica = usuario.getLiberaCritica();
        this.usuarioMaster = usuario.getUsuarioMaster();
        this.usaSistema = usuario.getUsaSistema();
        this.usuarioOrcamento = usuario.getUsuarioOrcamento();
        this.id = usuario.getId();
        this.geraContrtao = usuario.getGeraContrtao();
        return this;
    }
}