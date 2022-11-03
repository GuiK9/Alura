package subAtv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Stream.builder;

public class teste {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Guilherme sousa Ribeiro");
        nomes.add("Ricardo Pereira Da Silva");
        nomes.add("Ana Liz Cardoso Costa");
        nomes.add("Fernanda De Carlos Melo");
        nomes.add("Thiago madeiro Da Silva");
        nomes.add("Mariana Von Mises Neto");

        String t1 = "Manolo Reis e Jordão";

        Stream.Builder sl = builder().add(nomes);

        System.out.println(sl.getClass());
        System.out.println(t1.getClass());

    }
}
