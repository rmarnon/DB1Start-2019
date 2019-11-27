package com.db1.cidadesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;
	
	public Estado criar(String nome) {
		Estado estado = new Estado(nome);
		return repo.save(estado);
	}
	
	public void limpar() {
		repo.deleteAll();
	}
	
	public Estado buscarPorNome(String nome) {
		return repo.findByNome(nome).orElseThrow(() -> new RuntimeException("Estado nao encontrado"));
	}
	
	
}
