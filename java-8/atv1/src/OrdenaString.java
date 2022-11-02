import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaString {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<String>();

        nomes.add("Carlos donavam");
        nomes.add("Thiago palavra cruzada");
        nomes.add("Abraão de jesus");
        nomes.add("Marcelo tião");

        Comparator<String> comparador = new ComparadorPorTamanho();
        //Collections.sort(nomes, comparador);
        nomes.sort(comparador);
        System.out.println(nomes);

        Consumer<String> consumidor = new Imprimenalinha();
        nomes.forEach(consumidor);

    }
}

class Imprimenalinha implements Consumer<String>{
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() > s2.length()){
            return -1;
        } else if (s1.length() < s2.length()){
            return 1;
        }
        return 0;
    }
}