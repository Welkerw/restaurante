package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Funcionario;

import com.repository.FuncionarioRepository;
import com.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public Funcionario buscarPeloNome(String nome) 
	{
		Funcionario funcionario = new Funcionario();
		funcionario = funcionarioRepository.findByNomeIgnoreCase(nome);
		return funcionario;
	};
	
	@Override
	public Optional<Funcionario> buscarPeloId(Long id)
	{
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario;
	};
	
	@Override
	public void salvar(Funcionario funcionario)
	{
		funcionarioRepository.save(funcionario);
	};
	
	@Override
	public void excluir(Funcionario funcionario)
	{
		funcionarioRepository.delete(funcionario);
	};
	
	@Override
	public void excluirPeloId(Long id)
	{
		funcionarioRepository.deleteById(id);
	};
	
	@Override
	public List<Funcionario> buscarTodos()
	{
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios = funcionarioRepository.findAll();
		return funcionarios;
	};
	
	@Override
	public Funcionario buscarPeloTelefone(String numero)
	{
		Funcionario funcionario = new Funcionario();
		funcionario = funcionarioRepository.findByTelefone(numero);
		return funcionario;
	};
}
