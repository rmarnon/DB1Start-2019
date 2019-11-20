package com.db1.db1start.aula10.entities;

public class Materia {

	public String name;
	public String descricao;
	public Double cargaHoraria;
	public Integer quantidadeDeAulas;
	
	public Professor professor;
	
	public Materia() {
	}		

	public Materia(String name, String descricao, Double cargaHoraria, Integer quantidadeDeAulas) {
		super();
		this.name = name;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
		this.quantidadeDeAulas = quantidadeDeAulas; 
	}	
	
	public Materia(String name, String descricao, Double cargaHoraria, Integer quantidadeDeAulas, Professor professor) {
		super();
		this.name = name;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
		this.quantidadeDeAulas = quantidadeDeAulas; 
		this.professor = professor;
	}	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getCargaHoraria() {
		return cargaHoraria;
	}


	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


	public Integer getQuantidadeDeAulas() {
		return quantidadeDeAulas;
	}


	public void setQuantidadeDeAulas(Integer quantidadeDeAulas) {
		this.quantidadeDeAulas = quantidadeDeAulas;
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "\nMateria [name: " + name + ", \ndescricao: " + descricao + ",\ncargaHoraria: " + cargaHoraria
				+ ", \nquantidadeDeAulas: " + quantidadeDeAulas + ", \nprofessor:" + professor + "]";
	}	
	
}
