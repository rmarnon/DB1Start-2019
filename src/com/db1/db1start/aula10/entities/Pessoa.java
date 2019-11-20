package com.db1.db1start.aula10.entities;

import com.db1.db1start.aula11.exceptions.CampoNaoPodeSerNull;

public abstract class Pessoa {

	protected String nome;
	protected String email;
	
	public Pessoa() {
	}	
	
	public Pessoa(String nome, String email) {
		if(nome == null) {
			throw new CampoNaoPodeSerNull("Campo nome nao pode ser nulo!");
		}
		if(email == null) {
			throw new CampoNaoPodeSerNull("Campo email nao pode ser nulo!");
		}
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
