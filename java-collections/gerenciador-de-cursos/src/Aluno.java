import java.util.Objects;

public class Aluno {
    private String nome;
    private int numeroMatricula;

    public Aluno(String nome, int numeroMatricula) {
        if(nome == null) {
            throw new NullPointerException();
        }
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    @Override
    public String toString() {
        return "[Aluno: " + this.nome + ", matricula: " + this.numeroMatricula + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return numeroMatricula == aluno.numeroMatricula && Objects.equals(nome, aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numeroMatricula);
    }


    //    @Override
//    public boolean equals(Object nomeOutro) {
//        return nomeOutro.equals(this.nome);
//    }
//
//    @Override
//    public int hashCode() {
//        return this.nome.hashCode();
//    }
}
