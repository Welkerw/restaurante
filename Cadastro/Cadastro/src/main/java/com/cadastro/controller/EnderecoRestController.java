package com.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Endereco;
import com.cadastro.repository.EnderecoRepository;
import com.cadastro.service.EnderecoService;

@RestController
public class EnderecoRestController {

	@Autowired
	EnderecoService enderecoService;	
	
	@Autowired
	EnderecoRepository  enderecoRepository;
	
	@RequestMapping(path= "/criar", method = RequestMethod.POST)
	public ResponseEntity<Endereco> criar(@RequestBody Endereco endereco) {
		enderecoRepository.save(endereco);
		return ResponseEntity.ok(endereco);
	}
	
	@RequestMapping(path= "/alterar", method = RequestMethod.PUT)
	public ResponseEntity<Endereco> alterar(@RequestBody Endereco endereco) {
		enderecoRepository.save(endereco);
		return ResponseEntity.ok(endereco);

	}
	
	@RequestMapping(path= "/buscarPeloId", method = RequestMethod.GET)
	public ResponseEntity<Endereco> buscarPeloId(@RequestBody Long id) {
		Endereco Endereco = enderecoRepository.findById(id).get();
		return  ResponseEntity.ok(Endereco);
	}
	
	@RequestMapping(path= "/buscarPeloIdCliente", method = RequestMethod.GET)
	public ResponseEntity<Endereco> buscarPeloIdCliente(@RequestBody Long id) {
		Endereco Endereco = enderecoRepository.findByClienteId(id);
		return  ResponseEntity.ok(Endereco);
	}
	
	@RequestMapping(path= "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> excluir(@RequestBody Endereco endereco) {
		enderecoRepository.delete(endereco);
		return  ResponseEntity.ok(Boolean.TRUE);
	}
	
	@RequestMapping(path= "/excluirPeloId", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> excluirPeloId(@RequestAttribute Long id) {
		try {
			enderecoRepository.deleteById(id);
		}
		catch (Exception e) {
			return  (ResponseEntity<Boolean>) ResponseEntity.notFound();
		}
		return  ResponseEntity.ok(Boolean.TRUE);
	}
	
}
