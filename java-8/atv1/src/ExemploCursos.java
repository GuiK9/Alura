import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparingInt(Curso::getAlunos));
        //cursos.forEach(curso -> System.out.println(curso.getAlunos()));
        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 50)
                .mapToInt(Curso::getAlunos)
                .sum();
        System.out.println(sum);

//        cursos.stream().map(Curso::getNome).forEach(System.out::println);

        cursos.stream()
                .filter(c -> c.getAlunos() >= 1000)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

//       cursos = cursos.stream()
//               .filter(c -> c.getAlunos() >= 100).toList();

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        Curso::getNome,
                        Curso::getAlunos
                )).forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

//        System.out.println(mapa);

        cursos.stream().forEach(c -> System.out.println(c.getNome()));

        System.out.println(cursos.stream().mapToInt(Curso::getAlunos).average());

    }
}

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}
