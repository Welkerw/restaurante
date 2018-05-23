package com.service;

import java.util.Optional;

import com.model.Endereco;

public interface EnderecoService {
	
	public Optional<Endereco> buscarPeloId(Long id);
	
	public Endereco buscarPeloClienteId(Long clienteId);
	
	public void salvar(Endereco endereco);
	
	public void excluir(Endereco endereco);

	public void excluirPeloId(Long id);
}
