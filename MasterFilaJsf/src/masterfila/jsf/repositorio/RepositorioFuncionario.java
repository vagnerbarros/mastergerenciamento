package masterfila.jsf.repositorio;

import java.util.List;

import masterfila.jsf.dao.Dao;
import masterfila.jsf.dominio.Perfil;
import masterfila.jsf.entidade.Funcionario;
import masterfila.jsf.util.Constants;

public class RepositorioFuncionario {

	private Dao dao;
	
	public RepositorioFuncionario(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void atualizar(Funcionario atual){
		dao.atualizarObjeto(atual);
	}
	
	public Funcionario buscarLoginSenhaAdmin(String login, String senha){
		List<Funcionario> lista = (List<Funcionario>)dao.criarQuery("FROM funcionario where login LIKE '"+ login +"'" +
				" AND senha LIKE '"+ senha +"' AND perfil like '" + Perfil.ADMIN + "' AND status <> '" + Constants.INATIVO + "'");
		if(!lista.isEmpty()){
			return lista.get(0);
		}
		else{
			return null;
		}
	}
}
