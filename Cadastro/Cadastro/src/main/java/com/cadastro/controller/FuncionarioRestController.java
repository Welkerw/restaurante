package com.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Funcionario;
import com.cadastro.repository.FuncionarioRepository;
import com.cadastro.service.FuncionarioService;;

@RestController
@RequestMapping(path= "/funcionario")
public class FuncionarioRestController {

	@Autowired
	FuncionarioService funcionarioService;	
	
	@Autowired
	FuncionarioRepository  funcionarioRepository;
	
	@RequestMapping(path= "/criar", method = RequestMethod.POST)
	public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return ResponseEntity.ok(funcionario);
	}
	
	@RequestMapping(path= "/alterar", method = RequestMethod.PUT)
	public ResponseEntity<Funcionario> alterar(@RequestBody Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return ResponseEntity.ok(funcionario);

	}
	
	@RequestMapping(path= "/buscarPeloNome", method = RequestMethod.GET)
	public ResponseEntity<Funcionario> buscarPeloNome(@RequestBody String nome) {
		Funcionario funcionario = funcionarioRepository.findByNomeIgnoreCase(nome);
		return ResponseEntity.ok(funcionario);
	}
	
	@RequestMapping(path= "/buscarPeloId", method = RequestMethod.GET)
	public ResponseEntity<Funcionario> buscarPeloId(@RequestBody Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		return  ResponseEntity.ok(funcionario);
	}
	
	@RequestMapping(path= "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> excluir(@RequestBody Funcionario funcionario) {
		funcionarioRepository.delete(funcionario);
		return  ResponseEntity.ok(Boolean.TRUE);
	}
	
	@RequestMapping(path= "/excluirPeloId", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> excluirPeloId(@RequestAttribute Long id) {
		try {
			funcionarioRepository.deleteById(id);
		}
		catch (Exception e) {
			return  (ResponseEntity<Boolean>) ResponseEntity.notFound();
		}
		return  ResponseEntity.ok(Boolean.TRUE);
	}
	
	@RequestMapping(path= "/buscarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> buscarTodos() {
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios = funcionarioRepository.findAll();
		return  ResponseEntity.ok(funcionarios);
	}
	
	@RequestMapping(path= "/buscarPeloTelefone", method = RequestMethod.GET)
	public ResponseEntity<Funcionario> buscarPeloTelefone(@RequestHeader String numero) {
		Funcionario funcionario = new Funcionario();
		funcionario = funcionarioRepository.findByTelefone(numero);
		if(funcionario == null)
		{
			return  ResponseEntity.notFound().build();
		}
		return  ResponseEntity.ok(funcionario);
	}
}
