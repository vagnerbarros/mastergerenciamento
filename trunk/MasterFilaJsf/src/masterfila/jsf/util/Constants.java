package masterfila.jsf.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	
	//indica se a tupla está ou não ativa.
	public static String ATIVO = "ATIVO";
	public static String INATIVO = "INATIVO";
	
	public static String [] listaEstados = {"Pernambuco"};
	
	public static String [] listaCidades = {"Caruaru", "São Caetano", "Toritama", "Santa Cruz"};
	
	public static int getPosicaoEstado(String estado){
		int retorno = -1;
		for(int i = 0; i < listaEstados.length; i++){
			if(listaEstados[i].equals(estado)){
				retorno = i;
				break;
			}
		}
		return retorno;
	}
}
