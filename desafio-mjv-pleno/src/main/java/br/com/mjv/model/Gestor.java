package br.com.mjv.model;

public class Gestor {

	private Integer idgestor;
	private String nome;
	
	@Override
	public String toString() {
		return "Gestor [idgestor=" + idgestor + ", nome=" + nome + "]";
	}

	public Integer getIdgestor() {
		return idgestor;
	}

	public void setIdgestor(Integer idgestor) {
		this.idgestor = idgestor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
