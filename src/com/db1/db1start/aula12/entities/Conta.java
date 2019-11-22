package com.db1.db1start.aula12.entities;

import java.util.ArrayList;
import java.util.List;

import com.db1.db1start.aula12.exceptions.MinhaExcessao;

public abstract class Conta {

	private String name;
	private Integer numeroDaConta;
	protected double saldo;
	
	List<Movimentacao> movimentacao = new ArrayList<>();
		
	public Conta() {
	}

	public Conta(String name, Integer numeroDaConta, double depositoInicial) {
		if((name == null) || (numeroDaConta == null) || (depositoInicial < 0)) {
			throw new MinhaExcessao("Campo(s) invalido(s)");
		}
		this.name = name;
		this.numeroDaConta = numeroDaConta;
		depositar(depositoInicial);
	}
	
	public Conta(String name, Integer numeroDaConta) {
		if((name == null) || (numeroDaConta == null)) {
			throw new MinhaExcessao("Campo(s) invalido(s)");
		}
		this.name = name;
		this.numeroDaConta = numeroDaConta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public List<Movimentacao> getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
	}

	public void depositar(double montante) {
		saldo += montante;
	}
	
	public void sacar(Double montante) {
		if(montante > saldo) {
			throw new MinhaExcessao("Saldo insuficiente para saque!");
		}
		saldo -= montante;
	}	
	
	public void transferencia(double montante, Conta conta) {
		if(montante > saldo) {
			throw new MinhaExcessao("Saldo insuficiente para tranferencia!");
		}
		if(conta == null) {
			throw new MinhaExcessao("Conta inexistente");
		}
		sacar(montante);
		conta.depositar(montante);
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titular: ");
		sb.append(name + "\n");
		sb.append("Numero da Conta: ");
		sb.append(numeroDaConta + "\n");
		sb.append("Saldo Atualizado: ");
		sb.append(String.format("%.2f", getSaldo()));
		return sb.toString();
	}
	
}
