import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteEficiencianCopies {
    public static void main(String[] args) {
        long iniListamil = System.currentTimeMillis();
        List<Object> listamil = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            listamil.add(null);
        }
        long fimListamil = System.currentTimeMillis();

        System.out.println("for Demorou: " + (fimListamil - iniListamil));


        long iniNCopies = System.currentTimeMillis();
        List<Object> list = new ArrayList<Object>(Collections.nCopies(1000000, null));
        long fimNCopies = System.currentTimeMillis();
        System.out.println("nCopies Demorou: " + (fimNCopies - iniNCopies));


    }
}
