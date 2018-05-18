package com.model;

import javax.persistence.*;


import lombok.Data;

@Entity
@Data
@Table(name="funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String nome;

	@Column
	private Double salario;
	
	@Column
	private Long funcao;
	
	@Column
	private String telefone;
	
}
