package masterfila.jsf.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	
	public void logar() throws IOException{
		
		try {
			Funcionario funcionario = Fachada.getInstance().cadastroFuncionario().logar(login, senha);
			FacesContextUtil.setFuncionarioSessao(funcionario);
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.jsf");
		} catch (LoginSenhaIncorretosException e) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf?erro=true");
		}
		
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
