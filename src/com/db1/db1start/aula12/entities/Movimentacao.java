package com.db1.db1start.aula12.entities;

public class Movimentacao {
	
	private String nome;
	private Integer conta;
	private String data;
	private String operacao;
	private Double valor;
	private Double saldoAtual;
	
	public Movimentacao() {
	}

	public Movimentacao(String nome, Integer conta, String data, String operacao, Double valor, Double saldoAtual) {
		this.nome = nome;
		this.data = data;
		this.operacao = operacao;
		this.valor = valor;
		this.saldoAtual = saldoAtual;
		this.conta = conta;
	}

	public String getNome() {
		return nome;
	}

	public String getData() {
		return data;
	}

	public String getOperacao() {
		return operacao;
	}

	public Double getValor() {
		return valor;
	}

	public Double getSaldoAtual() {
		return saldoAtual;
	}
	
	public Integer getConta() {
		return conta;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titular: ");
		sb.append(nome + "\n");
		sb.append("Numero da Conta: ");
		sb.append(conta + "\n");
		sb.append("--------------------------------\n");
		sb.append("Data/Hora:  ");
		sb.append(data + "\n");
		sb.append("Operacao: \n");
		sb.append(operacao + ":                ");
		sb.append("R$");
		sb.append(String.format("%.2f\n", valor));
		sb.append("Saldo Atualizado:       ");
		sb.append("R$");
		sb.append(String.format("%.2f\n", saldoAtual));
		sb.append("\n--------------------------------\n");
		return sb.toString();
	}

}	