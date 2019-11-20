package com.db1.db1start.aula10.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.db1.db1start.aula10.entities.Aluno;
import com.db1.db1start.aula10.entities.Aula;
import com.db1.db1start.aula10.entities.Materia;
import com.db1.db1start.aula10.entities.Professor;
import com.db1.db1start.aula11.exceptions.CampoNaoPodeSerNull;

public class AlunoTeste {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Test
	public void deveCriarAlunoComConstrutor() {
		String name = "nomeAluno";
		String email = "email@aluno.com";
		Aluno aluno = new Aluno(name, email);
		Assert.assertEquals(name, aluno.getNome());
		Assert.assertEquals(email, aluno.getEmail());
	}	
	
	@Test
	public void deveCriarAlunoComConstrutorComSobrecargaNota() {
		String name = "nomeSegundoAluno";
		String email = "segundoAluno@gmail.com";
		Double nota = 8.5;
		Aluno aluno = new Aluno(name, email, nota);
		Assert.assertEquals(name, aluno.getNome());
		Assert.assertEquals(email, aluno.getEmail());
		Assert.assertEquals(nota, aluno.getNota());
	}
	
	@Test
	public void deveLancarExcetionComEmailNulo() {
		String name = "alunoName";
		try {
			Aluno aluno = new Aluno(name, null);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo email nao pode ser nulo!", naoPodeSerNulo.getMessage());
		}
	}	
	
	@Test
	public void deveLancarExceptionComNomeNulo() {
		String email = "aluno@Email";
		try {
			Aluno aluno = new Aluno(null, email);
		} 
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo nome nao pode ser nulo!", naoPodeSerNulo.getMessage());
		}
	}
	
	@Test
	public void deveLancarExceptionComNotaNulo() {
		String email = "aluno@Email.com";
		String name = "alunoName";
		try {
			Aluno aluno = new Aluno(name, email, null);
		} 
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo Nota nao possui valor informado!", naoPodeSerNulo.getMessage());
		}
	}
	
	@Test
    public void deveAdicionarAlunoNaChamada() throws ParseException {
	    String nome = "nomeAluno";
        String email = "email@aluno.com";    
        Date data = sdf.parse("20/11/2019");
        Professor professor = new Professor("professor@email.com", "nomeProfessor");
        Materia materia = new Materia("POO", "Programacao Orientada a Objetos", 10.5, 3, professor);
        Aula aula = new Aula(data, materia);
        Assert.assertEquals(0, aula.quantidadeDeAlunosPresentes());
        Aluno aluno = new Aluno(email, nome);
        aula.darPresenca(aluno);
        Assert.assertEquals(1, aula.quantidadeDeAlunosPresentes());
    }
	
}
