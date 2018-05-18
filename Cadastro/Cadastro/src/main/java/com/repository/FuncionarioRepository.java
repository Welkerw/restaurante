package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>
{
	public Funcionario findByNomeIgnoreCase(String nome);
	
	public Optional<Funcionario> findById(Long id);
	
	public Funcionario save(Funcionario funcionario);
	
	public void delete(Funcionario funcionario);
	
	public void deleteById(Long id);
	
	public List<Funcionario> findAll();
	
	public Funcionario findByTelefone(String numero);
}