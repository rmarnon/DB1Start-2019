package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.cidadesapi.entities.Agencia;
import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.entities.Cliente;
import com.db1.cidadesapi.entities.Conta;
import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.enums.EstadoConta;
import com.db1.cidadesapi.services.AgenciaService;
import com.db1.cidadesapi.services.CidadeService;
import com.db1.cidadesapi.services.ClienteService;
import com.db1.cidadesapi.services.ContaService;
import com.db1.cidadesapi.services.EstadoService;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaTest {

	@Autowired
	public AgenciaService agenciaService;
	@Autowired
	public EstadoService estadoService;
	@Autowired
	public CidadeService cidadeService;
	@Autowired
	public ContaService contaService;
	@Autowired
	public ClienteService clienteService;
	
	@Test
	public void test() {		
		Estado estado = estadoService.criarEstado("Parana");
		Cidade cidade = cidadeService.criarCidade("Maringa", estado);
		Agencia agencia = agenciaService.criaAgencia("123", "1", "Banco do Brasil", cidade);
		Cliente cliente = clienteService.criaCliente("Rodrigo", "123456", "789");
		Conta conta = contaService.criarConta(agencia, 500.00, cliente, EstadoConta.ATIVA);
		
		assertNotNull(conta);
		System.out.println(conta.getSaldo());
	}
	
	@Test
	public void deveBuscarPorId( ) {
		Conta agencia = contaService.buscarPorId(1L);
		assertNotNull(agencia);
	}
	
	@Test
	public void deveLancarExcessao() {
		try {
			Conta conta = contaService.buscarPorId(1L);
			assertNotNull(conta);
		}
		catch (RuntimeException msg) {
			System.out.println(msg.getMessage());
		}
	}
	
	@Test
	public void retornaTodasAsContas() {
		List<Conta> contas = contaService.retornaTodasAsContas();
		assertNotNull(contas);
	}
	
	@Test
	public void deveSacar100() {
		Double saldoAposSaque = 400D;
		contaService.sacar(1L, 100.0);
		Conta contaAposSaque = contaService.buscarPorId(1L);
		Assertions.assertEquals(saldoAposSaque, contaAposSaque.getSaldo());
	}
	
	@After
	public void clean() {
		//contaService.limpar();
	}
	
}
