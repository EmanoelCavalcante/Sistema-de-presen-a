package com.challengeEnglishCourse.br.repository;

import java.util.List;

import android.content.Context;

import com.challengeEnglishCourse.br.database.DAO.AlunoDAO;
import com.challengeEnglishCourse.br.model.Aluno;

public class AlunoRepository {
    private AlunoDAO alunoDAO;

    public AlunoRepository(Context context){
        alunoDAO = new AlunoDAO(context);
    }

    public long registrarAluno(Aluno aluno){
      return alunoDAO.inserirAlunos(aluno);
    }
    public List<Aluno> listarAlunos(){
       return alunoDAO.listarAlunos();
    }
    
    public List<Aluno> buscarAlunoPeloNome(String nome){
      return alunoDAO.buscarAlunoPeloNome(nome);
    }
    public int atualizarAluno(Aluno aluno){
        return alunoDAO.atualizarAluno(aluno);
    }
    public int deletarAluno(int id){
        return alunoDAO.deletarAluno(id);
    }
}
