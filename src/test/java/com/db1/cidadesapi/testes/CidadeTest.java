package com.db1.cidadesapi.testes;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.entities.Conta;
import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.enums.CidadeTipo;
import com.db1.cidadesapi.enums.EstadoConta;
import com.db1.cidadesapi.services.CidadeService;
import com.db1.cidadesapi.services.EstadoService;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CidadeTest {

	@Autowired
	public EstadoService estadoService;
	@Autowired
	public CidadeService cidadeService;
	
	private Estado estadoDefault;
	
	@BeforeAll
	public void criarEstadoDefault() {
		this.estadoDefault = estadoService.criarEstado("Paraná");
	}

	@BeforeEach
	public void deletarRegistrosantesDeCadaTeste() {
		cidadeService.deletarTodasAsCidades();
	}

	@AfterAll
    public void deletarregistrosDepoisDosTestes() {
		cidadeService.deletarTodasAsCidades();
		estadoService.deletarTodosOsEstados();
	}
	
	@Test
    public void deveCrairCidade() {
        String nomeCidade = "Maringá";
        Cidade cidade = cidadeService.criarCidade(nomeCidade, estadoDefault.getId());
        Assertions.assertEquals(cidade.getNome(), nomeCidade);
    }

	@Test
    public void deveAtualizarNomeDaCidade() {
    	Cidade cidade = cidadeService.criarCidade("Maaaaringá", estadoDefault.getId());
        String novoNome = "Maringá";
        Cidade cidadeAtualizada = cidadeService.atualizarNomeDaCidade(cidade.getId(), novoNome);
        Assertions.assertEquals(cidadeAtualizada.getNome(), novoNome);
    }
	
	@Test
	public void deveBuscarPorCidadePorNome( ) {
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
	
	@Test
    public void deveBuscarCidadePeloId() {
    	Cidade cidade = cidadeService.criarCidade("Maringá", estadoDefault.getId());
        Cidade cidadeBuscada = cidadeService.buscarPorId(cidade.getId());
        Assertions.assertEquals(cidadeBuscada.getId(), cidade.getId());
        Assertions.assertEquals(cidadeBuscada.getNome(), "Maringá");
    }

    @Test
    public void deveBuscarTodasAsCidadesDeUmEstado() {
    	Estado outroEstado = estadoService.criarEstado("São Paulo");
    	cidadeService.criarCidade("Maringá", estadoDefault.getId());
    	cidadeService.criarCidade("Londrina", estadoDefault.getId());
    	cidadeService.criarCidade("Curitiba", estadoDefault.getId());
    	cidadeService.criarCidade("Campo Mourão", estadoDefault.getId());
    	cidadeService.criarCidade("Campinas", outroEstado.getId());

    	List<Cidade> todasAsCidadesDoEstado1 = cidadeService.buscarTodosPeloIdDaCidade(estadoDefault.getId());
        List<String> nomesCidadesEstado1 = todasAsCidadesDoEstado1
        		.stream().map(Cidade::getNome).collect(Collectors.toList());
        Assertions.assertEquals(todasAsCidadesDoEstado1.size(), 4);
        Assertions.assertTrue(nomesCidadesEstado1.contains("Maringá"));
        Assertions.assertTrue(nomesCidadesEstado1.contains("Londrina"));
        Assertions.assertTrue(nomesCidadesEstado1.contains("Curitiba"));
        Assertions.assertTrue(nomesCidadesEstado1.contains("Campo Mourão"));
        Assertions.assertFalse(nomesCidadesEstado1.contains("Campinas"));
    }

    @Test
    public void deveBuscarTodasAsCidadesCadastradas() {
    	cidadeService.criarCidade("Maringá", estadoDefault.getId());
    	cidadeService.criarCidade("Floresta", estadoDefault.getId());
    	cidadeService.criarCidade("Marialva", estadoDefault.getId());
    	cidadeService.criarCidade("Pato Branco", estadoDefault.getId());
    	cidadeService.criarCidade("Curitiba", estadoDefault.getId());
    	cidadeService.criarCidade("Londrina", estadoDefault.getId());

        List<Cidade> todasAsCidades = cidadeService.buscarTodasAsCidades();
        List<String> nomesCidades = todasAsCidades.stream().map(Cidade::getNome).collect(Collectors.toList());
        Assertions.assertEquals(todasAsCidades.size(), 6);
        Assertions.assertTrue(nomesCidades.contains("Maringá"));
        Assertions.assertTrue(nomesCidades.contains("Floresta"));
        Assertions.assertTrue(nomesCidades.contains("Marialva"));
        Assertions.assertTrue(nomesCidades.contains("Pato Branco"));
        Assertions.assertTrue(nomesCidades.contains("Curitiba"));
        Assertions.assertTrue(nomesCidades.contains("Londrina"));
    }

    @Test
    public void deve_deletar_uma_cidade_por_id() {
    	Cidade cidadeCriada = cidadeService.criarCidade("Maringá", estadoDefault.getId());
        cidadeService.deletarPorId(cidadeCriada.getId());

        Assertions.assertThrows(RuntimeException.class, () -> {
        	cidadeService.buscarPorId(cidadeCriada.getId());
        });
    }
    
    @Test
	public void alterarTipoCidade() {
		CidadeTipo tipoAlterado = CidadeTipo.INTERIOR;
		cidadeService.alterarTipoCidade(1L, "CAPITAL");
		Cidade novoTipoCidade = cidadeService.buscarPorId(1L);
		Assertions.assertEquals(tipoAlterado, novoTipoCidade.getTipo());
	}
	
	@After
	public void clean() {
		//cidadeService.limpar();
	}	
	
}
