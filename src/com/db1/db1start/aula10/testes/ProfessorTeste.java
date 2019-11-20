package com.db1.db1start.aula10.testes;

import org.junit.Assert;
import org.junit.Test;

import com.db1.db1start.aula10.entities.Professor;

public class ProfessorTeste {

	@Test
	public void deveCriaraProfessorComConstrutorESobrecargaDeSalario() {
		String name = "nomeProfessor";
		String email = "professor@email.com";
		Double salario = 1575.50;
		Professor professor = new Professor(name, email, salario);
		Assert.assertEquals(name, professor.getNome());
		Assert.assertEquals(email, professor.getEmail());
		Assert.assertEquals(salario, professor.getSalario());
	}	
		
	@Test
	public void deveCriaraProfessorComConstrutor() {
		String name = "outroProfessor";
		String email = "outroProfessor@gmail.com";
		Professor professor = new Professor(name, email);
		Assert.assertEquals(name, professor.getNome());
		Assert.assertEquals(email, professor.getEmail());
	}
	
}
