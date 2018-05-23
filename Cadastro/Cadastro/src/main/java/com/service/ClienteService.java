package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Cliente;

public interface ClienteService {
	
	public Cliente buscarPeloNome(String nome);
	
	public Optional<Cliente> buscarPeloId(Long id);
	
	public void salvar(Cliente cliente);
	
	public void excluir(Cliente cliente);
	
	public void excluirPeloId(Long id);
	
	public List<Cliente> buscarTodos();
	
	public Cliente buscarPeloTelefone(String numero);
}
