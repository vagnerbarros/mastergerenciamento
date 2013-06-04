package masterfila.jsf.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import masterfila.jsf.entidade.Funcionario;

public class FacesContextUtil {
	
	private static String funcionario_admin = "funcionario_admin";

	public static void setMessageErro(String titulo, String mensagem){
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensagem);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	public static void setMessageInformacao(String titulo, String mensagem){
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}	
	
	public static void setFuncionarioSessao(Funcionario funcionario){
		setSessionAttribute(funcionario_admin, funcionario);
	}
	
	public static Funcionario getFuncionarioSessao(){
		return (Funcionario) getSessionAttribute(funcionario_admin);
	}
	
	public static void setSessionAttribute(String nomeAtributo, Object valorAtributo) {    
		try {    
		    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();    
		    if (ec != null){    
				Map<String, Object> attrMap = ec.getSessionMap();       
		        if (attrMap != null) {    
		            attrMap.put(nomeAtributo, valorAtributo);    
		        }     
		    }     
		} catch (Exception e) {    
		    e.printStackTrace();    
		}    
	} 	
	
	public static Object getSessionAttribute(String nomeAtributo){		
		try {    
		    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();    
		    if (ec != null){    
				Map<String, Object> attrMap = ec.getSessionMap();       
		        if (attrMap != null) {    
		            return attrMap.get(nomeAtributo);    
		        } else {    
		            return null;    
		        }    
		    } else {    
		        return null;    
		    }    
		} catch (Exception e) {    
		    System.out.println("Erro ao tentar capturar o atributo da sessão: "+e.getMessage());    
		    return null;    
		} 
	}
	
	public static void setNavegacao(String outcome){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, outcome);
	}
	
	public static void logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		setNavegacao("index");
	}
}
