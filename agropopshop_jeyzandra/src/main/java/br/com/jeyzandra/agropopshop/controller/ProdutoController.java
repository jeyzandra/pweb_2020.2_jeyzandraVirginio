package br.com.jeyzandra.agropopshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jeyzandra.agropopshop.model.Produto;
import br.com.jeyzandra.agropopshop.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	
	@Autowired
	ProdutoRepository proRepo;

	@GetMapping("/listarProduto")
	public ModelAndView listarProduto() {
		List<Produto> lista = proRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarProduto");
		modelAndView.addObject("produtos", lista);
		
		return modelAndView;	
	}
	@GetMapping("/adicionarProduto")
	public ModelAndView formAdicionarProduto() {
		ModelAndView modelAndView = new ModelAndView("adicionarProduto");
		modelAndView.addObject(new Produto());
		return modelAndView;
	}
	@PostMapping("/adicionarProduto")
	public String adicionarProduto(Produto aProduto) {
		this.proRepo.save(aProduto);
		return "redirect:/listarProduto";
	}
	@GetMapping("/editar/{id}")
	public ModelAndView formEditarProduto(@PathVariable("id") long id) {
		Produto produto = proRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		ModelAndView modelAndView = new ModelAndView("editarProduto");
		modelAndView.addObject(produto);
		return modelAndView;
	}
	@PostMapping("/editar/{id}")
	public ModelAndView editarProduto(@PathVariable("id") long id, Produto produto) {
		this.proRepo.save(produto);
		return new ModelAndView("redirect:/listarProduto");
	}	
	
	@GetMapping("/remover/{id}")
	public ModelAndView removerProduto(@PathVariable("id") long id) {
		Produto aRemover = proRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		proRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarProduto");
	}

}
