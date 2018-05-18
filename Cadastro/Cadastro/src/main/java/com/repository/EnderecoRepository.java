package com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long>
{
	
	public Optional<Endereco> findById(Long id);
	
	public Endereco findByClienteId(Long clienteId);
	
	public Endereco save(Endereco endereco);
	
	public void delete(Endereco endereco);

	public void deleteById(Long id);
	
}
