package com.db1.db1start.aula10.entities;

public class Aluno extends Pessoa{

	public Double nota;
	
	public Aluno() {
	}	
	
	public Aluno(String nome, String email, Double nota) {
		super(nome, email);
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
