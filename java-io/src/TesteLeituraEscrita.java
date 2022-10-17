import java.io.*;
import java.net.Socket;

public class TesteLeituraEscrita {
    public static void main(String[] args) throws IOException{

        Socket s = new Socket(); //via rede não vai funcionar;

        InputStream fis = s.getInputStream(); //System.in; //new FileInputStream("lorem.txt");
        Reader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        String linha = br.readLine();

        OutputStream fos = s.getOutputStream(); //System.out; //new FileOutputStream("lorem2.txt");
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        while (linha != null && !linha.isEmpty()) {
            bw.write(linha);
            bw.newLine();
            bw.flush();
            linha = br.readLine();
        }

        bw.close();
        br.close();
    }
}
