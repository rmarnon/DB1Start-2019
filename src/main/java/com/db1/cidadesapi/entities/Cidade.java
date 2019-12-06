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

import com.db1.cidadesapi.enums.CidadeTipo;
import com.db1.cidadesapi.enums.EstadoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nome", length = 60, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
	private Estado estado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Agencia> agencias;
	
	private CidadeTipo tipo;
	
	public Cidade() {
	}
	
	public Cidade(String nome, Estado estado) {
		this.nome = nome;
		this.estado = estado;
		this.agencias = new ArrayList<>();
	}
	
	public Cidade(String nome, Estado estado, CidadeTipo cidadeTipo) {
		this.nome = nome;
		this.estado = estado;
		this.tipo = cidadeTipo;
		this.agencias = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public Estado getUf() {
		return estado;
	}
	
	public List<Agencia> getAgencia() {
		return agencias;
	}
	
	public Long getId() {
		return id;
	}

	public void setNome(String novoNome) {
		this.nome = novoNome;
		
	}

	public CidadeTipo getTipo() {
		return tipo;
	}
	
	public void alteraTipo(CidadeTipo tipo) {
		this.tipo = tipo;
	}
	
}
