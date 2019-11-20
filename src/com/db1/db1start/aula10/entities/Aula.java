package com.db1.db1start.aula10.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.db1.db1start.aula11.exceptions.CampoNaoPodeSerNull;

public class Aula {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date data;
	
	private Materia materia;
	private List<Aluno> alunos = new ArrayList<>();
			
	public Aula() {
	}

	public Aula(Date data, Materia materia) {
		if(data == null) {
			throw new CampoNaoPodeSerNull("Data Invalida, entre com uma data no formato DD/MM/YYYY");
		}
		if(materia == null) {
			throw new CampoNaoPodeSerNull("Campo materia deve ser preenchido!");
		}
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

	public void addAluno(Aluno aluno) {
		if(aluno == null) {
			throw new CampoNaoPodeSerNull("Campo aluno vazio");
		}
		alunos.add(aluno);
	}
	
	public void removeAluno(Aluno aluno) {
		if(alunos.size() < 0) {
			throw new NullPointerException("A lista esta vazia!");
		}
		alunos.remove(aluno);
	}
	
	public int quantidadeDeAlunosPresentes() {
        return alunos.size();
    }
	
	public void darPresenca(Aluno aluno) {
        if (aluno == null) {
            throw new CampoNaoPodeSerNull("Campo aluno vazio");
        }
        this.alunos.add(aluno);
    }
	
	@Override
	public String toString() {
		return "Aula [data: " + sdf.format(data) + " " +  materia + "]";
	}
		
}
