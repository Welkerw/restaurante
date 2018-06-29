package com.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cadastro.model.Funcionario;
import com.cadastro.repository.FuncionarioRepository;
import com.cadastro.service.FuncionarioService;;

@RestController
@RequestMapping(path= "/funcionarios")
public class FuncionarioRestController {

	@Autowired
	FuncionarioService funcionarioService;	
	
	@Autowired
	FuncionarioRepository  funcionarioRepository;
	
	//-------------------Criar Funcionário--------------------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> criar(@RequestBody Funcionario funcionario, UriComponentsBuilder ucBuilder) {
        System.out.println("Criando funcionário " + funcionario.getNome());
 
        if (funcionarioService.existeFuncionario(funcionario)) {
            System.out.println("Já existe um funcionário de nome:  " + funcionario.getNome());
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        funcionarioRepository.save(funcionario);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	 //------------------- Alterar Funcionário --------------------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<Funcionario> alterar(@PathVariable("id") long id, @RequestBody Funcionario funcionario) {
        System.out.println("Alterando Usuario " + id);
         
        Funcionario funcionarioAtual = funcionarioRepository.getOne(id);
         
        if (funcionarioAtual==null) {
            System.out.println("Funcionario com o id " + id + " não encontrado");
            return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
        }
 
        funcionarioAtual.setNome(funcionario.getNome());
        funcionarioAtual.setFuncao(funcionario.getFuncao());
        funcionarioAtual.setSalario(funcionario.getSalario());
        funcionarioAtual.setTelefone(funcionario.getTelefone());
         
        funcionarioRepository.saveAndFlush(funcionarioAtual);
        return new ResponseEntity<Funcionario>(funcionarioAtual, HttpStatus.OK);
    }
	
	//-------------------Buscar funcionário pelo nome--------------------------------------------------------
    @RequestMapping(value = "/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> buscarPeloNome(@PathVariable("nome") String nome) {
        System.out.println("Procurando funcionário com o nome: " + nome);
        Funcionario funcionario = funcionarioRepository.findByNomeIgnoreCase(nome);
        if (funcionario == null) {
            System.out.println("Funcionário com o nome:  " + nome + " , não encontrado.");
            return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }
	
    //-------------------Buscar funcionário pelo telefone--------------------------------------------------------
    @RequestMapping(value = "/{telefone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> buscarPeloTelefone(@PathVariable("telefone") String telefone) {
        System.out.println("Procurando funcionário com o telefone: " + telefone);
        Funcionario funcionario = funcionarioRepository.findByTelefone(telefone);
        if (funcionario == null) {
            System.out.println("Funcionário com o telefone:  " + telefone + " , não encontrado.");
            return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }
    
    //-------------------Buscar Todos os funcionários--------------------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Funcionario>> buscarTodos() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        if(funcionarios.isEmpty()){
            return new ResponseEntity<List<Funcionario>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
    }
	
	//------------------- Excluir Funcionário --------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Funcionario> excluir(@PathVariable("id") long id) {
        System.out.println("Excluindo o usário com o id " + id);
 
        Funcionario funcionario = funcionarioRepository.getOne(id);
        if (funcionario == null) {
            System.out.println("Não foi encontrado funcionário com o id " + id + ".");
            return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
        }
 
        funcionarioRepository.deleteById(id);
        return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
    }
	
    //------------------- Excluir todos os usuários --------------------------------------------------------  
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Funcionario> deleteAllUsers() {
        System.out.println("Excluindo todos os funcionários.");
 
        funcionarioRepository.deleteAll();
        return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
    }
}
