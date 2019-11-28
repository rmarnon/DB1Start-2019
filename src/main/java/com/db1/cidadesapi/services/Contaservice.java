package com.db1.cidadesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.entities.Agencia;
import com.db1.cidadesapi.entities.Cliente;
import com.db1.cidadesapi.entities.Conta;
import com.db1.cidadesapi.enums.EstadoConta;
import com.db1.cidadesapi.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repo;
	
	public Conta criarConta(Agencia agencia, Double saldo, Cliente cliente, EstadoConta estado) {
		Conta conta = new Conta(agencia, saldo, cliente, estado);
		return repo.save(conta);
	}
	
	public void limpar() {
		repo.deleteAll();
	}
	
	public Conta buscarPorId(Long id) {
		Optional<Conta> estado = repo.findById(id);
		return estado.orElseThrow(() -> new RuntimeException("Conta nao encontrada! id: " 
				+ id + ", Tipo: " + Conta.class.getName()));
	}
	
	public List<Conta> retornaTodasAsContas() {
		List<Conta> conta = repo.findAll();
		return conta;
	}
	
	public void sacar(Long id, double valor) {
		Optional<Conta> conta = repo.findById(id);
		conta.ifPresent(con -> {
			con.saque(valor);
			repo.save(con);
		});
	}
	
	public void alteraTipoConta(Long id, String estado) {
		Optional<Conta> conta = repo.findById(id);
		conta.ifPresent(con -> {
			con.alteraTipo(EstadoConta.valueOf(estado));
			repo.save(con);
		});
	}
	
	public void tranfereValores(Conta contaSaida, Conta contaDestino, double valor) {
		Optional<Conta> conta = repo.findById(contaSaida.getId());		
		conta.ifPresent(operacao -> {
			operacao.transferencia(100.00, contaDestino);
			repo.save(operacao);
		});
	}	
	
}
