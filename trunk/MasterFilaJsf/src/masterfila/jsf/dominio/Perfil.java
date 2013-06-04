package masterfila.jsf.dominio;

public class Perfil {

	public static String ADMIN = "Administrador";
	public static String GERENTE = "Gerente";
	public static String FUNCIONARIO = "Funcionário";
	public static String CLIENTE = "Cliente";
	
	public static String[] getPerfis(){
		String [] retorno = {GERENTE, FUNCIONARIO, CLIENTE};
		return retorno;
	}
	
	public static String[] getPerfilFuncionario(){
		String [] retorno = {GERENTE, FUNCIONARIO};
		return retorno;
	}
}
