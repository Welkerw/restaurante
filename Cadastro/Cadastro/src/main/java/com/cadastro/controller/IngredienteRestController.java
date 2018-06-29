package com.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Ingrediente;
import com.cadastro.repository.IngredienteRepository;
import com.cadastro.service.IngredienteService;

@RestController
@RequestMapping(path= "/ingredientes")
public class IngredienteRestController {

	@Autowired
	IngredienteService ingredienteService;
	
	@Autowired
	IngredienteRepository  ingredienteRepository;
	
	@RequestMapping(path= "/criar", method = RequestMethod.POST)
	public ResponseEntity<Ingrediente> criar(@RequestBody Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
		return ResponseEntity.ok(ingrediente);
	}
	
	@RequestMapping(path= "/alterar", method = RequestMethod.PUT)
	public ResponseEntity<Ingrediente> alterar(@RequestBody Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
		return ResponseEntity.ok(ingrediente);

	}
	
	@RequestMapping(path= "/buscarPeloNome", method = RequestMethod.GET)
	public ResponseEntity<Ingrediente> buscarPeloNome(@RequestBody String nome) {
		Ingrediente ingrediente = ingredienteRepository.findByNomeIgnoreCase(nome);
		return ResponseEntity.ok(ingrediente);
	}
	
	@RequestMapping(path= "/buscarPeloId", method = RequestMethod.GET)
	public ResponseEntity<Ingrediente> buscarPeloId(@RequestBody Long id) {
		Ingrediente ingrediente = ingredienteRepository.findById(id).get();
		return  ResponseEntity.ok(ingrediente);
	}
	
	@RequestMapping(path= "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> excluir(@RequestBody Ingrediente ingrediente) {
		ingredienteRepository.delete(ingrediente);
		return  ResponseEntity.ok(Boolean.TRUE);
	}
	
	@RequestMapping(path= "/excluirPeloId", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> excluirPeloId(@RequestAttribute Long id) {
		try {
			ingredienteRepository.deleteById(id);
		}
		catch (Exception e) {
			return  (ResponseEntity<Boolean>) ResponseEntity.notFound();
		}
		return  ResponseEntity.ok(Boolean.TRUE);
	}
	
	@RequestMapping(path= "/buscarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Ingrediente>> buscarTodos() {
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes = ingredienteRepository.findAll();
		return  ResponseEntity.ok(ingredientes);
	}

}
