package com.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Endereco;
import com.repository.EnderecoRepository;
import com.service.EnderecoService;

public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Override
	public Optional<Endereco> buscarPeloId(Long id)
	{
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return endereco;
	};
	
	@Override
	public Endereco buscarPeloClienteId(Long clienteId)
	{
		Endereco endereco = new Endereco();
		endereco = enderecoRepository.findByClienteId(clienteId);
		return endereco;
	};
	
	@Override
	public void salvar(Endereco endereco)
	{
		enderecoRepository.save(endereco);
	};
	
	@Override
	public void excluir(Endereco endereco)
	{
		enderecoRepository.delete(endereco);
	};

	@Override
	public void excluirPeloId(Long id)
	{
		enderecoRepository.deleteById(id);
	}

}
