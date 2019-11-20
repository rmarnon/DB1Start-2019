package com.db1.db1start.aula10.testes;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.db1.db1start.aula10.entities.Aula;
import com.db1.db1start.aula10.entities.Materia;
import com.db1.db1start.aula11.exceptions.CampoNaoPodeSerNull;

public class AulaTeste {

	@Test
	public void deveCriarAula() {
		Materia materia = new Materia("Java", "Aula de Java OO", 70.0, 25);
		Date date = new Date();
		Aula aula = new Aula(date, materia);
		Assert.assertEquals(date, aula.getData());
		Assert.assertEquals(materia, aula.getMateria());
	}
	
	@Test
	public void deveLancarExceptionDataNull() {
		Materia materia = new Materia("Java", "Aula de Java OO", 70.0, 25);
		try {
			Aula aula = new Aula(null, materia);
		}
		catch (CampoNaoPodeSerNull naoPodeSerNulo) {
			Assert.assertEquals("Data Invalida, entre com uma data no formato DD/MM/YYYY", naoPodeSerNulo.getMessage());
		}
	}
	
	@Test
	public void deveLancarExceptionMateriaNulo() {
		Date data = new Date();
		try {
			Aula aula = new Aula(data, null);
		}
		catch (CampoNaoPodeSerNull naoPodeserNulo) {
			Assert.assertEquals("Campo materia deve ser preenchido!", naoPodeserNulo.getMessage());
		}
	}
	
}
