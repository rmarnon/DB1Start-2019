package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
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

import com.db1.cidadesapi.entities.Cliente;
import com.db1.cidadesapi.services.ClienteService;


@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class ClienteTest {

	@Autowired
	public ClienteService clienteService;
	
	@BeforeEach
    public void deletarRegistrosAntesDeCadaTeste() {
		clienteService.deletarTodosOsCliente();
	}

	@AfterAll
    public void deletarRegistrosDepoisDosTestes() {
		clienteService.deletarTodosOsCliente();
	}
	
	@Test
    public void deveCriarCliente() {
        String cpf = "054.773.136-17";
        String nome = "Rodrigo";
        String telefone = "44 9107-0678";
        Cliente cliente = clienteService.criaCliente(nome, cpf, telefone);
        Assertions.assertEquals(cliente.getName(), nome);
        Assertions.assertEquals(cliente.getCpf(), cpf);
        Assertions.assertEquals(cliente.getTelefone(), telefone);
    }
	
	@Test
	public void deveBuscarPorNome( ) {
		Cliente cliente = clienteService.buscarPorId(2L);
		assertNotNull(cliente);
	}
	
	@Test
    public void deve_buscar_todos_os_clientes() {
		Cliente cliente1 = clienteService.criaCliente("Nyna", "879.566.371-64", "44 3131-3131");
		Cliente cliente2 = clienteService.criaCliente("Gisely", "023.812.632-08", "44 3232-3232");
		Cliente cliente3 = clienteService.criaCliente("Marli", "553.561.846-200", "44 3333-3333");
		Cliente cliente4 = clienteService.criaCliente("Carla", "070.97..966-44", "44 3434-3434");

    	List<Cliente> todosOsClientes = clienteService.buscarTodosOsClientes();
        List<Long> idsClientes = todosOsClientes.stream().map(Cliente::getId).collect(Collectors.toList());
        Assertions.assertEquals(todosOsClientes.size(), 4);
        Assertions.assertTrue(idsClientes.contains(cliente1.getId()));
        Assertions.assertTrue(idsClientes.contains(cliente2.getId()));
        Assertions.assertTrue(idsClientes.contains(cliente3.getId()));
        Assertions.assertTrue(idsClientes.contains(cliente4.getId()));
    }
	
	@Test
	public void deveLancarExcessao() {
		try {
			Cliente cliente = clienteService.buscarPorNome("Rodrigo");
			assertNotNull(cliente);
		}
		catch (RuntimeException msg) {
			System.out.println(msg.getMessage());
		}
	}
	
	@After
	public void clean() {
		//clienteService.limpar();
	}
	
	
}
