package atv2;

import java.util.*;

public class Exercicio {

    public static void main(String[] args) {

        Map<Integer, String> pessoas = new HashMap<>();

        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");

            Set<Integer> set = pessoas.keySet();
            set.forEach(key -> {
                System.out.println(pessoas.get(key));
            });


        pessoas.forEach((key, value) -> {
            System.out.println("nome: " + value + " idade: " + key);
        });

    }
}