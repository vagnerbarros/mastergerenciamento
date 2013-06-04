package masterfila.jsf.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "estabelecimento")
public class Estabelecimento {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "razao", length = 200, nullable = false)
	private String razao;
	
	@Column(name = "nome", length = 200, nullable = false)
	private String nome;
	
	@Column(name = "cnpj", length = 20, nullable = false)
	private String cnpj;
	
	@Column(name = "categoria", length = 100, nullable = false)
	private String categoria;
	
	@Column(name = "endereco", length = 200, nullable = false)
	private String endereco;
	
	@Column(name = "estado", length = 30, nullable = false)
	private String estado;
	
	@Column(name = "cidade", length = 100, nullable = false)
	private String cidade;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "status", length = 10, nullable = false)
	private String status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
