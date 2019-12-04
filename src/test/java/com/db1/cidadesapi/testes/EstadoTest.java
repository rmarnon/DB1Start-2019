package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.services.EstadoService;


@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class EstadoTest {

	@Autowired
	private EstadoService estadoService;
	
	@BeforeEach
	public void deletarRgistrosAntesDeCadaTeste() {
		estadoService.deletarTodosOsEstados();
	}

	@AfterAll
	public void deletarRegistroDepoisDosTestes() {
		estadoService.deletarTodosOsEstados();
	}
	
	@Test
	public void CriarEstadoForma1() {
		String nomeEstado = "SantaCatarina";
		Estado estado = estadoService.criarEstado(nomeEstado);
		
		assertNotNull(estado);
		System.out.println(estado.getId());
	}
	
    @Test
    public void deveCriarEstadoForma2() {
        String nomeEsperado = "Minas Gerais";
        Estado estado = estadoService.criarEstado(nomeEsperado);
        Assert.assertEquals(estado.getNome(), nomeEsperado);
    }
	
	@Test
	public void deveBuscarPorEstado( ) {
		Estado estado = estadoService.buscarPorNome("Parana");
		assertNotNull(estado);
	}
	
	@Test
	public void deveAtualizarNomeDoEstado() {
		Estado estado = estadoService.criarEstado("Paranaue");
		String novoNome = "Paraná";
		Estado estadoAtualizado = estadoService.atualizarEstado(estado.getId(), novoNome);
		Assertions.assertEquals(estadoAtualizado.getNome(), novoNome);
	}
	
	@Test
	public void deveLancarExcessao() {
		try {
			Estado estado = estadoService.buscarPorNome("Sao Paulo");
			assertNotNull(estado);
		}
		catch (RuntimeException msg) {
			System.out.println(msg.getMessage());
		}
	}
	
	@Test
	public void deveBuscarEstadoPeloId() {
		Estado estado = estadoService.criarEstado("Bahia");
		Estado estadoBuscado = estadoService.buscarPorId(estado.getId());
		Assertions.assertEquals(estadoBuscado.getId(), estado.getId());
		Assertions.assertEquals(estadoBuscado.getNome(), "Bahia");
	}
	
	@Test
	public void deveBuscarTodosOsEstadosCadastrados() {
		estadoService.criarEstado("Amazonas");
		estadoService.criarEstado("Paraná");
		estadoService.criarEstado("São Paulo");
		estadoService.criarEstado("Rio de Janeiro");
		estadoService.criarEstado("Minas Gerais");
		
		List<Estado> todosOsEstados = estadoService.buscarTodos();
		List<String> nomesEstados = todosOsEstados.stream().map(Estado::getNome).collect(Collectors.toList());
		Assertions.assertEquals(todosOsEstados.size(), 5);
		Assertions.assertTrue(nomesEstados.contains("Amazonas"));
		Assertions.assertTrue(nomesEstados.contains("Paraná"));
		Assertions.assertTrue(nomesEstados.contains("São Paulo"));
		Assertions.assertTrue(nomesEstados.contains("Rio de Janeiro"));
		Assertions.assertTrue(nomesEstados.contains("Minas Gerais"));
	}

	@Test
	public void deveDeletarEstadoPorId() {
		Estado estadoCriado = estadoService.criarEstado("Minas Gerais");
		estadoService.deletarPorId(estadoCriado.getId());
	}	
	
	@Test
	public void deveDeletarEstadoPorIdForma2() {
		Estado estadoCriado = estadoService.criarEstado("Sergipe");
		estadoService.deletarPorId(estadoCriado.getId());
		Assertions.assertThrows(RuntimeException.class, () -> {
			estadoService.buscarPorId(estadoCriado.getId());
		});
	}
	
	@After
	public void clean() {
		//service.limpar();
	}
	
}
