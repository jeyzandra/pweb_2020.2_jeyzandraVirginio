package br.com.jeyzandra.agropopshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jeyzandra.agropopshop.model.Cliente;
import br.com.jeyzandra.agropopshop.repository.ClienteRepository;



@Controller
public class ClienteController {
	
	@Autowired
	ClienteRepository cliRepo;
	
	@GetMapping("/listarCliente")
	public ModelAndView listarCliente() {
		List<Cliente> lista = cliRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarCliente");
		modelAndView.addObject("clientes", lista);
		
		return modelAndView;	
	}
	@GetMapping("/adicionarCliente")
	public ModelAndView formAdicionarPessoas() {
		ModelAndView modelAndView = new ModelAndView("adicionarCliente");
		modelAndView.addObject(new Cliente());
		return modelAndView;
	}
	@PostMapping("/adicionarCliente")
	public String adicionarCliente(Cliente aPessoa) {
		this.cliRepo.save(aPessoa);
		return "redirect:/listarCliente";
	}
	
	@GetMapping("/editarCliente/{id}")
	public ModelAndView formEditarCliente(@PathVariable("id") long id) {
		Cliente pessoa = cliRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		ModelAndView modelAndView = new ModelAndView("editarCliente");
		modelAndView.addObject(pessoa);
		return modelAndView;
	}
	
	@PostMapping("/editarCliente/{id}")
	public ModelAndView editarCliente(@PathVariable("id") long id, Cliente pessoa) {
		this.cliRepo.save(pessoa);
		return new ModelAndView("redirect:/listarCliente");
	}	
	
	@GetMapping("/removerCliente/{id}")
	public ModelAndView removerPessoa(@PathVariable("id") long id) {
		Cliente aRemover = cliRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		cliRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarCliente");
	}

	
	

}

