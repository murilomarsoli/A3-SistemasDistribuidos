package com.projeto.sistema.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.sistema.modelos.Produto;
import com.projeto.sistema.repositorios.ProdutoRepositorio;

@Controller
public class ProdutoControle {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@GetMapping("/cadastroProduto")
	public ModelAndView cadastrar(Produto produto) {
		ModelAndView mv = new ModelAndView("administrativo/produtos/cadastro");
		mv.addObject("produto", produto);
		return mv;
	}
	
	@GetMapping("/listarProduto")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/produtos/lista");
		mv.addObject("listaProdutos", produtoRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/editarProduto/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Produto> produtoOpt = produtoRepositorio.findById(id);
		if (produtoOpt.isPresent()) {
			return cadastrar(produtoOpt.get());
		} else {
			ModelAndView mv = new ModelAndView("redirect:/listarProduto");
			mv.addObject("mensagem", "Produto não encontrado!");
			return mv;
		}
	}
	
	@GetMapping("/removerProduto/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
	    Optional<Produto> produto = produtoRepositorio.findById(id);
	    if (produto.isPresent()) {
	        produtoRepositorio.delete(produto.get());
	    } else {
	        // Produto não encontrado, exibe uma mensagem de erro
	        ModelAndView mv = listar();
	        mv.addObject("mensagem", "Produto não encontrado!");
	        return mv;
	    }
	    return listar();
	}
	
	@PostMapping("/salvarProduto")
	public ModelAndView salvar(Produto produto, BindingResult result) {
		// Verificar se existem erros na validação
		if (result.hasErrors()) {
			return cadastrar(produto);
		}
		
		// Caso contrário, salvar o produto
		produtoRepositorio.saveAndFlush(produto);
		
		// Após salvar, redireciona para a lista de produtos com uma mensagem de sucesso
		ModelAndView mv = new ModelAndView("redirect:/listarProduto");
		mv.addObject("mensagem", "Produto salvo com sucesso!");
		return mv;
	}
}
