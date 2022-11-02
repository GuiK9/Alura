package subAtv1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class atv {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("Alura online");
        palavras.add("Casa Do Código");
        palavras.add("caelum");

//        Consumer<String> consumidor = new EscritorDePalavras();

        palavras.forEach(s -> System.out.println(s));

//        Comparator<String> comparador = new Comparador();
//        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length));

        palavras.sort(comparing(String::length));
        palavras.sort(comparing(String::valueOf));
        palavras.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(palavras);

//        Consumer<String> impressor = s -> System.out.println(s);


    }
}

//class Comparador implements Comparator<String> {
//    @Override
//    public int compare(String o1, String o2) {
//        if (o1.length() < o2.length()) return -1;
//        if (o1.length() > o2.length()) return 1;
//        return 0;
//    }
//}

//class EscritorDePalavras implements Consumer {
//    @Override
//    public void accept(Object s) {
//        System.out.println(s);
//    }
//}
