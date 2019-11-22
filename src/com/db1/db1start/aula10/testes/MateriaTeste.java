package com.db1.db1start.aula10.testes;

import org.junit.Assert;
import org.junit.Test;

import com.db1.db1start.aula10.entities.Materia;
import com.db1.db1start.aula10.entities.Professor;
import com.db1.db1start.aula11.exceptions.CampoNaoPodeSerNull;

public class MateriaTeste {

	@Test
	public void retornaMateriaCadastrada() {
		String name = "BDII";
		String descricao = "Banco de Dados II";
		Double cargaHoraria = 80.5;
		Integer quantidadeDeAulas = 25;
		Materia materia = new Materia(name, descricao, cargaHoraria, quantidadeDeAulas);
		Assert.assertEquals(name, materia.getName());
		Assert.assertEquals(descricao, materia.getDescricao());
		Assert.assertEquals(cargaHoraria, materia.getCargaHoraria());
		Assert.assertEquals(quantidadeDeAulas, materia.getQuantidadeDeAulas());
	}
	
	@Test
	public void retornaMateriaCadastradaComSobrecargaDeProfessor() {
		Professor professor = new Professor("Professor", "professor@email.com", 15750.00);
		String name = "ESOFT";
		String descricao = "Engenharia de Software";
		Double cargaHoraria = 120.0;
		Integer quantidadeDeAulas = 40;
		Materia materia = new Materia(name, descricao, cargaHoraria, quantidadeDeAulas, professor);
		Assert.assertEquals(name, materia.getName());
		Assert.assertEquals(descricao, materia.getDescricao());
		Assert.assertEquals(cargaHoraria, materia.getCargaHoraria());
		Assert.assertEquals(quantidadeDeAulas, materia.getQuantidadeDeAulas());
	}
	
	@Test
	public void deveLancarExceptionProfessorNull() {
		String name = "ESOFT";
		String descricao = "Engenharia de Software";
		Double cargaHoraria = 120.0;
		Integer quantidadeDeAulas = 40;
		try {
			Materia materia = new Materia(name, descricao, cargaHoraria, quantidadeDeAulas, null);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Professor deve ser informado!", naoPodeSerNulo.getMessage());
		}
	}
	
	@Test
	public void deveLancarExceptionNomeNulo() {
		Professor professor = new Professor("Professor", "professor@email.com", 15750.00);
		String descricao = "Engenharia de Software";
		Double cargaHoraria = 120.0;
		Integer quantidadeDeAulas = 40;
		try {
			Materia materia = new Materia(null, descricao, cargaHoraria, quantidadeDeAulas, professor);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo nome nao pode ser nulo!", naoPodeSerNulo.getMessage());
		}
	}
	
	@Test
	public void deveLancarExceptionDescricaoNulo() {
		Professor professor = new Professor("Professor", "professor@email.com", 15750.00);
		String nome = "ESOFT";
		Double cargaHoraria = 120.0;
		Integer quantidadeDeAulas = 40;
		try {
			Materia materia = new Materia(nome, null, cargaHoraria, quantidadeDeAulas, professor);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo descricao nao pode ser nulo!", naoPodeSerNulo.getMessage());
		}
	}
	
	@Test
	public void deveLancarExceptionCargaHorariaNulo() {
		Professor professor = new Professor("Professor", "professor@email.com", 15750.00);
		String nome = "ESOFT";
		String descricao = "Engenharia de Software";
		Integer quantidadeDeAulas = 40;
		try {
			Materia materia = new Materia(nome, descricao, null, quantidadeDeAulas, professor);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo cargaHoraria nao pode ser nulo!", naoPodeSerNulo.getMessage());
		}
	}
	
	@Test
	public void deveLancarExceptionQuantidadeNulo() {
		Professor professor = new Professor("Professor", "professor@email.com", 15750.00);
		String nome = "ESOFT";
		String descricao = "Engenharia de Software";
		Double cargaHoraria = 120.0;
		try {
			Materia materia = new Materia(nome, descricao, cargaHoraria, null, professor);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Campo quantidade nao pode ser nulo!", naoPodeSerNulo.getMessage());
		}
	}
	
	@Test
	public void deveTrocarProfessor() {
		Professor professor1 = new Professor("ProfessorUm", "professor@um.com");
		Professor professor2 = new Professor("ProfessorDois", "professor@dois.com");
		Materia materia = new Materia("POO", "Programacao Orientada Objetos", 10.5, 3, professor1);
		Assert.assertEquals(professor1, materia.getProfessor());
		materia.trocaProfessor(professor2);
		Assert.assertEquals(professor2, materia.getProfessor());
	}
	
}
