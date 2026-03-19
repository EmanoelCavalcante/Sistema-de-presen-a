package com.challengeEnglishCourse.br.dto;

public class ChamadaAlunoDTO{
  private long matricula;
  private boolean presenca;
  private String nome;

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public boolean getPresenca(){
    return presenca;
  }
  
  public void setPresenca(boolean presenca){
    this.presenca = presenca;
  }
  
  public String getNome(){
    return nome;
  }
  
  public void setNome(String nome){
    this.nome = nome;
  }
}