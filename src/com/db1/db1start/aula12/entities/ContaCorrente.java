package com.db1.db1start.aula12.entities;

import com.db1.db1start.aula12.exceptions.MinhaExcessao;

public class ContaCorrente extends Conta {
	
	private Double limiteDeCredito;
		
	public ContaCorrente(String name, Integer numeroDaConta, Double limiteDeCredito, Double depositoInicial) {
		super(name, numeroDaConta, depositoInicial);
		this.limiteDeCredito = limiteDeCredito;
	}
	
	public ContaCorrente(String name, Integer numeroDaConta, Double limiteDeCredito) {
		super(name, numeroDaConta);
		this.limiteDeCredito = limiteDeCredito;
	}
	
		public Double getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void emprestimo(Double montante) {
		if((montante > limiteDeCredito) || (saldo < montante)){
			throw new MinhaExcessao("Credito insufucuente");
		}
		depositar(montante);
	}

	@Override
	public void sacar(Double montante) {
		super.sacar(montante + 5.00);		
	}	
	
	public void taxaMensal(double taxa) {
		super.sacar(taxa);;
	}
	
}
