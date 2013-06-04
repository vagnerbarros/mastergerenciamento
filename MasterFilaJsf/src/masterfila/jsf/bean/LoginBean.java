package masterfila.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import masterfila.jsf.entidade.Funcionario;
import masterfila.jsf.exception.LoginSenhaIncorretosException;
import masterfila.jsf.fachada.Fachada;
import masterfila.jsf.util.FacesContextUtil;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {

	private String login;
	private String senha;
	
	public LoginBean(){
		
	}
	
	public String logar(){
		
		String pagina = "index";
		try {
			Funcionario funcionario = Fachada.getInstance().cadastroFuncionario().logar(login, senha);
			FacesContextUtil.setMessageInformacao("Sucesso!!", "Logado com sucesso.");
			FacesContextUtil.setFuncionarioSessao(funcionario);
			pagina = "home";
			
		} catch (LoginSenhaIncorretosException e) {
			FacesContextUtil.setMessageErro("Erro!!", "Login e/ou Senha inválido");
		}
		return pagina;
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
}
