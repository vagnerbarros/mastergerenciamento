package masterfila.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
	
	public String atualizar(){
		estabelecimento = listaEstabelecimento.getRowData();
		FacesContextUtil.setSessionAttribute("estabelecimentoAtualizar", estabelecimento);
		return "atualizar_estabelecimento";
	}

	public void prepararRemover(){
		estabelecimento = listaEstabelecimento.getRowData();
	}
	
	public String remover(){
		if(estabelecimento != null){
			Fachada.getInstance().cadastroEmpresa().remover(estabelecimento);
		}
		return "listagem_estabelecimento";
	}

	public DataModel<Estabelecimento> getListaEstabelecimento() {
		return listaEstabelecimento;
	}

	public void setListaEstabelecimento(DataModel<Estabelecimento> listaEstabelecimento) {
		this.listaEstabelecimento = listaEstabelecimento;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
}
