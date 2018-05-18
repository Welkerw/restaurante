package com.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroRestController {
	
	@RequestMapping("/")
	@ResponseBody
	String home() 
	{
		return "Teste";
	}
}
