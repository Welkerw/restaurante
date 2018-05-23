package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Cliente;
import com.mysql.fabric.xmlrpc.base.Array;
import com.repository.ClienteRepository;
import com.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void salvar(Cliente cliente)
	{
		clienteRepository.save(cliente);
	}
	
	public Cliente buscarPeloNome(String nome) 
	{
		Cliente cliente = new Cliente();
		cliente = clienteRepository.findByNomeIgnoreCase(nome);
		return cliente;
	};
	
	public Optional<Cliente> buscarPeloId(Long id) 
	{
		Optional<Cliente> cliente = clienteRepository.findById(id);;
		return cliente;
	};
	
	public void excluir(Cliente cliente)
	{
		clienteRepository.delete(cliente);
	};
	
	public void excluirPeloId(Long id) 
	{
		clienteRepository.deleteById(id);
	};
	
	public List<Cliente> buscarTodos() 
	{
		List<Cliente> clientes = new ArrayList<>();
		clientes = clienteRepository.findAll();
		return clientes;
	};
	
	public Cliente buscarPeloTelefone(String numero) 
	{
		Cliente cliente = new Cliente();
		cliente = clienteRepository.findByTelefone(numero);
		return cliente;
	};
}
