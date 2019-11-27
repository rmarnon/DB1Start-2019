package com.db1.cidadesapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public Cidade criarCidade(String nome, Estado estado) {
		Cidade cidade = new Cidade(nome, estado);
		return repo.save(cidade);
	}
	
	public void limpar() {
		repo.deleteAll();
	}
	
	public Cidade buscarPorNome(String nome) {
		return repo.findByNome(nome).orElseThrow(() -> new RuntimeException("Cidade nao encontrado"));
	}
	
	public Cidade buscarPorId(Long id) {
		Optional<Cidade> cidade = repo.findById(id);
		return cidade.orElseThrow(() -> new RuntimeException("Cidade nao encontrada! id: " 
				+ id + ", Tipo: " + Cidade.class.getName()));
	}	
		
}
