package com.db1.db1start.aula09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AulaSet {

	public static void main(String[] args) {
        Set<String> personagens = new HashSet<>();
        personagens.add("Raito");
        personagens.add("Kira");
        personagens.add("L");
        personagens.add("Riuky");
        personagens.add("Kira");
        personagens.add("L");
        System.out.println(personagens);

        personagens.remove("L");
        System.out.println(personagens);

        personagens.forEach(System.out::println);

        Optional<String> maybeKira = personagens.stream()
                .filter(s -> s.equals("Kira"))
                .findFirst();
        if (maybeKira.isPresent()) {
            System.out.println(maybeKira.get());
        }

        maybeKira.ifPresent(kira -> System.out.println(kira));

        ArrayList<String> ordenados = new ArrayList<>(personagens);
        Collections.sort(ordenados);
        System.out.println(ordenados);

        //Crie um set com uma lista de nomes com 5 nomes
        // sendo adicionados mais de uma vez

        //Remova os nomes "Suzete" OU começados com "F" ou
        // terminados em "naldo"

        //Encontre no set "Suzana" (ou não...), Se existir exiba
        // com todas letras maiúsculas

        //Em um set com números inteiros encontre o menor, o maior,
        // a soma e a média
        HashSet<Integer> numeros = new HashSet<>(
                Arrays.asList(1, 2, 3, 4));

        //Problema paradoxal
//        Integer min = Integer.MAX_VALUE;
//        final Integer max = Integer.MIN_VALUE;
//        Integer soma = 0;
//        numeros.forEach(n -> {
//            min = n < min ? n : min;
//            max = n > max ? n : max;
//            soma += n;
//        });
//        Integer min = Integer.MAX_VALUE;
//        Integer max = Integer.MIN_VALUE;
//        Integer soma = 0;
//        for (Integer n : numeros) {
//            min = n < min ? n : min;
//            max = n > max ? n : max;
//            soma += n;
//        }
//    }
//        Integer[] min = {Integer.MAX_VALUE};
//        Integer[] max = {Integer.MIN_VALUE};
//        Integer[] soma = {0};
//        numeros.forEach(n -> {
//            min[0] = n < min[0] ? n : min[0];
//            max[0] = n > max[0] ? n : max[0];
//            soma[0] += n;
//        });
    }
}
	