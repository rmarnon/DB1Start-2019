package com.db1.db1start.aula10.entities;

import com.db1.db1start.aula11.exceptions.CampoNaoPodeSerNull;

public class Materia {

	private String name;
	private String descricao;
	private Double cargaHoraria;
	private Integer quantidadeDeAulas;
	
	public Professor professor;
	
	public Materia() {
	}		

	public Materia(String name, String descricao, Double cargaHoraria, Integer quantidadeDeAulas) {
		if(name == null) {
			throw new  CampoNaoPodeSerNull("Campo nome nao pode ser nulo!");
		}
		if(descricao == null) {
			throw new  CampoNaoPodeSerNull("Campo descricao nao pode ser nulo!");
		}
		if(cargaHoraria == null) {
			throw new  CampoNaoPodeSerNull("Campo cargaHoraria nao pode ser nulo!");
		}
		if(quantidadeDeAulas == null) {
			throw new  CampoNaoPodeSerNull("Campo quantidade nao pode ser nulo!");
		}
		this.name = name;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
		this.quantidadeDeAulas = quantidadeDeAulas; 
	}	
	
	public Materia(String name, String descricao, Double cargaHoraria, Integer quantidadeDeAulas, Professor professor) {
		if(name == null) {
			throw new  CampoNaoPodeSerNull("Campo nome nao pode ser nulo!");
		}
		if(descricao == null) {
			throw new  CampoNaoPodeSerNull("Campo descricao nao pode ser nulo!");
		}
		if(cargaHoraria == null) {
			throw new  CampoNaoPodeSerNull("Campo cargaHoraria nao pode ser nulo!");
		}
		if(quantidadeDeAulas == null) {
			throw new  CampoNaoPodeSerNull("Campo quantidade nao pode ser nulo!");
		}
		if(professor == null) {
			throw new CampoNaoPodeSerNull("Professor deve ser informado!");
		}
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

	public void trocaProfessor(Professor professor) {
		this.professor = professor;
	}
	
	@Override
	public String toString() {
		return "\nMateria [name: " + name + ", \ndescricao: " + descricao + ",\ncargaHoraria: " + cargaHoraria
				+ ", \nquantidadeDeAulas: " + quantidadeDeAulas + ", \nprofessor:" + professor + "]";
	}	
	
}
