import java.io.*;

public class TesteSerilizacao {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String nome = "Guilherme Sousa";
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
//        oos.writeObject(nome);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
        String oisreturn = (String) ois.readObject();
        System.out.println(oisreturn);

        ois.close();
//        oos.close();
    }
}
