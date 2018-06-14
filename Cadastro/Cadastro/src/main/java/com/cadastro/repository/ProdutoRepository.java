package com.cadastro.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.model.Produto;

@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, Long>
{
	
	public Produto findByNomeIgnoreCase(String nome);
	
}
