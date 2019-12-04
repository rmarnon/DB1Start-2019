package com.db1.cidadesapi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@Column(name = "numero", nullable = false)
	private String numero;
	
	@Column(name = "NumeroDoBanco", nullable = false)
	private String numeroBanco;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id", referencedColumnName = "id", nullable = false)
	private Cidade cidade;
	
	@JsonIgnore
	@OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private List<Conta> conta;
	
	public Agencia() {
	}

	public Agencia(String numero, String numeroBanco, Cidade cidade) {
		this.numero = numero;
		this.numeroBanco = numeroBanco;
		this.cidade = cidade;
		this.conta = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public List<Conta> getConta() {
		return conta;
	}

	public String getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(String numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	
}
