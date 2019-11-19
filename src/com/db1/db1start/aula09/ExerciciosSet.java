package com.db1.db1start.aula09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExerciciosSet {

	public static void main(String[] args) {
		
		//Crie um set com uma lista de nomes com 5 nomes
        // sendo adicionados mais de uma vez		
		Set<String> nomes = new HashSet<>();
		nomes.addAll(Arrays.asList("Anna", "Bob", "Maria", "Scarlet", "Suzana", "Bob", "Suzete",
				"Bob", "Felipe", "Frederico", "Bob", "Arnaldo", "Bob", "Reginaldo"));
		
		for(String n : nomes) {
			System.out.print(n + " - ");
		}
		
        //Remova os nomes "Suzete" OU começados com "F" ou
        // termenorados em "naldo"
		nomes.removeIf(x -> (x.startsWith("Suzete") 
				|| (x.charAt(0) == 'F')) 
				|| x.contains("naldo"));
		
		System.out.println();
		for(String n : nomes) {
			System.out.print(n + " - ");
		}		

        //Encontre no set "Suzana" (ou não...), Se existir exiba
        // com todas letras maiúsculas
		String nome = nomes.stream().filter(x -> x.contains("Suzana")).findFirst().orElse(null).toUpperCase();

		System.out.println();
		System.out.println(nome);
		
        //Em um set com números inteiros encontre o menor, o maior,
        // a soma e a média
		Set<Integer> numeros = new TreeSet<>();
		numeros.addAll(Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21 , 34, 55, 89));
		
		int menor = Integer.MAX_VALUE;
		int maior = Integer.MIN_VALUE;
		int soma = 0;
		
      for (Integer numero : numeros) {
          menor = numero < menor ? numero : menor;
          maior = numero > maior ? numero : maior;
          soma += numero;
      }
      
      System.out.println("Menor valor: " + menor);
      System.out.println("Maior valor: " + maior);
      System.out.println("Soma: " + soma);  
      }
}
