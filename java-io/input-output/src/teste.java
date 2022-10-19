import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("contas.csv"));

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            byte[] bytes = line.getBytes(StandardCharsets.UTF_8);
            String newline = new String(bytes, StandardCharsets.US_ASCII);
            System.out.println(newline);
        }

        sc.close();
    }
}
