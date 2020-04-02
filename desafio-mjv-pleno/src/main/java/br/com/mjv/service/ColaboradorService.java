package br.com.mjv.service;

import java.util.List;

import br.com.mjv.model.Colaborador;

public interface ColaboradorService {
	
	List<Colaborador> buscarTodos() throws Exception; 
	void adicionar(Colaborador colaborador) throws Exception;
	void alterar(Colaborador colaborador) throws Exception;
	void excluir(Integer id) throws Exception;

	

}
