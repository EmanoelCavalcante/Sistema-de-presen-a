package com.challengeEnglishCourse.br.DTO

public class ChamadaAluno{
  private int alunoId;
  private boolean presenca;
  private String nome;
  
  public int getAlunoId(){
    return alunoId;
  }
  
  public void setAlunoId(int alunoId){
    this alunoId = alunoId;
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