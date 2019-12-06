package com.db1.cidadesapi.dto;

import com.db1.cidadesapi.entities.Estado;

public class CidadeDTO {

	private Long id;
	private String nome;
	private Estado estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return nome;
	}
	public void setName(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}	
	
}
