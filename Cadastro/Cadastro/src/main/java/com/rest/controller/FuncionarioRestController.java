package com.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.model.Funcionario;

import com.repository.FuncionarioRepository;;

@RestController
public class FuncionarioRestController {

	public boolean criar(Funcionario funcionario) 
	{
		Funcionario funcionarioSalvar = new Funcionario();
		
		funcionarioSalvar = funcionario;
		
		
		return true;
	};
}
