import java.util.ArrayList;

public class TestandoListas {
    public static void main(String[] args) {
        String aula1 = "Conhecendo mais de listas";
        String aula2 = "Modelando a classe Alura";
        String aula3 = "rabalhando com Cursos e Sets";

        ArrayList<String> aulas = new ArrayList<>();

        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        System.out.println(aulas);

        aulas.remove(0);

        System.out.println(aulas);

        for (String aula: aulas) {
            System.out.println("Aula: " + aula + ";");
        }

        String primeiraAula = aulas.get(0);

        System.out.println("A primeira aula é: " + primeiraAula);

        for (int i = 0; i < aulas.size(); i++) {
            System.out.println("aula" + (i + 1) + "°: " + aulas.get(i));

        }



    }
}
