package org.cliente;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas  {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexão estabelecida");
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(socket.getOutputStream());
        saida.println(teclado.nextLine());
        teclado.nextLine();
        teclado.close();
        socket.close();
    }


}
