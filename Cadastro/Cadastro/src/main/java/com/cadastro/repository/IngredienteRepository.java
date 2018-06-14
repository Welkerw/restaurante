package com.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>
{
	public Ingrediente findByNomeIgnoreCase(String nome);
}
