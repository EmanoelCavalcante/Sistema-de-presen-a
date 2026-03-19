package com.challengeEnglishCourse.br.repository;

import java.util.List;

import android.content.Context;

import com.challengeEnglishCourse.br.database.DAO.PresencaDAO;
import com.challengeEnglishCourse.br.model.Presenca;
import com.challengeEnglishCourse.br.dto.ChamadaAlunoDTO;

public class PresencaRepository {
  private PresencaDAO presencaDAO;
  
  public PresencaRepository(Context context){
    presencaDAO = new PresencaDAO(context);
  }
  
  public long inserirPresencas(Presenca presenca){
    return presencaDAO.inserirPresencas(presenca);
  }
  
  public List<ChamadaAlunoDTO> listarPresencas(int aulaId){
    return presencaDAO.listarPresencas(aulaId);
  }
  
  public long atualizarPresenca(Presenca presenca){
    return presencaDAO.atualizarPresenca(presenca);
  }
  
  public long deletePresenca(int aulaId, int alunoId){
    return presencaDAO.deletePresenca(aulaId, alunoId);
  }
}
