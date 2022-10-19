import java.io.*;

public class TesteEscrita {
    public static void main(String[] args) throws IOException {
        //Fluxo de saida com Arquivo
        OutputStream fos = new FileOutputStream("lorem2.txt");
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("Três patinhos foram passsear além das montanhas para brincar");
        bw.newLine();
        bw.newLine();
        bw.write("A mamãe gritou quá quá quá quá e dois patinhos voltaram de lá");

        bw.close();

    }
}