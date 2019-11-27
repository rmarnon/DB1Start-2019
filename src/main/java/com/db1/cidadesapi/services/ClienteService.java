package com.db1.cidadesapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.entities.Cliente;
import com.db1.cidadesapi.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente criaCliente(String nome, String cpf, String telefone) {
		Cliente cliente = new  Cliente(nome, cpf, telefone);
		return repo.save(cliente);
	}
	
	public void limpar() {
		repo.deleteAll();
	}
	
	public Cliente buscarPorNome(String nome) {
		return repo.findByNome(nome).orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
	}
	
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.orElseThrow(() -> new RuntimeException("Cliente nao encontrada! id: " 
				+ id + ", Tipo: " + Cliente.class.getName()));
	}
}
