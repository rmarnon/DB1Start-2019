package com.db1.db1start.aula12.testes;

import org.junit.Assert;
import org.junit.Test;

import com.db1.db1start.aula12.entities.ContaCorrente;
import com.db1.db1start.aula12.entities.Poupanca;
import com.db1.db1start.aula12.exceptions.MinhaExcessao;

public class ContaTeste {

	@Test
	public void deveinstanciarContaCorrente() {
		String nome = "Rodrigo";
		Integer conta = 255;
		Double limite = 500.00;
		ContaCorrente rodrigo = new ContaCorrente(nome, conta, limite);
		Assert.assertEquals(nome, "Rodrigo");
		Assert.assertEquals(conta, rodrigo.getNumeroDaConta());
		Assert.assertEquals(limite, rodrigo.getLimiteDeCredito());
	}
	
	@Test
	public void deveinstanciarContaCorrenteComSobrecarga() {
		String nome = "Rodrigo";
		Integer conta = 255;
		Double deposito = 500.00;
		Double limite = 5000.00; 
		ContaCorrente rodrigo = new ContaCorrente(nome, conta, limite, deposito);
		Assert.assertEquals(nome, "Rodrigo");
		Assert.assertEquals(conta, rodrigo.getNumeroDaConta());
		Assert.assertEquals(deposito, rodrigo.getSaldo());
		Assert.assertEquals(limite, rodrigo.getLimiteDeCredito());
	}
	
	@Test
	public void deveInstanciarPoupanca() {
		String nome = "Rodrigo";
		Integer conta = 255;
		Poupanca rodrigo = new Poupanca(nome, conta);
		Assert.assertEquals(nome, "Rodrigo");
		Assert.assertEquals(conta, rodrigo.getNumeroDaConta());
	}
	
	@Test
	public void deveInstanciarPoupancaComConstrutor() {
	String nome = "Rodrigo";
	Integer conta = 255;
	Double deposito = 500.00;
	Poupanca rodrigo = new Poupanca(nome, conta, deposito);
	Assert.assertEquals(nome, "Rodrigo");
	Assert.assertEquals(conta, rodrigo.getNumeroDaConta());
	Assert.assertEquals(deposito, rodrigo.getSaldo());
	}
	
	@Test
	public void deveLancarExcessaoAoInstanciarContaComTitularNulo() {
		Integer conta = 255;
		try {
			Poupanca rodrigo = new Poupanca(null, conta);		
		}
		catch (MinhaExcessao msg) {
			Assert.assertEquals("Campo(s) invalido(s)", msg.getMessage());
		}
	}
	
	@Test
	public void deveLancarExcessaoAoInstanciarContaComContaNulo() {
		String nome = "Rodrigo";
		try {
			Poupanca rodrigo = new Poupanca(nome, null);		
		}
		catch (MinhaExcessao msg) {
			Assert.assertEquals("Campo(s) invalido(s)", msg.getMessage());
		}
	}
	
	@Test
	public void deveDepositar50() {
		Poupanca poupanca = new Poupanca("TitularPoupanca", 123456);
		Assert.assertEquals(0.0, poupanca.getSaldo(), 0);
		poupanca.depositar(50.00);
		Assert.assertEquals(50.00, poupanca.getSaldo(), 0);
	}
	
	@Test
	public void deveSacar100() {
		Poupanca poupanca = new Poupanca("TitularPoupanca", 123456, 500.00);
		Assert.assertEquals(500.00, poupanca.getSaldo(), 0.0);
		poupanca.sacar(100.00);
		Assert.assertEquals(400.00, poupanca.getSaldo(), 0.0);		
	}
	
	@Test
	public void deveTransferir200() {
		Poupanca poupanca = new Poupanca("TitularPoupanca", 123456789, 1000.00);
		Poupanca poupanca2 = new Poupanca("dependente", 987654321);
		Assert.assertEquals(1000.00, poupanca.getSaldo(), 0.0);
		Assert.assertEquals(0.00, poupanca2.getSaldo(), 0.0);
		poupanca.transferencia(200.00, poupanca2);	
		Assert.assertEquals(200.00, poupanca2.getSaldo(), 0.0);
		Assert.assertEquals(800.00, poupanca.getSaldo(), 0.0);
	}
}
