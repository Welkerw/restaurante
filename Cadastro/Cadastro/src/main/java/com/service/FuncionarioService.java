package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Funcionario;

public interface FuncionarioService {
	
	public Funcionario buscarPeloNome(String nome);
	
	public Optional<Funcionario> buscarPeloId(Long id);
	
	public void salvar(Funcionario funcionario);
	
	public void excluir(Funcionario funcionario);
	
	public void excluirPeloId(Long id);
	
	public List<Funcionario> buscarTodos();
	
	public Funcionario buscarPeloTelefone(String numero);
}
