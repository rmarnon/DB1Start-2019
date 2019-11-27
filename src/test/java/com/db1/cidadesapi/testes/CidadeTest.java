package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.services.CidadeService;
import com.db1.cidadesapi.services.EstadoService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeTest {

	@Autowired
	public EstadoService estadoService;
	@Autowired
	public CidadeService cidadeService;
	
	@Test
	public void test() {
		Estado estado = estadoService.criarEstado("Parana");
		Cidade cidade = cidadeService.criarCidade("Maringa", estado);
		
		assertNotNull(cidade);
		System.out.println(cidade.getId());
	}
	
	@Test
	public void deveBuscarPorCidade( ) {
		Cidade cidade = cidadeService.buscarPorNome("Maringa");
		assertNotNull(cidade);
	}
	
	@Test
	public void deveLancarExcessao() {
		try {
			Cidade cidade = cidadeService.buscarPorNome("Belo Horizonte");
			assertNotNull(cidade);
		}
		catch (RuntimeException msg) {
			System.out.println(msg.getMessage());
		}
	}
	
	@After
	public void clean() {
		//cidadeService.limpar();
	}
	
	
}
