package masterfila.jsf.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empresa")
	private Estabelecimento estabelecimento;
	
	@Column(name = "nome", length = 200, nullable = false)
	private String nome;
	
	@Column(name = "cpf", length = 20, nullable = false)
	private String cpf;
	
	@Column(name = "data_nascimento", length = 10, nullable = false)
	private String dataNascimento;
	
	@Column(name = "perfil", length = 50, nullable = false)
	private String perfil;
	
	@Column(name = "login", length = 20, nullable = false)
	private String login;
	
	@Column(name = "senha", length = 50, nullable = false)
	private String senha;
	
	@Column(name = "status", length = 10, nullable = false)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estabelecimento getEmpresa() {
		return estabelecimento;
	}

	public void setEmpresa(Estabelecimento empresa) {
		this.estabelecimento = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object[] getColunas() {
		return new Object [] {this, cpf};
	}
	
	public String toString(){
		return nome;
	}
	
	public boolean equals(Object o){
		if(this.id == ((Funcionario)o).getId()){
			return true;
		}
		else{
			return false;
		}
	}
}
