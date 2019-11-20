package com.db1.db1start.aula10.entities;

import com.db1.db1start.aula11.exceptions.CampoNaoPodeSerNull;

public class Aluno extends Pessoa{

	public Double nota;
	
	public Aluno() {
		super();
	}	
	
	public Aluno(String nome, String email, Double nota) {
		super(nome, email);
		if(nota == null) {
			throw new CampoNaoPodeSerNull("Campo Nota nao possui valor informado!");
		}
		this.nota = nota;
	}
	
	public Aluno(String nome, String email) {
		super(nome, email);
	}	
		
	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return super.toString()  + " Notas: " + nota;
	}
	
}
