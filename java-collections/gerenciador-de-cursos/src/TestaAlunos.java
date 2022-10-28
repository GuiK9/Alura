import java.util.*;

public class TestaAlunos {
    public static void main(String[] args) {
        Set<String> alunos = new HashSet<>() {
        };

        alunos.add("Rodrigo Turini");
        alunos.add("Alberto Souza");
        alunos.add("Nico Steppat");
        alunos.add("Sérgio Lopes");
        alunos.add("Renan Saggio");
        alunos.add("Mauricio aniche");
        alunos.add("Alberto Souza");

        boolean pauloEstaMatriculado = alunos.contains("Paulo Silveira");
        System.out.println(pauloEstaMatriculado);

        alunos.remove("Sergio Lopes");

        for (String aluno: alunos
        ) {
            System.out.println(aluno);
        }

        alunos.forEach(aluno -> System.out.println(aluno));

        System.out.println(alunos);
        System.out.println(alunos.size());
    }
}
