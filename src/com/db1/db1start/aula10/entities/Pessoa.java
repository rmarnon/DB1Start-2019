package com.db1.db1start.aula10.entities;

public abstract class Pessoa {

	private String nome;
	private String email;
	
	public Pessoa() {
	}	
	
	public Pessoa(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail_id(String email_id) {
		this.email = email_id;
	}

	@Override
	public String toString() {
		return "Email: " + email + " Nome: " + nome;
	}	
	
}
