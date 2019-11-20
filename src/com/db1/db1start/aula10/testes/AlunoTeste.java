package com.db1.db1start.aula10.testes;

import org.junit.Assert;
import org.junit.Test;

import com.db1.db1start.aula10.entities.Aluno;

public class AlunoTeste {
	
	@Test
	public void deveCriaralunoComConstrutor() {
		String name = "nomeAluno";
		String email = "email@aluno.com";
		Aluno aluno = new Aluno(name, email);
		Assert.assertEquals(name, aluno.getNome());
		Assert.assertEquals(email, aluno.getEmail());
	}	
	
	@Test
	public void deveCriaralunoComConstrutorComSobrecargaNota() {
		String name = "nomeSegundoAluno";
		String email = "segundoAluno@gmail.com";
		Double nota = 8.5;
		Aluno aluno = new Aluno(name, email, nota);
		Assert.assertEquals(name, aluno.getNome());
		Assert.assertEquals(email, aluno.getEmail());
		Assert.assertEquals(nota, aluno.getNota());
	}
	
}
