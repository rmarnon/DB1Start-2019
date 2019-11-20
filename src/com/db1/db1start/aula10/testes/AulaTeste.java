package com.db1.db1start.aula10.testes;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.db1.db1start.aula10.entities.Aula;
import com.db1.db1start.aula10.entities.Materia;

public class AulaTeste {

	@Test
	public void deveRetornarAula() {
		Materia materia = new Materia("Java", "Aula de Java OO", 70.0, 25);
		Date date = new Date();
		Aula aula = new Aula(date, materia);
		Assert.assertEquals(date, aula.getData());
		Assert.assertEquals(materia, aula.getMateria());
	}
	
}
