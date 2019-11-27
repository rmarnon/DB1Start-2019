package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.services.EstadoService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoTest {

	@Autowired
	private EstadoService service;
	
	@Test
	public void test() {
		Estado estado = service.criarEstado("Parana");
		
		assertNotNull(estado);
		System.out.println(estado.getId());
	}
	
	@Test
	public void deveBuscarPorEstado( ) {
		Estado estado = service.buscarPorNome("Parana");
		assertNotNull(estado);
	}
	
	@Test
	public void deveLancarExcessao() {
		try {
			Estado estado = service.buscarPorNome("Sao Paulo");
			assertNotNull(estado);
		}
		catch (RuntimeException msg) {
			System.out.println(msg.getMessage());
		}
	}
	
	@After
	public void clean() {
		//service.limpar();
	}
}
