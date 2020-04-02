package br.com.mjv.repository;

import java.util.List;

import br.com.mjv.model.Colaborador;

public interface ColaboradorRepository {

	List<Colaborador> findAll() throws Exception;
	Colaborador findByName(String name) throws Exception;
	Long getTotalColaborador(Integer id) throws Exception;
	void adicionar(Colaborador colaborador) throws Exception;
	void alterar(Colaborador colaborador) throws Exception;
	void excluir(Integer id) throws Exception;

}
