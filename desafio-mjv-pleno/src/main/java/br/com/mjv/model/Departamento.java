package br.com.mjv.model;

public class Departamento {

	private Integer iddepartamento;
	private String nome;
	
	@Override
	public String toString() {
		return "Departamento [iddepartamento=" + iddepartamento + ", nome=" + nome + "]";
	}

	public Integer getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
