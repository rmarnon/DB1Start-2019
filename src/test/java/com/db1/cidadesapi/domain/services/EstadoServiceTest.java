package com.db1.cidadesapi.domain.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.services.EstadoService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoServiceTest {

	@Autowired
	private EstadoService service;
	
	@Test
	public void test() {
		Estado estado = service.criar("Parana");
		
		assertNotNull(estado);
		System.out.println(estado.getId());
	}
	
	/*@After
	public void clean() {
		service.limpar();
	}*/
	
	@Test
	public void deveBuscarPorEstado( ) {
		Estado estado = service.buscarPorNome("Parana");
		assertNotNull(estado);
	}
	
	@Test
	public void deveLancarExcessao() {
		try {
			Estado estado = service.buscarPorNome("Sao Paulo");
		}
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}	
}
