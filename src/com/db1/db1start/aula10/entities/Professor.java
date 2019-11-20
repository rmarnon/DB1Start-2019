package com.db1.db1start.aula10.entities;

public class Professor extends Pessoa{

	public Double salario;
	
	public Professor() {
	}

	public Professor(String nome, String email) {
		super(nome, email);
	}
	
	public Professor(String nome, String email, Double salario) {
		super(nome, email);
		this.salario = salario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return super.toString() + " \nSalario: " + salario;
	}

}

