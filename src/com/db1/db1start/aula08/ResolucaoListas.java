package com.db1.db1start.aula08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ResolucaoListas {

	public static void main(String[] args) {
        recebeStringRemoveSegunda("A", "B", "C");

        separar();
        imprimirCoresFavoritas();

        separar();
        imprimirCoresFavoritasOrdenadas();

        separar();
        List<String> cores = new ArrayList<>(coresFavoritas());
        removerCorFavorita(cores,
                "Azul");

        separar();
        imprimirCoresFavoritasDesc(coresFavoritas());

        separar();
        Map<String, List<Integer>> paresEImpares =
                separar(Arrays.asList(
                        1, 1, 2, 3, 5, 7, 12, 19, 31));

        paresEImpares.forEach((chave, valor) ->
                System.out.println(chave + ": " + valor));
    }

    private int a() { return 0; }
    private int a(int x) { return 0; }
    private int a(double x) { return 0; }
    private int a(double x, int y) { return 0; }

    private static void separar() {
        System.out.println("======================");
    }

    //M�todo que retorne os nomes das cores que voc� mais gosta
    private static List<String> coresFavoritas() {
        //Forma 1
//        List<String> cores = new ArrayList<>();
//        cores.add("Laranja");
//        cores.add("Vermelho");
//        cores.add("Preto");
//        cores.add("Azul");
//        return cores;

        //Forma 2
//        List<String> cores = new ArrayList<>();
//        cores.addAll(Arrays.asList("Laranja", "Vermelho",
//            "Preto", "Azul"));
//        return cores;

        //Forma 3
//        List<String> cores = new ArrayList<>(
//                Arrays.asList("Laranja", "Vermelho",
//                    "Preto", "Azul"));
//        return cores;

        //Forma 4
//        return new ArrayList<>(
//                Arrays.asList("Laranja", "Vermelho",
//                    "Preto", "Azul"));

        //Forma 5
        return Arrays.asList("Laranja", "Vermelho",
                    "Preto", "Azul");
    }

    //M�todo que dado uma lista retorne a quantidade de itens
    private static int quantidadeItems(List<?> lista) {
        return lista.size();
    }

    //M�todo que receba 3 String, adicione todos em uma lista e remova a segunda posi��o
    private static void recebeStringRemoveSegunda(
            String texto1, String texto2, String texto3) {
        ArrayList<String> strings = new ArrayList<>(
                Arrays.asList(texto1, texto2, texto3));
        strings.remove(1);
        System.out.println(strings);
    }

    //M�todo que imprima a lista de cores do primeiro m�todo
    private static void imprimirCoresFavoritas() {
        coresFavoritas().forEach(System.out::println);
//        coresFavoritas().forEach(s -> System.out.println(s));
        coresFavoritas().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    //M�todo que imprima as cores do primeiro m�todo em
    // ordem alfab�tica
    private static void imprimirCoresFavoritasOrdenadas() {
        List<String> cores = coresFavoritas();
        Collections.sort(cores);
        cores.forEach(System.out::println);
    }

    //M�todo que receba uma lista das cores que voc�
    // mais gosta e o nome de uma cor a ser removida
    private static void removerCorFavorita(
            List<String> cores,
            String corASerRemovida) {
        cores.remove(corASerRemovida);
    }

    //M�todo que receba a lista de cores que voc� gosta
    // e imprima em ordem decrescente (alfab�tica)
    private static void imprimirCoresFavoritasDesc(
            List<String> cores) {
//        Collections.sort(cores);
//        Collections.reverse(cores);
        Collections.sort(cores, Collections.reverseOrder());
        cores.forEach(System.out::println);
    }

    //M�todo que receba uma lista de n�meros
    // e retorne um mapa com listas de n�meros
    // pares e impares
    private static Map<String, List<Integer>> separar(
            List<Integer> numeros) {
        Map<String, List<Integer>> mapa = new HashMap<>();
        //Forma 1
//        mapa.put("PAR", new ArrayList<>());
//        mapa.put("IMPAR", new ArrayList<>());
//        numeros.forEach(n -> {
//            if (n % 2 == 0) {
//                mapa.get("PAR").add(n);
//            } else {
//                mapa.get("IMPAR").add(n);
//            }
//        });
        //Forma 2
//        mapa.put("PAR", new ArrayList<>());
//        mapa.put("IMPAR", new ArrayList<>());
//        numeros.forEach(n -> {
//            String chave = n % 2 == 0 ? "PAR" : "IMPAR";
//            mapa.get(chave).add(n);
//        });

        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> impares = numeros.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        mapa.put("PAR", pares);
        mapa.put("IMPAR", impares);
        return mapa;
    }
}