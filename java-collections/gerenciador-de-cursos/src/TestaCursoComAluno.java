public class TestaCursoComAluno {
    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções do java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

        Aluno a1 = new Aluno("Rodrigo Turine", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 56317);
        Aluno a3 = new Aluno("Mauricio Anchie", 17632);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);

        System.out.println("Todos os alunos matriculados no curso: ");
        javaColecoes.getAlunos().forEach(aluno -> System.out.println(aluno));

    }
}
