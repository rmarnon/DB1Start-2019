package com.db1.db1start.aula08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExercicioListas {

	public static void main(String[] args) {
		
		List<String> cores = Arrays.asList(
				"Azul", 
				"Vermelho", 
				"Preto", 
				"Branco", 
				"Verde", 
				"Amarelo",
				"Rosa",
				"Cinza",
				"Marrom",
				"Lilas",
				"Violeta",
				"Fantasia");
		List<Integer> numeros = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		System.out.println("Cores que mais gosto: " + coresFavoritas(listaDeCores(cores)));
		System.out.println("Quantidade de cores: " + quantidadeDeItens(listaDeCores(cores)));
		System.out.print("Adiciona 03 Strings e remove String da posicao 02: ");
		System.out.println(adiciona3StringsRemovePosicao2("Posicao0", "Posicao1", "Posicao2"));
		System.out.println("Lista de Cores: " + listaDeCores(cores));
		System.out.println("Ordena Lista: " + ordenaLista(listaDeCores(cores)));
		System.out.println("Remove uma Cor favorita: " + removeCorFavorita(coresFavoritas(listaDeCores(cores)), "Azul"));
		System.out.print("Imprime lista em ordem decrescente: ");
		imprimeEmOrdemDecrescente(listaDeCores(cores));
		System.out.println("Map Par/Impar: " + map(numeros));		
	}
	
	public static List<String> listaDeCores(List<String> list) {
		return list;
	}
	
	public static List<String> coresFavoritas (List<String> list) {
		listaDeCores(list);
		List<String> coresFavoritas = new ArrayList<>();
		coresFavoritas.add(list.stream().filter(x -> x.startsWith("Az")).findFirst().orElse(null));
		coresFavoritas.add(list.stream().filter(x -> x.contains("Preto")).findFirst().orElse(null));
		coresFavoritas.add(list.stream().filter(x -> x.charAt(3) == 'm').findFirst().orElse(null));
		return coresFavoritas;
	}
	
	public static int quantidadeDeItens(List<String> list) {
		return list.size();
	}
	
	public static List<String> adiciona3StringsRemovePosicao2(String string0, String string1, String string2) {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(string0, string1, string2));
		list.removeIf(x -> x.contains(string2));
		return list;
	}
	
	public static List<String> ordenaLista(List<String> list) {
		Collections.sort(list);
		return list;
	}
	
	public static List<String> removeCorFavorita(List<String> list, String cor) {
		list.removeIf(x -> x.startsWith(cor));
		return list;
	}
	
	public static void imprimeEmOrdemDecrescente(List<String> list) {
		Collections.reverse(ordenaLista(list));
		System.out.println(list);
	}
	
	public static Map<String, List<Integer>> map(List<Integer> numeros) {
		Map<String, List<Integer>> map = new HashMap<>();
		List<Integer> par = numeros.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		List<Integer> impar = numeros.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
		map.put("Par", par);
		map.put("Impar", impar);
		return map;
	}
	
}