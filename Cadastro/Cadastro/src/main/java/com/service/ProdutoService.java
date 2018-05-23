package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Produto;

public interface ProdutoService {

	public Produto buscarPeloNome(String nome);
	
	public Optional<Produto> buscarPeloId(Long id);
	
	public void salvar(Produto produto);
	
	public void excluirPeloId(Long id);
	
	public void excluir(Produto produto);
	
	public List<Produto> buscarTodos();
	
}
