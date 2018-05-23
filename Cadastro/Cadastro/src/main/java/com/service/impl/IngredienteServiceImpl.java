package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Ingrediente;
import com.repository.IngredienteRepository;
import com.service.IngredienteService;

public class IngredienteServiceImpl implements IngredienteService {

	@Autowired
	IngredienteRepository ingredienteRepository;
	
	@Override
	public Ingrediente buscarPeloNome(String nome)
	{
		Ingrediente ingrediente = new Ingrediente();
		ingrediente = ingredienteRepository.findByNomeIgnoreCase(nome);
		return ingrediente;
	};
	
	@Override
	public Optional<Ingrediente> buscarPeloId(Long id)
	{
		Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
		return ingrediente;
	};
	
	@Override
	public void salvar(Ingrediente ingrediente)
	{
		ingredienteRepository.save(ingrediente);
	};
	
	@Override
	public void excluir(Ingrediente ingrediente)
	{
		ingredienteRepository.delete(ingrediente);
	};
	
	@Override
	public void excluirPeloId(Long id)
	{
		ingredienteRepository.deleteById(id);
	};
	
	@Override
	public List<Ingrediente> buscarTodos()
	{
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes = ingredienteRepository.findAll();
		return ingredientes;
	};
	
}
