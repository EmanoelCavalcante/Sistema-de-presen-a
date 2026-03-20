package com.challengeEnglishCourse.br.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.ArrayList;

import com.challengeEnglishCourse.br.dto.ChamadaAlunoDTO;
import com.challengeEnglishCourse.br.model.Presenca;
import com.challengeEnglishCourse.br.database.DataBaseHelper;

public class PresencaDAO extends BaseDAO{
  private DataBaseHelper dbHelper;
  private SQLiteDatabase db;
  public PresencaDAO(Context context){
    super(context);
  }

    private ChamadaAlunoDTO cursorParaPresenca(Cursor cursor){
        ChamadaAlunoDTO dto = new ChamadaAlunoDTO();

        dto.setMatricula(Long.parseLong(cursor.getString(cursor.getColumnIndexOrThrow("matricula"))));
        dto.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));

        boolean presenca =
                cursor.getInt(cursor.getColumnIndexOrThrow("presenca")) == 1;
        dto.setPresenca(presenca);

        return dto;
    }

  public long inserirPresencas(Presenca presenca){
    ContentValues values = new ContentValues();
    
    values.put("aula_Id", presenca.getAulaId());
    values.put("aluno_Id", presenca.getAlunoId());
    values.put("presenca", presenca.isPresenca() ? 1 : 0);
    
   return db.insert("presenca", null, values);
  }
  
  public List<ChamadaAlunoDTO> listarPresencas(int aulaId){
    List<ChamadaAlunoDTO> chamadas = new ArrayList<>();
    
    Cursor cursor = null;
    try{
      cursor = db.rawQuery(
        "SELECT aluno.nome, aluno.matricula, presenca.presenca " +
        "FROM presenca " +
        "LEFT JOIN aluno ON presenca.aluno_Id = aluno.id " +
        "WHERE presenca.aula_Id = ? ",
         new String[]{String.valueOf(aulaId)}
        );

      if (cursor != null && cursor.moveToFirst()){
          do{
            chamadas.add(cursorParaPresenca(cursor));
          }
          while(cursor.moveToNext());
      }
    }
    finally{
      if(cursor != null){
        cursor.close();
      }
    }
    return chamadas;
  }

  public long atualizarPresenca(Presenca presenca){
      ContentValues values = new ContentValues();

      values.put("presenca", presenca.isPresenca() ? 1 : 0);

      return db.update("presenca",
              values, "aluno_Id = ? AND aula_Id = ?",
              new String[]{String.valueOf(presenca.getAlunoId()),
              String.valueOf(presenca.getAulaId())});
  }

  public int deletePresenca(int aulaId, int alunoId){

      return db.delete(
              "presenca",
              "aula_Id = ? AND aluno_Id = ?",
              new String[]{
                      String.valueOf(aulaId),
                      String.valueOf(alunoId)
              }
      );
  }
}
