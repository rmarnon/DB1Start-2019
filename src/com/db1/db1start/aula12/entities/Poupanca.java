package com.db1.db1start.aula12.entities;

import com.db1.db1start.aula12.exceptions.MinhaExcessao;

public class Poupanca extends Conta {
	
	public static final double  JUROS = 0.05;
	
	public Poupanca(String name, Integer numeroDaConta, Double depositoInicial) {
		super(name, numeroDaConta, depositoInicial);
		if((name == null) || (numeroDaConta == null) || (depositoInicial < 0)) {
			throw new MinhaExcessao("Campo(s) invalido(s)");
		}		
	}
	
	public Poupanca(String name, Integer numeroDaConta) {
		super(name, numeroDaConta);
		if((name == null) || (numeroDaConta == null)) {
			throw new MinhaExcessao("Campo(s) invalido(s)");
		}
	}	
	
	public void rendimento() {
		saldo += saldo * JUROS;
	}
	
}
