package com.db1.db1start.aula10.testes;

import org.junit.Assert;
import org.junit.Test;

import com.db1.db1start.aula10.entities.Materia;
import com.db1.db1start.aula10.entities.Professor;

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
		Assert.assertEquals(cargaHoraria, materia.cargaHoraria);
		Assert.assertEquals(quantidadeDeAulas, materia.getQuantidadeDeAulas());
	}
	
	@Test
	public void retornaMateriaCadastradaComSobrecargaDeProfessor() {
		Professor professor = new Professor("Professor", "professor@email.com", 1575.00);
		String name = "ESOFT";
		String descricao = "BEngenharia de Software";
		Double cargaHoraria = 120.0;
		Integer quantidadeDeAulas = 40;
		Materia materia = new Materia(name, descricao, cargaHoraria, quantidadeDeAulas, professor);
		Assert.assertEquals(name, materia.getName());
		Assert.assertEquals(descricao, materia.getDescricao());
		Assert.assertEquals(cargaHoraria, materia.cargaHoraria);
		Assert.assertEquals(quantidadeDeAulas, materia.getQuantidadeDeAulas());
	}
	
}
