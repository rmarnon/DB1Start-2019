package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.cidadesapi.entities.Cliente;
import com.db1.cidadesapi.services.ClienteService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteTest {

	@Autowired
	public ClienteService clienteService;
	
	@Test
	public void test() {		
		Cliente cliente = clienteService.criaCliente("Rodrigo", "123456789-0", "44987654321");
		
		assertNotNull(cliente);
		System.out.println(cliente.getId());
	}
	
	@Test
	public void deveBuscarPorNome( ) {
		Cliente cliente = clienteService.buscarPorId(2L);
		assertNotNull(cliente);
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
