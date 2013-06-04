package masterfila.jsf.cadastro;

import java.util.List;

import masterfila.jsf.entidade.Estabelecimento;
import masterfila.jsf.repositorio.RepositorioEstabelecimento;

public class CadastroEstabelecimento {

	private RepositorioEstabelecimento rep;
	
	public CadastroEstabelecimento(RepositorioEstabelecimento rep){
		this.rep = rep;
	}
	
	public void cadastrar(Estabelecimento novo){
		rep.inserir(novo);
	}
	
	public void atualizar(Estabelecimento atual){
		rep.atualizar(atual);
	}
	
	public void remover(Estabelecimento deletado){
		rep.remover(deletado);
	}
	
	public List<Estabelecimento> listar(){
		return rep.listar();
	}
}
