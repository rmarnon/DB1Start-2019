package com.db1.db1start.aula12.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.db1.db1start.aula12.entities.ContaCorrente;
import com.db1.db1start.aula12.entities.Movimentacao;
import com.db1.db1start.aula12.entities.Poupanca;

public class Application {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		List<Movimentacao> extrato = new ArrayList<>();
		ContaCorrente contaCorrente;
		
		
		String nome = "Rodrigo Marnon";
		Integer conta = 1234567890;
		Poupanca poupanca = new Poupanca(nome, conta);
		Poupanca poupanca2 = new Poupanca(nome, conta);
		String data = sdf.format(sdf.parse("21/11/2019 17:42:55"));
		String data2 = sdf.format(sdf.parse("20/11/2019 06:43:02"));
		String deposito = "Deposito";
		poupanca.depositar(100.00);
		Double valor = 100.00;
		
		Movimentacao movimentacao = new Movimentacao(poupanca.getName(), poupanca.getNumeroDaConta(), data, deposito, valor, poupanca.getSaldo());
		extrato.add(movimentacao);
		
		String saque = "Saque";
		poupanca.sacar(20.00);	
		Double valor2 = 20.00;
		movimentacao = new Movimentacao(poupanca.getName(), poupanca.getNumeroDaConta(), data2, saque, valor2, poupanca.getSaldo());
		extrato.add(movimentacao);		
		
		String tranferencia = "Transferencia";
		poupanca.transferencia(50.00, poupanca2);
		Double valor3 = 50.00;
		movimentacao = new Movimentacao(poupanca.getName(), poupanca.getNumeroDaConta(), data2, tranferencia, valor3, poupanca.getSaldo());
		extrato.add(movimentacao);
		
		extrato.forEach(System.out::println);
	}

}
