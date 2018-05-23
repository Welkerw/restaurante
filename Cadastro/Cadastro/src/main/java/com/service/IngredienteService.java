package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Ingrediente;

public interface IngredienteService {
	
	public Ingrediente buscarPeloNome(String nome);
	
	public Optional<Ingrediente> buscarPeloId(Long id);
	
	public void salvar(Ingrediente ingrediente);
	
	public void excluir(Ingrediente ingrediente);
	
	public void excluirPeloId(Long id);
	
	public List<Ingrediente> buscarTodos();
	
}
