package com.db1.db1start.aula07;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//Exercicio 01 Soma/Subtracao
		
		System.out.print("Digite dois numeros inteiros: ");
		int numeroUm = sc.nextInt();
		int numeroDois = sc.nextInt();
		
		System.out.println("Soma: " + soma(numeroUm, numeroDois));
		System.out.println("Subtracao: " + subtracao(numeroUm, numeroDois));
				
		//--------------------------------------------------------------------------
		
		//Exercicio 02 String
		
		System.out.println();
		System.out.print("Digite uma frase: ");
		sc.nextLine();
		String frase = sc.nextLine();
		frase.toLowerCase();
		
		System.out.println("Maiusculo: " + maiusculo(frase));
		System.out.println("Minusculo: " + minusculo(frase));
		
		//----------------------------------------------------------------------------
		
		//Exercicio 03 menor entre dois numeros
		
		System.out.println();
		System.out.print("Digite dois numeros inteiros: ");
		int valor1 = sc.nextInt();
		int valor2 = sc.nextInt();
		
		System.out.println("Menor: " + menor(valor1, valor2));
		
		//Exercicio 03 menor entre tres numeros
		
		System.out.println();
		System.out.print("Digite tres numeros inteiros: ");
		valor1 = sc.nextInt();
		valor2 = sc.nextInt();		
		int valor3 = sc.nextInt();
		
		System.out.println("Menor: " + menor(menor(valor1, valor2), valor3));
		
		sc.close();		
	}
	
	public static int soma(int numeroUm, int numeroDois) {
		return numeroUm + numeroDois;
	}
	
	public static int subtracao(int numeroUm, int numeroDois) {
		return numeroUm - numeroDois;
	}
		
	public static String maiusculo(String texto)  {
		return texto.toUpperCase();
	}
	
	public static String minusculo(String texto)  {
		return texto.toLowerCase();
	}
	
	public static int menor(int numero1, int numero2) {
		return (numero1 < numero2) ? numero1 : numero2;
	}	
	
}
