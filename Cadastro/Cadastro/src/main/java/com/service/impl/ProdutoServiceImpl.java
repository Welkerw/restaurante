package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Produto;
import com.repository.ProdutoRepository;
import com.service.ProdutoService;

public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Override
	public Produto buscarPeloNome(String nome)
	{
		Produto produto = new Produto();
		produto = produtoRepository.findByNomeIgnoreCase(nome);
		return produto;
	};
	
	@Override
	public Optional<Produto> buscarPeloId(Long id)
	{
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto;
	};
	
	@Override
	public void salvar(Produto produto)
	{
		produtoRepository.save(produto);
	};
	
	@Override
	public void excluirPeloId(Long id)
	{
		produtoRepository.deleteById(id);
	};
	
	@Override
	public void excluir(Produto produto)
	{
		produtoRepository.delete(produto);
	};
	
	@Override
	public List<Produto> buscarTodos()
	{
		List<Produto> produtos = new ArrayList<>();
		produtos = produtoRepository.findAll();
		return produtos;
	};
}
