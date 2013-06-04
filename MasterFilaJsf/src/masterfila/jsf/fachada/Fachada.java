package masterfila.jsf.fachada;

import masterfila.jsf.cadastro.CadastroEstabelecimento;
import masterfila.jsf.cadastro.CadastroFuncionario;
import masterfila.jsf.repositorio.RepositorioEstabelecimento;
import masterfila.jsf.repositorio.RepositorioFuncionario;


public class Fachada {

	private static Fachada instancia;
	private CadastroEstabelecimento cadEstabelecimento;
	private CadastroFuncionario cadFuncionario;
	
	private Fachada(){
		inicializar();
	}
	
	private void inicializar(){
		
		RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
		cadFuncionario = new CadastroFuncionario(repFuncionario);
		
		RepositorioEstabelecimento repEmpresa = new RepositorioEstabelecimento();
		cadEstabelecimento = new CadastroEstabelecimento(repEmpresa);
	}
	
	public static Fachada getInstance(){
		
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}
	
	public CadastroEstabelecimento cadastroEmpresa(){
		return cadEstabelecimento;
	}
	
	public CadastroFuncionario cadastroFuncionario(){
		return cadFuncionario;
	}
}