package com.db1.db1start.aula10.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.db1.db1start.aula10.entities.Aluno;
import com.db1.db1start.aula10.entities.Aula;
import com.db1.db1start.aula10.entities.Materia;
import com.db1.db1start.aula10.entities.Professor;

public class App {

	public static void main(String[] args) throws ParseException {
		
		List<Aluno> alunos = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Aluno aluno1 = new Aluno("Maiko Cunha", "maiko.cunha@db1.com.br", 9.8);		
		Aluno aluno2 = new Aluno("Joao silva","joao.silva@db1.com.br", 8.6);
		
		Professor professor1 = new Professor("Igor silva", "Igor.Silva@db1.com.br", 1500.00);
		
		Materia materia = new Materia();
		materia.name = "POO";
		materia.descricao = "Programacao Orientada a Objetos";
		materia.cargaHoraria = 80.0;
		materia.quantidadeDeAulas  = 40;
		materia.professor = professor1;
		
		Aula aula = new Aula();
		aula.data = sdf.parse("19/11/2019");
		aula.materia = materia;
		aula.alunos.add(aluno1);
		aula.alunos.add(aluno2);
		
		alunos.add(aluno1);
		alunos.add(aluno2);
		
		alunos.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------");
		System.out.println(aula);		
	}

}
