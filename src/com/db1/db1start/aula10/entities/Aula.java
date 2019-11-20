package com.db1.db1start.aula10.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aula {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Date data;
	
	public Materia materia;
	public List<Aluno> alunos = new ArrayList<>();
			
	public Aula() {
	}

	public Aula(Date data, Materia materia) {
		super();
		this.data = data;
		this.materia = materia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	@Override
	public String toString() {
		return "Aula [data: " + sdf.format(data) + " " +  materia + "]";
	}
		
}
