import java.io.*;

public class TesteEscritaPrintStreamPrintWriter {
    public static void main(String[] args) throws IOException {
//        Fluxo de saida com Arquivo
//        OutputStream fos = new FileOutputStream("lorem2.txt");
//        Writer osw = new OutputStreamWriter(fos);
//        BufferedWriter bw = new BufferedWriter(osw);


//        BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
//        PrintStream ps = new PrintStream("lorem2.txt");

        long inicioDoCodigo = System.currentTimeMillis();

        PrintWriter ps = new PrintWriter("lorem2.txt");



        ps.println("Três patinhos foram passsear além das montanhas para brincar");
        ps.println();
        ps.println();
        ps.println("A mamãe gritou quá quá quá quá e dois patinhos voltaram de lá");

        ps.close();

        long fimDoCodigo = System.currentTimeMillis();

        System.out.println("Passaram: " + (fimDoCodigo - inicioDoCodigo) + " milissegundos");

    }
}