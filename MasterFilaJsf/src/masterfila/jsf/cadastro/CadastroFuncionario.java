package masterfila.jsf.cadastro;

import masterfila.jsf.entidade.Funcionario;
import masterfila.jsf.exception.ConfirmacaoSenhaException;
import masterfila.jsf.exception.LoginSenhaIncorretosException;
import masterfila.jsf.repositorio.RepositorioFuncionario;

public class CadastroFuncionario {

	private RepositorioFuncionario rep;
	
	public CadastroFuncionario(RepositorioFuncionario rep){
		this.rep = rep;
	}
	
	public void verificarSenhaConfirmacao(String senha, String confirmacao) throws ConfirmacaoSenhaException{
		if(!senha.equals(confirmacao)){
			throw new ConfirmacaoSenhaException();
		}
	}
	
	public void atualizar(Funcionario atual){
		rep.atualizar(atual);
	}
	
	public Funcionario logar(String login, String senha) throws LoginSenhaIncorretosException{
		Funcionario logado = rep.buscarLoginSenhaAdmin(login, senha);
		if(logado != null){
			return logado;
		}
		else{
			throw new LoginSenhaIncorretosException();
		}
	}
}
