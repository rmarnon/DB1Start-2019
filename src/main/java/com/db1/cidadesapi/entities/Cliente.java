package com.db1.cidadesapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nome", length = 60)
	private String nome;
	private String cpf;
	private String telefone;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "conta_id")
	@MapsId
	private Conta conta;
	
	public Cliente() {
	}

	public Cliente(String nome, String cpf, String telefone, Conta conta) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public Conta getConta() {
		return conta;
	}
	
}
