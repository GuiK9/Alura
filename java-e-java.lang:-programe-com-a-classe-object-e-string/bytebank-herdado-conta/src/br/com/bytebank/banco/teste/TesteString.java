package br.com.bytebank.banco.teste;


public class TesteString {

    public static void main(String[] args) {

        String vazio = " ";
        String outrovazio = vazio.trim();

       System.out.println(vazio.isEmpty());
       System.out.println(outrovazio.isEmpty());

        String nome = "Alura"; //object literal
        //String nome = new String("Alura");

        System.out.println(nome.length());

        for(int i = 0; i < nome.length(); i++){
            System.out.println(nome.charAt(i));

            System.out.println();
        }

        //String sub = nome.substring(1);
        //System.out.println(sub);

        //int pos = nome.indexOf("ur");
        //System.out.println(pos);

        //char c = nome.charAt(3);
        //String outro= nome.replace('A', 'a');

        //String outro = nome.toLowerCase();

        //System.out.println(nome);
        //System.out.println(outro);
        //System.out.println(c);
    }
}