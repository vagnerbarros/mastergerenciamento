package masterfila.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import masterfila.jsf.entidade.Estabelecimento;
import masterfila.jsf.fachada.Fachada;
import masterfila.jsf.util.FacesContextUtil;

@ManagedBean (name = "cadastro_estabelecimento")
@SessionScoped
public class CadastroEstabelecimentoBean {

	private String razao;
	private String cnpj;
	private String nome;
	private String email;
	private String categoria;
	private String endereco;
	private String cidade;
	private String estado;
	
	public CadastroEstabelecimentoBean(){
		
	}

	public void cadastrar(){
		
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setRazao(razao);
		estabelecimento.setCnpj(cnpj);
		estabelecimento.setNome(nome);
		estabelecimento.setEmail(email);
		estabelecimento.setCategoria(categoria);
		estabelecimento.setEndereco(endereco);
		estabelecimento.setCidade(cidade);
		estabelecimento.setEstado(estado);
		
		Fachada.getInstance().cadastroEmpresa().cadastrar(estabelecimento);
		FacesContextUtil.setMessageInformacao("Sucesso!!", "Estabelecimento cadastrado com sucesso.");
		limpar();
	}
	
	public void limpar(){
		
		razao = "";
		cnpj = "";
		nome = "";
		email = "";
		categoria = "";
		endereco = "";
		cidade = "";
		estado = "";
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
