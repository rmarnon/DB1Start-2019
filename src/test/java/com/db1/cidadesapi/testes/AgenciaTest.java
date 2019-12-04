package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;

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
import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.services.AgenciaService;
import com.db1.cidadesapi.services.CidadeService;
import com.db1.cidadesapi.services.EstadoService;


@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class AgenciaTest {

	@Autowired
	public AgenciaService agenciaService;
	@Autowired
	public EstadoService estadoService;
	@Autowired
	public CidadeService cidadeService;
	
	private Estado estadoDefault;
	private Cidade cidadeDefault;
	
	@BeforeAll
	public void criarEstadoECidadeDefault() {
		this.estadoDefault = estadoService.criarEstado("Paraná");
        this.cidadeDefault = cidadeService.criarCidade("Maringá", estadoDefault.getId());
	}

	@BeforeEach
    public void deletarRegistrosAntesDeCadaTeste() {
		agenciaService.deletarTodasAgencias();
	}

	@AfterAll
    public void deletarRegistrosDepoisDosTestes() {
		agenciaService.deletarTodasAgencias();
		cidadeService.deletarTodasAsCidades();
		estadoService.deletarTodosOsEstados();
	}
	
	@Test
    public void deveCriarUmaAgencia() {
        String numero = "666";
        String numeroBanco = "0372-7";
        Agencia agencia = agenciaService.criaAgencia(numero, numeroBanco, cidadeDefault.getId());
        Assertions.assertEquals(agencia.getNumero(), numero);
        Assertions.assertEquals(agencia.getNumeroBanco(), numeroBanco);
        Assertions.assertEquals(agencia.getCidade().getId(), cidadeDefault.getId());
    }
	
	@Test
	public void deveBuscarPorId( ) {
		Agencia agencia = agenciaService.buscarPorId(1L);
		assertNotNull(agencia);
	}
	
	@Test
	public void deveLancarExcessao() {
		try {
			Agencia agencia = agenciaService.buscarPorId(1L);
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
	
	@Test
    public void deveRetornarTodasAsAgenciasDeUmaDeterminadaCidade() {
    	Cidade outraCidade = cidadeService.criarCidade("Londrina", estadoDefault.getId());
    	Agencia ag1 = agenciaService.criaAgencia("666", "0372-7", cidadeDefault.getId());
    	Agencia ag2 = agenciaService.criaAgencia("999", "0547-8", cidadeDefault.getId());
    	Agencia ag3 = agenciaService.criaAgencia("333", "1258-3", cidadeDefault.getId());
    	Agencia ag4 = agenciaService.criaAgencia("555", "7904-6", outraCidade.getId());

    	List<Agencia> todasAsAgenciasDaCidadeDefault = agenciaService.buscarTodasPeloIdDaCidade(cidadeDefault.getId());
        List<Long> idsAgenciasCidade = todasAsAgenciasDaCidadeDefault
        		.stream().map(Agencia::getId).collect(Collectors.toList());
        Assertions.assertEquals(todasAsAgenciasDaCidadeDefault.size(), 3);
        Assertions.assertTrue(idsAgenciasCidade.contains(ag1.getId()));
        Assertions.assertTrue(idsAgenciasCidade.contains(ag2.getId()));
        Assertions.assertTrue(idsAgenciasCidade.contains(ag3.getId()));
        Assertions.assertFalse(idsAgenciasCidade.contains(ag4.getId()));
    }
	
	@After
	public void clean() {
		//agenciaService.limpar();
	}
	
}
