package com.db1.db1start.aula10.testes;

import org.junit.Assert;
import org.junit.Test;

import com.db1.db1start.aula10.entities.Professor;
import com.db1.db1start.aula11.exceptions.CampoNaoPodeSerNull;

public class ProfessorTeste {

	@Test
	public void deveCriarProfessorComConstrutor() {
		String name = "outroProfessor";
		String email = "outroProfessor@gmail.com";
		Professor professor = new Professor(name, email);
		Assert.assertEquals(name, professor.getNome());
		Assert.assertEquals(email, professor.getEmail());
	}
	
	@Test
	public void deveCriarProfessorComConstrutorESobrecargaDeSalario() {
		String name = "nomeProfessor";
		String email = "professor@email.com";
		Double salario = 1575.50;
		Professor professor = new Professor(name, email, salario);
		Assert.assertEquals(name, professor.getNome());
		Assert.assertEquals(email, professor.getEmail());
		Assert.assertEquals(salario, professor.getSalario());
	}	
	
	@Test
	public void deveLancarExceptionNomeNulo() {
		String email = "email@professor";
		Double salario = 2800.00;
		try {
			Professor professor = new Professor(null, email, salario);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo nome nao pode ser nulo!", naoPodeSerNulo.getMessage());
		}
	}
	
	@Test
	public void deveLancarExceptionEmailNulo() {
		String nome = "nomeProfessor";
		Double salario = 2800.00;
		try {
			Professor professor = new Professor(nome, null, salario);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo email nao pode ser nulo!", naoPodeSerNulo.getMessage());
		}
	}
		
	@Test
	public void deveKancarExceptionSalarioNull() {
		String nome = "nomeProfessor";
		String email = "emailProfessor";
		try {
			Professor professor = new Professor(nome, email, null);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo salario deve ser informado!", naoPodeSerNulo.getMessage());
		}
	}	
	
}
