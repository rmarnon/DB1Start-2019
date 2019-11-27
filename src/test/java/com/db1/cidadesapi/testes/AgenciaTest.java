package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.cidadesapi.entities.Agencia;
import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.services.AgenciaService;
import com.db1.cidadesapi.services.CidadeService;
import com.db1.cidadesapi.services.EstadoService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenciaTest {

	@Autowired
	public AgenciaService agenciaService;
	@Autowired
	public EstadoService estadoService;
	@Autowired
	public CidadeService cidadeService;
	
	@Test
	public void test() {		
		Estado estado = estadoService.criarEstado("Parana");
		Cidade cidade = cidadeService.criarCidade("Maringa", estado);
		Agencia agencia = agenciaService.criaAgencia("123", "1", "Banco do Brasil", cidade);
		
		assertNotNull(agencia);
		System.out.println(agencia.getNumero());
	}
	
	@Test
	public void deveBuscarPorId( ) {
		Agencia agencia = agenciaService.buscarPorId(4L);
		assertNotNull(agencia);
	}
	
	@Test
	public void deveLancarExcessao() {
		try {
			Agencia agencia = agenciaService.buscarPorId(4L);
			assertNotNull(agencia);
		}
		catch (RuntimeException msg) {
			System.out.println(msg.getMessage());
		}
	}
	
	@Test
	public void retornaTodasAsAgencias() {
		List<Agencia> agencia = agenciaService.buscarTodasAgencias();
		assertNotNull(agencia);
	}
	
	@After
	public void clean() {
		//agenciaService.limpar();
	}
	
}
