import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TesteSetList {
    public static void main(String[] args) {
        long iniArr = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            arrayList.add(i);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.contains(i);
        }
        long fimArr = System.currentTimeMillis();
        System.out.println("Tempo do Array: " + (fimArr - iniArr) + " Size: " + arrayList.size());


        long iniSet = System.currentTimeMillis();
        Set<Integer> setConjunto = new HashSet<>();
        for (int i = 0; i < 50000; i++) {
            setConjunto.add(i);
        }
        for (Integer item: setConjunto
        ) {
            setConjunto.contains(item);
        }

        long fimSet = System.currentTimeMillis();
        System.out.println("Tempo do Conjunto: " + (fimSet - iniSet) + " size: " + setConjunto.size());


    }
}
