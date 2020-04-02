package br.com.mjv.model;

public class Projeto {

	private Integer idprojeto;
	private String nome;
	
	@Override
	public String toString() {
		return "Projeto [idprojeto=" + idprojeto + ", nome=" + nome + "]";
	}

	public Integer getIdprojeto() {
		return idprojeto;
	}

	public void setIdprojeto(Integer idprojeto) {
		this.idprojeto = idprojeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
