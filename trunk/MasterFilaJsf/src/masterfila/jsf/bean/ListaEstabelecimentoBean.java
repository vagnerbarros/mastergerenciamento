package masterfila.jsf.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import masterfila.jsf.entidade.Estabelecimento;
import masterfila.jsf.fachada.Fachada;
import masterfila.jsf.util.FacesContextUtil;

@ManagedBean (name = "listar_estabelecimento")
@SessionScoped
public class ListaEstabelecimentoBean {

	private DataModel<Estabelecimento> listaEstabelecimento;
	private Estabelecimento estabelecimento;
	
	public ListaEstabelecimentoBean(){
		
		List<Estabelecimento> lista = Fachada.getInstance().cadastroEmpresa().listar();
		listaEstabelecimento = new ListDataModel<Estabelecimento>(lista);
	}
	
	public void atualizar(){
		estabelecimento = listaEstabelecimento.getRowData();
		FacesContextUtil.setSessionAttribute("estabelecimentoAtualizar", estabelecimento);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("atualizar_estabelecimento.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void prepararRemover(){
		estabelecimento = listaEstabelecimento.getRowData();
	}
	
	public void remover(){
		if(estabelecimento != null){
			Fachada.getInstance().cadastroEmpresa().remover(estabelecimento);
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listagem_estabelecimento.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DataModel<Estabelecimento> getListaEstabelecimento() {
		List<Estabelecimento> lista = Fachada.getInstance().cadastroEmpresa().listar();
		listaEstabelecimento = new ListDataModel<Estabelecimento>(lista);
		return listaEstabelecimento;
	}

	public void setListaEstabelecimento(DataModel<Estabelecimento> listaEstabelecimento) {
		this.listaEstabelecimento = listaEstabelecimento;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		if(estabelecimento != null){
			this.estabelecimento = estabelecimento;
		}
	}
}
