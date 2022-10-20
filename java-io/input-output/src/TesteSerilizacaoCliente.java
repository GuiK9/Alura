import java.io.*;

public class TesteSerilizacaoCliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Cliente cliente = new Cliente();
//        cliente.setNome("Guilherme");
//        cliente.setProfissao("Dev");
//        cliente.setCpf("21293799");

//        String nome = "Guilherme Sousa";
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
//        oos.writeObject(cliente);
//        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
        Cliente oisreturn = (Cliente) ois.readObject();
       System.out.println(oisreturn.getNomeCpfProfissao());
        ois.close();
    }
}
