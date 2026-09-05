package escola.view;

import escola.model.Aluno;
import escola.service.AlunoService;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private AlunoService service;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.service = new AlunoService();
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA ESCOLAR ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Calcular Média");
            System.out.println("4. Verificar Situação");
            System.out.println("5. Exibir Dados do Aluno");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    calcularMedia();
                    break;
                case 4:
                    verificarSituacao();
                    break;
                case 5:
                    exibirInfoAluno();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void cadastrarAluno() {
        System.out.println("\n=== CADASTRO DE ALUNO ===");

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        System.out.print("Nota 1: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Nota 2: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Nota 3: ");
        double nota3 = scanner.nextDouble();
        scanner.nextLine();

        Aluno aluno = new Aluno(cpf, idade, nome, matricula, curso, nota1, nota2, nota3);
        service.cadastrarAluno(aluno);
    }

    public void listarAlunos() {
        System.out.println("\n=== LISTA DE ALUNOS ===");
        java.util.ArrayList<Aluno> alunos = service.listarAlunos();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }

        for (Aluno aluno : alunos) {
            aluno.exibirInfo();
        }
    }

    public void calcularMedia() {
        System.out.println("\n=== CALCULAR MÉDIA ===");
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        double media = service.calcularMedia(matricula);
        if (media >= 0) {
            System.out.println("Média do aluno: " + String.format("%.2f", media));
        }
    }

    public void verificarSituacao() {
        System.out.println("\n=== VERIFICAR SITUAÇÃO ===");
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        String situacao = service.verificarSituacao(matricula);
        System.out.println("Situação: " + situacao);
    }

    public void exibirInfoAluno() {
        System.out.println("\n=== EXIBIR DADOS DO ALUNO ===");
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        service.exibirInfoAluno(matricula);
    }
}