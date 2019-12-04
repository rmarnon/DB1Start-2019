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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nome", nullable = false)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private List<Cidade> cidades;
	
	public Estado() {
	}

	public Estado(String nome) {
		this.nome = nome;
		this.cidades = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public Long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
