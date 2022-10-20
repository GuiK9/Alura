package br.com.bytebank.banco.teste.io;

import br.com.bytebank.banco.modelo.*;
import java.io.*;

public class TesteSerializacao {
    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente();
        cliente.setNome("Guilherme");
        cliente.setProfissao("Dev");
        cliente.setCpf("21293799");

        ContaCorrente cc = new ContaCorrente(11, 22);
        cc.setTitular(cliente);
        cc.deposita(233.54);

        String nome = "Guilherme Sousa";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cc.bin"));
        oos.writeObject(cc);
        oos.close();
    }
}
