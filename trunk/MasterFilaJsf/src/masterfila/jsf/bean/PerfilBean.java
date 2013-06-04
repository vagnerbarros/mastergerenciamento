package masterfila.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import masterfila.jsf.entidade.Funcionario;
import masterfila.jsf.fachada.Fachada;
import masterfila.jsf.util.FacesContextUtil;

@ManagedBean(name = "perfil")
@SessionScoped
public class PerfilBean {

	private Funcionario funcionario;
	
	private String nome;
	private String cpf;
	private String login;
	private String senha;
	private String re_senha;
	private String senha_antiga;
	
	public PerfilBean(){
		funcionario = FacesContextUtil.getFuncionarioSessao();
		nome = funcionario.getNome();
		cpf = funcionario.getCpf();
	}
	
	public String alterar(){
		Fachada fachada = Fachada.getInstance();
		String navegacao = "";
		if(senha.equals(re_senha)){
			if(senha_antiga.equals(funcionario.getSenha())){
				funcionario.setSenha(senha);
				funcionario.setLogin(login);
				fachada.cadastroFuncionario().atualizar(funcionario);
				FacesContextUtil.setMessageInformacao("Sucesso.", "Seu Perfil foi atualizado com sucesso.");
				navegacao = "perfil";
			}
			else{
				FacesContextUtil.setMessageErro("Erro", "A senha antiga informada está incorreta.");
			}
		}
		else{
			FacesContextUtil.setMessageErro("Erro", "Senha e Confirmação não são iguais.");
		}
		return navegacao;
	}
	
	public void limpar(){
		login = "";
		senha = "";
		re_senha = "";
		senha_antiga = "";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRe_senha() {
		return re_senha;
	}

	public void setRe_senha(String re_senha) {
		this.re_senha = re_senha;
	}

	public String getSenha_antiga() {
		return senha_antiga;
	}

	public void setSenha_antiga(String senha_antiga) {
		this.senha_antiga = senha_antiga;
	}
}
