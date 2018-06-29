package com.cadastro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.model.Cliente;
import com.cadastro.repository.ClienteRepository;
import com.cadastro.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public boolean existeCliente(Cliente cliente) 
	{
		Cliente clienteExistente = clienteRepository.findByNomeIgnoreCase(cliente.getNome());
		if(clienteExistente != null)
		{
			return true;
		}
		return false;
	}
}
