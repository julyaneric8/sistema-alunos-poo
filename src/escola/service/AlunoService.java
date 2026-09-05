package escola.service;

import escola.model.Aluno;
import escola.repository.AlunoRepository;

public class AlunoService {
    private AlunoRepository repository;

    public AlunoService() {
        this.repository = new AlunoRepository();
    }

    public void cadastrarAluno(Aluno aluno) {
        if (aluno == null) {
            System.out.println("Erro: Aluno não pode ser nulo!");
            return;
        }
        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            System.out.println("Erro: Nome do aluno não pode ser vazio!");
            return;
        }
        if (aluno.getCpf() == null || aluno.getCpf().trim().isEmpty()) {
            System.out.println("Erro: CPF do aluno não pode ser vazio!");
            return;
        }
        if (aluno.getMatricula() == null || aluno.getMatricula().trim().isEmpty()) {
            System.out.println("Erro: Matrícula do aluno não pode ser vazia!");
            return;
        }
        if (repository.buscarPorMatricula(aluno.getMatricula()) != null) {
            System.out.println("Erro: Já existe um aluno com a matrícula " + aluno.getMatricula());
            return;
        }
        if (aluno.getIdade() < 0) {
            System.out.println("Erro: Idade não pode ser negativa!");
            return;
        }
        if (aluno.getNota1() < 0 || aluno.getNota1() > 10 ||
                aluno.getNota2() < 0 || aluno.getNota2() > 10 ||
                aluno.getNota3() < 0 || aluno.getNota3() > 10) {
            System.out.println("Erro: As notas devem estar entre 0 e 10!");
            return;
        }

        repository.salvar(aluno);
    }

    public java.util.ArrayList<Aluno> listarAlunos() {
        return repository.listarTodos();
    }

    public double calcularMedia(String matricula) {
        Aluno aluno = repository.buscarPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Erro: Aluno com matrícula " + matricula + " não encontrado!");
            return -1;
        }
        return aluno.calcularMedia();
    }

    public String verificarSituacao(String matricula) {
        Aluno aluno = repository.buscarPorMatricula(matricula);
        if (aluno == null) {
            return "Aluno não encontrado!";
        }
        return aluno.isAprovado() ? "APROVADO" : "REPROVADO";
    }

    public void exibirInfoAluno(String matricula) {
        Aluno aluno = repository.buscarPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Erro: Aluno com matrícula " + matricula + " não encontrado!");
            return;
        }
        aluno.exibirInfo();
    }
}