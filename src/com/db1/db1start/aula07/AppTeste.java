package com.db1.db1start.aula07;

import org.junit.Assert;
import org.junit.Test;

public class AppTeste {

	Application application = new Application();
	
	@Test
	public void somaDeveRetornar5() {			
		int expected = 5;
		int response = application.soma(2, 3);
		Assert.assertEquals(expected, response);		
	}
	
	@Test
	public void somaDeveRetornar8() {	
		int expected = 8;
		int response = application.soma(5, 3);
		Assert.assertEquals(expected, response);		
	}
	
	@Test
	public void subtracaoDeveRetornar7() {
		int expected = 7;
		int response = application.subtracao(10, 3);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void subtracaoDeveRetornar3() {
		int expected = 3;
		int response = application.subtracao(7, 4);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void multilicacaoRetorna35() {
		int expected = 35;
		int response = application.multiplicacao(7, 5);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void multilicacaoRetorna125() {
		int expected = 125;
		int response = application.multiplicacao(25, 5);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void divisaoRetorna2ponto5() {
		double expected = 2.5;
		double response = application.divisao(10.0, 4.0);
		Assert.assertEquals(expected, response, 0.0);
	}
	
	@Test
	public void divisaoRetorna6() {
		double expected = 6.0;
		double response = application.divisao(42.0, 7.0);
		Assert.assertEquals(expected, response, 0.0);
	}
	
	@Test
	public void testaParTrue() {
		boolean expected  = true;
		boolean response = application.par(10);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void testaParFalse() {
		boolean expected  = false;
		boolean response = application.par(13);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void testaMaiorValor10() {
		int expected = 10;
		int response = application.maior(10, 5);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void testaMaiorValor55() {
		int expected = 55;
		int response = application.maior(13, 55);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void contadorDeImpar5() {
		int expected = 5;
		int response = application.contaImpar(10);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void contadorDeImpar27() {
		int expected = 27;
		int response = application.contaImpar(54);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void textoEmMaiusculo() {
		String expected = "TEXTO_MAIUSCULO";
		String response = application.maiusculo("texto_maiusculo");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void textoEmMinusculo() {
		String expected = "texto_minusculo";
		String response = application.minusculo("TEXTO_MINUSCULO");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void retornaQuantidadeDeLetrasDB1START7() {;
		int expected = 7;
		int response = application.retornaQuantidadeDeLetras("DB1START");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void retornaDBSTARTComEspacos() {;
		String expected = "DBSTART";
		String response = application.retornaLetrasComEspaco(" DB1START ");
		Assert.assertEquals(expected, response);
	}

	
	@Test
	public void retornaQuatroPrimeirasLetrasDoNome() {
		String expected = "Rodr";
		String response = application.contarOsQuatroPrimeirosCaracteresDoNome("Rodrigo Marnon Veloso Barros de Morais");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void mostraNomeAPartirDoTerceirocaractere() {
		String expected = "rigo Marnon Veloso Barros de Morais";
		String response = application.retornaNomeAPartirDaTerceiraLetra("Rodrigo Marnon Veloso Barros de Morais");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void mostrarOsQuatroultimoscaracteresDoNome() {;
		String expected = "rais";
		String response = application.reornaOsQuatroUltimosCaracteresDoNome("Rodrigo Marnon Veloso Barros de Morais");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void substituirPrimeroNomePorALUNO() {
		String expected = "ALUNO Marnon Veloso Barros de Morais";
		String response = application.substituiPrimeiroNome("Rodrigo Marnon Veloso Barros de Morais");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void exibeTextoSeparado() {
		String[] expected =  {"banana", "maca", "melancia"};
		String[] response = application.separaTexto("banana, maca, melancia");
		Assert.assertArrayEquals(expected, response);
	}
	
	@Test
	public void contaVogal02() {
		int expected = 02;
		int response = application.contarVogais("Texto");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void contaVogal14() {
		int expected = 14;
		int response = application.contarVogais("Rodrigo Marnon Veloso Barros de Morais");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void devolveTextoInvertido() {
		String expected = "otxet";
		String response = application.inverteTexto("texto");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void devolveNomeInvertido() {
		String expected = "ogirdoR";
		String response = application.inverteTexto("Rodrigo");
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void retornaMenorValorEntreDoisDouble7() {
		double expected = 7.0;
		double response = application.menorValorComDoisDouble(15.0, 7.0);
		Assert.assertEquals(expected, response, 0.0);
	}
	
	@Test
	public void retornaMenorValorEntreDoisDouble5ponto5() {
		double expected = 5.50;
		double response = application.menorValorComDoisDouble(5.5, 7.8);
		Assert.assertEquals(expected, response, 0.0);
	}
	
	@Test
	public void retornMenorValorEntreTresDoubles73() {
		double expected = 73;
		double response = application.menorValorComTresDoubles(95, 89, 73);
		Assert.assertEquals(expected, response, 0.0);
	}
	
	@Test
	public void retornMenorValorEntreTresDoubles115() {
		double expected = 115;
		double response = application.menorValorComTresDoubles(176, 115, 259);
		Assert.assertEquals(expected, response, 0.0);
	}
	
	@Test
	public void mediaEntreTresValores6() {
		double expected = 6;
		double result = application.calculaMedia(2, 5, 11);
		Assert.assertEquals(expected, result, 0.0);
	}
	
	@Test
	public void mediaEntreTresValores33() {
		double expected = 33;
		double result = application.calculaMedia(50, 19, 30);
		Assert.assertEquals(expected, result, 0.0);
	}
	
	@Test
	public void retornaAreaDoTriangulo10() {
		double expected = 10.0;
		double result = application.calculaAreaDoTriangulo(4, 5);
		Assert.assertEquals(expected, result, 0.0);
	}
	
	@Test
	public void retornaAreaDoTriangulo40() {
		double expected = 40.0;
		double result = application.calculaAreaDoTriangulo(8, 10);
		Assert.assertEquals(expected, result, 0.0);
	}
	
}
