package escola.model;

public class Aluno extends Pessoa{
    private String matricula;
    private String curso;
    private double nota1;
    private double nota2;
    private double nota3;

    public Aluno(String cpf, int idade, String nome, String matricula, String curso, double nota1, double nota2, double nota3) {
        super(cpf, idade, nome);
        this.matricula = matricula;
        this.curso = curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double calcularMedia(){
        return (this.nota1 + this.nota2 + this.nota3) / 3;
    }

    public boolean isAprovado(){
        return calcularMedia() >= 6;
    }

    @Override
    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Matricula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
        System.out.println("Média: " + String.format("%.2f", calcularMedia()));
        System.out.println("Situação: " + (isAprovado() ? "APROVADO" : "REPROVADO"));
    }
}