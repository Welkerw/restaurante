package com.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.model.Produto;

@Transactional
public interface ProdutoRepository extends CrudRepository<Produto, Long>
{
	public Produto findByNomeIgnoreCase(String nome);
	
	public Optional<Produto> findById(Long id);
	
	public Produto save(Produto produto);
	
	public void deleteById(Long id);
	
	public void delete(Produto produto);
	
	public List<Produto> findAll();
}