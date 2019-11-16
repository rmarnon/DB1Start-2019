package com.db1.db1start.aula07;

public class Application {

	public int soma(int n1, int n2) {
		return n1 + n2;
	}

	public int subtracao(int n1, int n2) {
		return n1 - n2;
	}

	public int multiplicacao(int n1, int n2) {
		return n1 * n2;
	}

	public double divisao(double n1, double n2) {
		return n1 / n2;
	}

	public boolean par(int numero) {
		return (numero % 2 == 0) ? true : false;
	}

	public int maior(int n1, int n2) {
		return (n1 > n2) ? n1 : n2;
	}

	public int contaImpar(int numero) {
		return (par(numero)) ? numero / 2 : numero / 2 + 1;
	}

	public String maiusculo(String texto) {
		return texto.toUpperCase();
	}

	public String minusculo(String texto) {
		return texto.toLowerCase();
	}

	public String retornaLetrasComEspaco(String frase) {
		return frase.replaceAll("[^A-Z]", "");
	}

	public int retornaQuantidadeDeLetras(String frase) {
		return retornaLetrasComEspaco(frase).length();
	}

	public String contarOsQuatroPrimeirosCaracteresDoNome(String nome) {
		return nome.substring(0, 4);
	}

	public String retornaNomeAPartirDaTerceiraLetra(String nome) {
		return nome.substring(3);
	}

	public String reornaOsQuatroUltimosCaracteresDoNome(String nome) {
		return nome.substring(nome.length() - 4);
	}

	public String substituiPrimeiroNome(String nome) {
		return nome.replace("Rodrigo", "ALUNO");
	}

	public String[] separaTexto(String frase) {
		return frase.split(", ");
	}

	public int contarVogais(String texto) {
		return texto.toUpperCase().replaceAll("[^AEIOU]", "").length();
	}

	public String inverteTexto(String texto) {
		return (new StringBuilder(texto).reverse().toString());
	}

	public double menorValorComDoisDouble(double valor1, double valor2) {
		return (valor1 < valor2) ? valor1 : valor2;
	}

	public double menorValorComTresDoubles(double valor1, double valor2, double valor3) {
		return menorValorComDoisDouble(menorValorComDoisDouble(valor1, valor2), valor3);
	}

	public double calculaMedia(double valor1, double valor2, double valor3) {
		return (valor1 + valor2 + valor3) / 3.0;
	}

	public double calculaAreaDoTriangulo(double base, double altura) {
		return base * altura / 2.0;
	}

}

