package br.com.mjv.model;

public class Colaborador {

	private Integer idcolaborador;
	private String nome;
	private String sobrenome;
	private String email;
	private String projeto;
	private String gestor;
	private String departamento;
	
	@Override
	public String toString() {
		return "Colaborador [idcolaborador=" + idcolaborador + ", nome=" + nome + ", sobrenome=" + sobrenome
				+ ", email=" + email + ", projeto=" + projeto + ", gestor=" + gestor + ", departamento=" + departamento
				+ "]";
	}

	public Integer getIdcolaborador() {
		return idcolaborador;
	}

	public void setIdcolaborador(Integer idcolaborador) {
		this.idcolaborador = idcolaborador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
