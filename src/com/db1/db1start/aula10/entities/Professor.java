package com.db1.db1start.aula10.entities;

import com.db1.db1start.aula11.exceptions.CampoNaoPodeSerNull;

public class Professor extends Pessoa{

	public Double salario;
	
	public Professor() {
	}

	public Professor(String nome, String email) {
		super(nome, email);
	}
	
	public Professor(String nome, String email, Double salario) {
		super(nome, email);
		if(salario == null) {
			throw new CampoNaoPodeSerNull("Campo salario deve ser informado!");
		}
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

