packagecom.rfs.data.GeradorDTOdomain.models;
import javax.validation.constraints.*;
import javax.persistence.*;
import java.io.Serializable;

@Table(name = "GEFUNCIO ")
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;


    @NotNull
    @Column(name = "ST_GERA_CONTRATO")
    private SimNao geraContrtao;

    @Column(name = "ST_SITUACAO")
    private Situacao situacao;

    @NotNull
    @Column(name = "ST_ADMINISTRADOR")
    private SimNao administrador;

    @NotNull
    @Column(name = "ST_TREINAMENTO")
    private SimNao treinamento;

    @Column(name = "TP_USUARIO_ORCAMENTO")
    private SimNao usuarioOrcamento;

    @NotNull
    Size(max = 40)
    @Column(name = "NM_FUNC")
    private String nome;

    @NotNull
    @Column(name = "ST_TROCA_FILIAL")
    private SimNao trocaFilial;

    @Column(name = "ST_EXPIRA_SENHA")
    private SimNao senhaExpira;

    @Id
    @Column(name = "CD_FUNC")
    private LONG id;

    Size(max = 600)
    @Column(name = "DS_EMAIL")
    private String email;

    @NotNull
    @Column(name = "CD_FIL")
    private Long empresa;

    Size(max = 200)
    @Column(name = "NM_CAMINHO_ASSINATURA")
    private String caminhoAssinatura;

    @Column(name = "DT_EXPIRA_SENHA")
    private LocalDateTime dataExpiraSenha;

    @NotNull
    @Column(name = "ST_ALTERA_PC_COMISSAO_VENDA")
    private SimNao alteraPercentualComissaoVenda;

    @NotNull
    @Column(name = "ST_VENDEDOR")
    private SimNao vendedor;

    Size(max = 6)
    @Column(name = "DS_SENHA_CRITICA")
    private String senhaCritica;

    Size(max = 30)
    @Column(name = "DS_ACESSO")
    private String acesso;

    @NotNull
    @Column(name = "ST_ACESSO_FILA_PRODUCAO")
    private SimNao acessaFilaDeProducao;

    @NotNull
    @Column(name = "ST_USO_SISTEMA")
    private SimNao usaSistema;

    @NotNull
    @Column(name = "ST_LIBERA_CRITICA")
    private SimNao liberaCritica;

    @Column(name = "ST_USUARIO_MASTER")
    private SimNao usuarioMaster;

    public Usuario() {
    }
    public SimNao getGeraContrtao() {
        return this.geraContrtao;
    }

    public void setGeraContrtao(SimNao geraContrtao) {
        this.geraContrtao = geraContrtao;
    }

    public Situacao getSituacao() {
        return this.situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public SimNao getAdministrador() {
        return this.administrador;
    }

    public void setAdministrador(SimNao administrador) {
        this.administrador = administrador;
    }

    public SimNao getTreinamento() {
        return this.treinamento;
    }

    public void setTreinamento(SimNao treinamento) {
        this.treinamento = treinamento;
    }

    public SimNao getUsuarioOrcamento() {
        return this.usuarioOrcamento;
    }

    public void setUsuarioOrcamento(SimNao usuarioOrcamento) {
        this.usuarioOrcamento = usuarioOrcamento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SimNao getTrocaFilial() {
        return this.trocaFilial;
    }

    public void setTrocaFilial(SimNao trocaFilial) {
        this.trocaFilial = trocaFilial;
    }

    public SimNao getSenhaExpira() {
        return this.senhaExpira;
    }

    public void setSenhaExpira(SimNao senhaExpira) {
        this.senhaExpira = senhaExpira;
    }

    public LONG getId() {
        return this.id;
    }

    public void setId(LONG id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public String getCaminhoAssinatura() {
        return this.caminhoAssinatura;
    }

    public void setCaminhoAssinatura(String caminhoAssinatura) {
        this.caminhoAssinatura = caminhoAssinatura;
    }

    public LocalDateTime getDataExpiraSenha() {
        return this.dataExpiraSenha;
    }

    public void setDataExpiraSenha(LocalDateTime dataExpiraSenha) {
        this.dataExpiraSenha = dataExpiraSenha;
    }

    public SimNao getAlteraPercentualComissaoVenda() {
        return this.alteraPercentualComissaoVenda;
    }

    public void setAlteraPercentualComissaoVenda(SimNao alteraPercentualComissaoVenda) {
        this.alteraPercentualComissaoVenda = alteraPercentualComissaoVenda;
    }

    public SimNao getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(SimNao vendedor) {
        this.vendedor = vendedor;
    }

    public String getSenhaCritica() {
        return this.senhaCritica;
    }

    public void setSenhaCritica(String senhaCritica) {
        this.senhaCritica = senhaCritica;
    }

    public String getAcesso() {
        return this.acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public SimNao getAcessaFilaDeProducao() {
        return this.acessaFilaDeProducao;
    }

    public void setAcessaFilaDeProducao(SimNao acessaFilaDeProducao) {
        this.acessaFilaDeProducao = acessaFilaDeProducao;
    }

    public SimNao getUsaSistema() {
        return this.usaSistema;
    }

    public void setUsaSistema(SimNao usaSistema) {
        this.usaSistema = usaSistema;
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
            "geraContrtao" = this.geraContrtao,
            "situacao" = this.situacao,
            "administrador" = this.administrador,
            "treinamento" = this.treinamento,
            "usuarioOrcamento" = this.usuarioOrcamento,
            "nome" = this.nome,
            "trocaFilial" = this.trocaFilial,
            "senhaExpira" = this.senhaExpira,
            "id" = this.id,
            "email" = this.email,
            "empresa" = this.empresa,
            "caminhoAssinatura" = this.caminhoAssinatura,
            "dataExpiraSenha" = this.dataExpiraSenha,
            "alteraPercentualComissaoVenda" = this.alteraPercentualComissaoVenda,
            "vendedor" = this.vendedor,
            "senhaCritica" = this.senhaCritica,
            "acesso" = this.acesso,
            "acessaFilaDeProducao" = this.acessaFilaDeProducao,
            "usaSistema" = this.usaSistema,
            "liberaCritica" = this.liberaCritica,
            "usuarioMaster" = this.usuarioMaster,
    }

    public Usuario mergeForUpdate(Usuario usuario) {
        this.geraContrtao = usuario.getGeraContrtao();
        this.situacao = usuario.getSituacao();
        this.administrador = usuario.getAdministrador();
        this.treinamento = usuario.getTreinamento();
        this.usuarioOrcamento = usuario.getUsuarioOrcamento();
        this.nome = usuario.getNome();
        this.trocaFilial = usuario.getTrocaFilial();
        this.senhaExpira = usuario.getSenhaExpira();
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.empresa = usuario.getEmpresa();
        this.caminhoAssinatura = usuario.getCaminhoAssinatura();
        this.dataExpiraSenha = usuario.getDataExpiraSenha();
        this.alteraPercentualComissaoVenda = usuario.getAlteraPercentualComissaoVenda();
        this.vendedor = usuario.getVendedor();
        this.senhaCritica = usuario.getSenhaCritica();
        this.acesso = usuario.getAcesso();
        this.acessaFilaDeProducao = usuario.getAcessaFilaDeProducao();
        this.usaSistema = usuario.getUsaSistema();
        this.liberaCritica = usuario.getLiberaCritica();
        this.usuarioMaster = usuario.getUsuarioMaster();
        return this;
    }
}