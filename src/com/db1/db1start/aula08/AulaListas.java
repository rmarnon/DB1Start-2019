package com.db1.db1start.aula08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AulaListas {

	public static void main(String[] args) {

		List<String> frutas = new ArrayList<>();
		
		frutas.add("banana");
		frutas.add(0, "morango");
		frutas.addAll(Arrays.asList("maca", "melancia", "abacaxi", "banana", "caju"));
		
		System.out.println(frutas.indexOf("melancia"));
		System.out.println(frutas.lastIndexOf("melancia"));
		System.out.println(frutas.size());
		System.out.println(frutas.contains("jaca"));
		System.out.println(frutas.containsAll(frutas));
		
		frutas.remove("banana");
		frutas.remove(4);
		frutas.removeIf(x -> x.startsWith("a"));
		frutas.removeAll(Arrays.asList("caju", "maca"));
		
		for(int i = 0; i < frutas.size(); i++) {
			System.out.println(frutas.get(i));
		}		
		
		System.out.println();
		for(String f : frutas) {
			System.out.println(f);
		}
		
		frutas.forEach(x -> System.out.println());
		frutas.forEach(System.out::println);
				
		System.out.println(frutas);		
	}

}