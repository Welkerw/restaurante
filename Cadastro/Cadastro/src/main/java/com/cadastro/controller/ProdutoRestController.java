package com.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Produto;
import com.cadastro.repository.ProdutoRepository;
import com.cadastro.service.ProdutoService;

@RestController
@RequestMapping(path= "/produtos")
public class ProdutoRestController {

	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@RequestMapping(path= "/criar", method = RequestMethod.POST)
	public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		return ResponseEntity.ok(produto);
	}
	
	@RequestMapping(path= "/alterar", method = RequestMethod.PUT)
	public ResponseEntity<Produto> alterar(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		return ResponseEntity.ok(produto);

	}
	
	@RequestMapping(path= "/buscarPeloNome", method = RequestMethod.GET)
	public ResponseEntity<Produto> buscarPeloNome(@RequestBody String nome) {
		Produto produto = produtoRepository.findByNomeIgnoreCase(nome);
		return ResponseEntity.ok(produto);
	}
	
	@RequestMapping(path= "/buscarPeloId", method = RequestMethod.GET)
	public ResponseEntity<Produto> buscarPeloId(@RequestBody Long id) {
		Produto produto = produtoRepository.findById(id).get();
		return  ResponseEntity.ok(produto);
	}
	
	@RequestMapping(path= "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> excluir(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
		return  ResponseEntity.ok(Boolean.TRUE);
	}
	
	@RequestMapping(path= "/excluirPeloId", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> excluirPeloId(@RequestAttribute Long id) {
		try {
			produtoRepository.deleteById(id);
		}
		catch (Exception e) {
			return  (ResponseEntity<Boolean>) ResponseEntity.notFound();
		}
		return  ResponseEntity.ok(Boolean.TRUE);
	}
	
	@RequestMapping(path= "/buscarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> buscarTodos() {
		List<Produto> produtos = new ArrayList<>();
		produtos = produtoRepository.findAll();
		return  ResponseEntity.ok(produtos);
	}
	
}
