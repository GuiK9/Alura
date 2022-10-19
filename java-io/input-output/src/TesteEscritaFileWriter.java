import java.io.*;

public class TesteEscritaFileWriter {
    public static void main(String[] args) throws IOException {
//        Fluxo de saida com Arquivo
//        OutputStream fos = new FileOutputStream("lorem2.txt");
//        Writer osw = new OutputStreamWriter(fos);
//        BufferedWriter bw = new BufferedWriter(osw);

        BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
        bw.write("Três patinhos foram passsear além das montanhas para brincar");
        bw.write(System.lineSeparator());
        bw.write(System.lineSeparator());
        bw.write("A mamãe gritou quá quá quá quá e dois patinhos voltaram de lá");

        bw.close();

    }
}