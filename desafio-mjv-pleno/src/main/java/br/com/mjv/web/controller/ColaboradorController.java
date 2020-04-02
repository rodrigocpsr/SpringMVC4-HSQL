package br.com.mjv.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.mjv.exception.BusinessException;
import br.com.mjv.model.Colaborador;
import br.com.mjv.service.ColaboradorService;

/**
 * Classe controladora dos fluxos
 * 
 * @author Rodrigo Carlos
 *
 */
@Controller
public class ColaboradorController {

	@Autowired
	ColaboradorService colaboradorService;
	
	/**
	 * Método responsável por direcionar para a pégina principal
	 * 
	 * @author Rodrigo Carlos
	 *
	 */
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String index(Model model) throws Exception {
		model.addAttribute("colaborador", new Colaborador());
		List<Colaborador> lstColaborador = colaboradorService.buscarTodos();
		model.addAttribute("lstColaborador", lstColaborador);
		return "index";
	}
	
	/**
	 * Método responsável por adicionar um colaborador
	 * 
	 * @author Rodrigo Carlos
	 *
	 */
	@RequestMapping(method=RequestMethod.POST, value="/adicionar")
	public String adicionar(@ModelAttribute("colaborador") Colaborador colaborador, Model model) throws Exception {
		List<Colaborador> lstColaborador = null; 
		
		try {		
			colaboradorService.adicionar(colaborador);
		} catch (Exception e) {
			model.addAttribute("msgErro", e.getMessage());
		} finally {
			lstColaborador = colaboradorService.buscarTodos();
			model.addAttribute("colaborador", new Colaborador());
			model.addAttribute("lstColaborador", lstColaborador);
		}
		
		return "index";
	}
	
	/**
	 * Método responsável por alterar um colaborador
	 * 
	 * @author Rodrigo Carlos
	 *
	 */
	@RequestMapping(method=RequestMethod.POST, value="/alterar")
	public String alterar(@ModelAttribute("colaborador") Colaborador colaborador, Model model) throws Exception {		
		List<Colaborador> lstColaborador = null; 
		
		try {		
			colaboradorService.alterar(colaborador);
		} catch (BusinessException e) {	
			model.addAttribute("msgErro", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("msgErro", e.getMessage());
		} finally {
			lstColaborador = colaboradorService.buscarTodos();
			model.addAttribute("colaborador", new Colaborador());
			model.addAttribute("lstColaborador", lstColaborador);
		}
		
		return "index";
	}
	
	/**
	 * Método responsável por excluir um colaborador
	 * 
	 * @author Rodrigo Carlos
	 *
	 */
	@RequestMapping(method=RequestMethod.GET, value="/excluir")
	public String excluir(@RequestParam("id") int id, Model model) throws Exception {		
		List<Colaborador> lstColaborador = null; 
		
		try {		
			colaboradorService.excluir(id);
		} catch (BusinessException e) {	
			model.addAttribute("msgErro", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("msgErro", e.getMessage());
		} finally {
			lstColaborador = colaboradorService.buscarTodos();
			model.addAttribute("colaborador", new Colaborador());
			model.addAttribute("lstColaborador", lstColaborador);
		}
		
		return "index";
	}

}
