# 🎓 Sistema de Alunos - POO

Sistema simples de gerenciamento de alunos para praticar Programação Orientada a Objetos.

---

## 📋 Funcionalidades

- Cadastrar aluno (nome, idade, CPF, matrícula, curso, notas)
- Listar todos os alunos
- Buscar aluno por matrícula
- Remover aluno
- Calcular média
- Verificar situação (Aprovado/Reprovado)

---

## 🛠️ Tecnologias

- Java 17
- Programação Orientada a Objetos (POO)

---

## 📁 Estrutura

```
src/com/escola/
├── Main.java
├── model/
│   ├── Pessoa.java      (abstrata)
│   └── Aluno.java       (herda de Pessoa)
├── repository/
│   └── AlunoRepository.java
├── service/
│   └── AlunoService.java
└── view/
    └── Menu.java
```

---

## 🚀 Como Executar

1. Abra o projeto no IntelliJ
2. Execute `Main.java`

---

## 📚 Conceitos POO Aplicados

| Pilar | Onde foi usado |
|-------|----------------|
| **Abstração** | `Pessoa` é classe abstrata |
| **Encapsulamento** | Atributos `private` + getters/setters |
| **Herança** | `Aluno extends Pessoa` |
| **Polimorfismo** | `exibirInfo()` sobrescrito |

---

## 👤 Autor

Julyan Eric Lopes Pinto

---
