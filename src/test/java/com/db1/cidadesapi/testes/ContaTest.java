package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
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


@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class ContaTest {

	@Autowired
	private ContaService contaService;
	@Autowired
	private AgenciaService agenciaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private CidadeService cidadeService;

	private Cliente clienteDefault;
	private Agencia agenciaDefault;
	private Estado estadoDefault;
	private Cidade cidadeDefault;

	@BeforeAll
	public void criaAgenciaEstadoCidadeDefault() {
		this.estadoDefault = estadoService.criarEstado("Paraná");
        this.cidadeDefault = cidadeService.criarCidade("Maringá", estadoDefault.getId());
        this.agenciaDefault = agenciaService.criaAgencia("123", "0372-7", cidadeDefault.getId());
        this.clienteDefault = clienteService.criaCliente("Rodrigo", "054.773.136-17", "9107-0678");
	}

	@BeforeEach
    public void deletarRegistrosantesDeCadaTeste() {
		contaService.deletarTodasAsContas();
	}

	@AfterAll
    public void deletarRegistrosDepoisDosTestes() {
		contaService.deletarTodasAsContas();
		agenciaService.deletarTodasAgencias();
		cidadeService.deletarTodasAsCidades();
		estadoService.deletarTodosOsEstados();
	}
	
	@Test
    public void deve_criar_uma_conta() {
        Double saldo = 100.00;
        Conta conta = contaService.criar(saldo, agenciaDefault.getId(), clienteDefault.getId());
        Assertions.assertEquals(conta.getSaldo(), saldo);
        Assertions.assertEquals(conta.getAgencia().getId(), agenciaDefault.getId());
        Assertions.assertEquals(conta.getCliente().getId(), clienteDefault.getId());
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
	
	@Test
	public void alterarTipoConta() {
		EstadoConta estadoAlterado = EstadoConta.INATIVA;
		contaService.alteraTipoConta(1L, "INATIVA");
		Conta novoEstadoDaConta = contaService.buscarPorId(1L);
		Assertions.assertEquals(estadoAlterado, novoEstadoDaConta.getEstado());
	}
	
	@Test
	public void tranfereValorDeConta() {
		double saldoAposTransferir = 400;
		double saldoAposReceber = 600;
		Conta contaSaida = contaService.buscarPorId(2L);
		Conta contaDestino = contaService.buscarPorId(3L);
		contaService.tranfereValores(contaSaida, contaDestino, 100.00);
		Assertions.assertEquals(saldoAposTransferir, contaSaida.getSaldo());
		Assertions.assertEquals(saldoAposReceber, contaDestino.getSaldo());
	}
	
	@After
	public void clean() {
		//contaService.limpar();
	}
	
}
