package com.challengeEnglishCourse.br.service;

import com.challengeEnglishCourse.br.database.dao.AlunoDAO;
import com.challengeEnglishCourse.br.model.Aluno;
import java.util.List;
import java.util.ArrayList;


public class AlunoService{
  private AlunoDAO alunoDAO;
  public AlunoService(AlunoDAO alunoDAO){
    this.alunoDAO = alunoDAO;
  }
  
  public String registrarAluno(String nome){
    nome = nome.trim();
  }
}