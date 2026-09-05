package escola.repository;

import escola.model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private ArrayList<Aluno> alunos;

    public AlunoRepository() {
        this.alunos = new ArrayList<>();
    }

    public void salvar(Aluno aluno) {
        if (aluno != null) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " salvo com sucesso!");
        } else {
            System.out.println("Erro: Aluno não pode ser nulo!");
        }
    }

    public ArrayList<Aluno> listarTodos() {
        return alunos;
    }

    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null; // Retorna null se não encontrar
    }

    public boolean remover(String matricula) {
        Aluno aluno = buscarPorMatricula(matricula);
        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno com matrícula " + matricula + " removido com sucesso!");
            return true;
        } else {
            System.out.println("Erro: Aluno com matrícula " + matricula + " não encontrado!");
            return false;
        }
    }

    public boolean existePorMatricula(String matricula) {
        return buscarPorMatricula(matricula) != null;
    }

    public int contarAlunos() {
        return alunos.size();
    }

    public void limparLista() {
        alunos.clear();
        System.out.println("Lista de alunos foi limpa!");
    }

    public ArrayList<Aluno> listarAprovados() {
        ArrayList<Aluno> aprovados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.isAprovado()) {
                aprovados.add(aluno);
            }
        }
        return aprovados;
    }

    public ArrayList<Aluno> listarReprovados() {
        ArrayList<Aluno> reprovados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (!aluno.isAprovado()) {
                reprovados.add(aluno);
            }
        }
        return reprovados;
    }
}