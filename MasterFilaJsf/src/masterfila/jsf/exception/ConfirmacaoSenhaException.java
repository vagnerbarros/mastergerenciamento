package masterfila.jsf.exception;

public class ConfirmacaoSenhaException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public ConfirmacaoSenhaException(){
		this.mensagem = "Senha e Confirmação de Senha não conferem.";
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
