package com.db1.cidadesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.entities.Agencia;
import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.repositories.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository repo;
	
	public Agencia criaAgencia(String numero, String digito, String banco, Cidade cidade) {
		Agencia agencia = new  Agencia(numero, digito, banco, cidade);
		return repo.save(agencia);
	}
	
	public void limpar() {
		repo.deleteAll();
	}
	
	public Agencia buscarPorId(Long id) {
		Optional<Agencia> agencia = repo.findById(id);
		return agencia.orElseThrow(() -> new RuntimeException("Agencia nao identificada! id: " 
				+ id + ", Tipo: " + Agencia.class.getName()));
	}
	
	public List<Agencia> buscarTodasAgencias() {
		List<Agencia> agencia = repo.findAll();
		return agencia;
	}
}
