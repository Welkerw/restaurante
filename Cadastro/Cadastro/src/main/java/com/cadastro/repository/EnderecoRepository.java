package com.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>
{
	
	public Endereco findByClienteId(Long clienteId);
	
}
