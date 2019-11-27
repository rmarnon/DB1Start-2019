package com.db1.cidadesapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.entities.Agencia;
import com.db1.cidadesapi.entities.Cliente;
import com.db1.cidadesapi.entities.Conta;
import com.db1.cidadesapi.enums.EstadoConta;
import com.db1.cidadesapi.repositories.ContaRepository;

@Service
public class Contaservice {

	@Autowired
	private ContaRepository repo;
	
	public Conta criarConta(Agencia agencia, Double saldo, Cliente cliente, EstadoConta estado) {
		Conta conta = new Conta(agencia, saldo, cliente, estado);
		return conta;
	}
	
	public void limpar() {
		repo.deleteAll();
	}
	
	public Conta buscarPorId(Long id) {
		Optional<Conta> estado = repo.findById(id);
		return estado.orElseThrow(() -> new RuntimeException("Conta nao encontrada! id: " 
				+ id + ", Tipo: " + Conta.class.getName()));
	}	
	
	
}
