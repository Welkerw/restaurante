package com.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cadastro.model.Cliente;
import com.cadastro.repository.ClienteRepository;
import com.cadastro.service.ClienteService;

@RestController
@RequestMapping(path= "/cliente")
public class ClienteRestController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ClienteRepository  clienteRepository;
	
	@RequestMapping(path= "/criar", method = RequestMethod.POST)
	public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@RequestMapping(path= "/alterar", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);

	}
	
	@RequestMapping(path= "/buscarPeloNome", method = RequestMethod.GET)
	public ResponseEntity<Cliente> buscarPeloNome(@RequestBody String nome) {
		Cliente cliente = clienteRepository.findByNomeIgnoreCase(nome);
		return ResponseEntity.ok(cliente);
	}
	
	@RequestMapping(path= "/buscarPeloId", method = RequestMethod.GET)
	public ResponseEntity<Cliente> buscarPeloId(@RequestBody Long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		return  ResponseEntity.ok(cliente);
	}

	@RequestMapping(path= "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> excluir(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
		return  ResponseEntity.ok(Boolean.TRUE);
	}

	@RequestMapping(path= "/excluirPeloId", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> excluirPeloId(@RequestParam Long id) {
		try {
			clienteRepository.deleteById(id);
		}
		catch (Exception e) {
			return ResponseEntity.ok(HttpStatus.NOT_FOUND);
		}
		return  ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(path= "/buscarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> buscarTodos() {
		List<Cliente> clientes = new ArrayList<>();
		clientes = clienteRepository.findAll();
		return  ResponseEntity.ok(clientes);
	}
	
	@RequestMapping(path= "/buscarPeloTelefone", method = RequestMethod.GET)
	public ResponseEntity<Cliente> buscarPeloTelefone(@RequestHeader String numero) {
		Cliente cliente = new Cliente();
		cliente = clienteRepository.findByTelefone(numero);
		if(cliente == null)
		{
			return  ResponseEntity.notFound().build();
		}
		return  ResponseEntity.ok(cliente);
	}
	
	
}
