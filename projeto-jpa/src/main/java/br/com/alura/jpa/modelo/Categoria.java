package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	// Quando precisamos criar um construtor que recebe argumentos
	// precisamos também criar um construtor que padrão porque o Hibernate utiliza ele
	// para garantirmos que nenhum desenvolvedor utilize esse construtor precisamos anota-lo como @Deprected
	// esse construtor está aqui afim de manter a infra estrutura para o Hibernate
	@Deprecated
	public Categoria() {
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
