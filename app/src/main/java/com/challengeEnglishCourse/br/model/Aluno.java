package com.challengeEnglishCourse.br.model;

public class Aluno {
    private long id;
    private String nome;
    private long matricula;

    public long getId()
    {return id;}

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return String.valueOf(2026000 + this.id);
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
}
