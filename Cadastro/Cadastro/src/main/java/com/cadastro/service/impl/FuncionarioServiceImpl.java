package com.cadastro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.model.Funcionario;
import com.cadastro.repository.FuncionarioRepository;
import com.cadastro.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Override
	public boolean existeFuncionario(Funcionario funcionario) 
	{
		Funcionario funcionarioExistente = funcionarioRepository.findByNomeIgnoreCase(funcionario.getNome());
		if(funcionarioExistente != null)
		{
			return true;
		}
		return false;
	}
}
