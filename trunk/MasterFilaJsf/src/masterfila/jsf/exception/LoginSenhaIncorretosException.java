package masterfila.jsf.exception;

public class LoginSenhaIncorretosException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public LoginSenhaIncorretosException(){
		this.mensagem = "Login e Senha incorretos.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
