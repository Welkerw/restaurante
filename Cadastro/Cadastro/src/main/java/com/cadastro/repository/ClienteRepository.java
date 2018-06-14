package com.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
	
	public Cliente findByNomeIgnoreCase(String nome);

	public Cliente findByTelefone(String numero);
	
}
