package com.db1.db1start.aula06;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Integer numeroUm, numeroDois, soma, subtracao;
		Double valor1, valor2, valor3;
		String texto, textoMinusculo, textoMaiusculo;
		
		//Exercicio 1 Inteiros
		
		System.out.print("Digite um numero: ");
		numeroUm = sc.nextInt();
		System.out.print("Digite outro numero: ");
		numeroDois = sc.nextInt();
				
		soma = numeroUm + numeroDois;
		subtracao = numeroUm - numeroDois;
		
		System.out.println("Soma de " + numeroUm + " + " + numeroDois +  " = " + soma);
		System.out.println("Subtracao de " + numeroUm + " - " + numeroDois +  " = " + subtracao);
		
		//------------------------------------------------------------------------------
		
		//Exercicio 2 Texto
		
		System.out.println();
		System.out.print("Digite uma frase: ");
		sc.nextLine();
		texto = sc.nextLine();
		System.out.println("LETRAS MAIUSCULAS: " + texto.toLowerCase());
		System.out.println("LETRAS MINUSCULAS: " + texto.toUpperCase());
		
		//------------------------------------------------------------------------------
		
		//Exercicio 3 Double
		
		System.out.println();
		System.out.print("Digite tres numeros: ");
		valor1 = sc.nextDouble();
		valor2 = sc.nextDouble();
		valor3 = sc.nextDouble();
		
		//Verifica o maior entre dois numeros
		
		System.out.println();
		if(valor1 > valor2) {
			System.out.println("Maior: " + valor1);
		}
		else {
			System.out.println("Maior: " + valor2);
		}
		
		//Verifica o menor entre tres numeros
		
		if(valor1 < valor2 && valor1 < valor3) {
			System.out.println("Menor: " + valor1);
		}
		else if (valor2 < valor3) {
			System.out.println("Menor: " + valor2);
		}
		else {
			System.out.println("Menor: " + valor3);
		}
		
		sc.close();
	}

}
