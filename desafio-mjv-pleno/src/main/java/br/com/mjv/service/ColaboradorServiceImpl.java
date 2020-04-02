package br.com.mjv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.exception.BusinessException;
import br.com.mjv.model.Colaborador;
import br.com.mjv.repository.ColaboradorRepository;
import br.com.mjv.util.Mensagem;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {
	
	@Autowired
	ColaboradorRepository colaboradorRepository;

	@Override
	public List<Colaborador> buscarTodos() throws Exception {
		return colaboradorRepository.findAll();
	}
	
	@Override
	public void adicionar(Colaborador colaborador) throws Exception {
		colaboradorRepository.adicionar(colaborador);
	}
	
	@Override
	public void alterar(Colaborador colaborador) throws Exception {				
		colaboradorRepository.alterar(colaborador);
	}

	@Override
	public void excluir(Integer id) throws Exception, BusinessException {
		Long totColaborador = colaboradorRepository.getTotalColaborador(id);
		
		// Regra: caso o colaborar esteja associado a projeto,
		// gestor ou departamente não podera ser excluido.
		if (totColaborador == 0) { 	
			throw new BusinessException(Mensagem.EXCLUIR_COLABORADOR_ASSOCIADO);
		}
		
		colaboradorRepository.excluir(id);
	}

}
