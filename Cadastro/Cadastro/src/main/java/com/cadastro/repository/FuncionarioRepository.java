package com.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
{
	public Funcionario findByNomeIgnoreCase(String nome);
	
	public Funcionario findByTelefone(String numero);
}
