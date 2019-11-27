package com.db1.cidadesapi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Agencia")
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private String digito;
	private String banco;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id", referencedColumnName = "id")
	private Cidade cidade;
	
	@JsonIgnore
	@OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private List<Conta> conta;
	
	public Agencia() {
	}

	public Agencia(Long id, String numero, String digito, String banco, Cidade cidade) {
		this.id = id;
		this.numero = numero;
		this.digito = digito;
		this.banco = banco;
		this.cidade = cidade;
		this.conta = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}
	
	public String getDigito() {
		return digito;
	}

	public String getBanco() {
		return banco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public List<Conta> getConta() {
		return conta;
	}
	
}
