package com.challengeEnglishCourse.br.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.ArrayList;
import com.challengeEnglishCourse.br.model.Aula;

import com.challengeEnglishCourse.br.database.DataBaseHelper;
public class AulaDAO extends BaseDAO{
  private DataBaseHelper dbHelper;
  private SQLiteDatabase db;
  
  public AulaDAO(Context context){
    super(context);
  }
    private Aula cursorParaAula(Cursor cursor){
        Aula aula = new Aula();

        aula.setNomeAula(cursor.getString(cursor.getColumnIndexOrThrow("nome_Aula")));

        aula.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));

        aula.setDescricaoAula(cursor.getString(cursor.getColumnIndexOrThrow("descricao_Aula")));

        return aula;
    }

  public long inserirAula(Aula aula){
    ContentValues values = new ContentValues();
    values.put("nome_Aula", aula.getNomeAula());
    values.put("data_Aula", aula.getData().toString());
    values.put("descricao_Aula", aula.getDescricaoAula());
    
    return db.insert("aula", null, values);
  }
  
  public List<Aula> listarAulas(){
    List<Aula> aulas = new ArrayList<>();
    Cursor cursor = null;
    
    try {
        cursor = db.rawQuery(
                "SELECT * FROM aula ", null);
        if(cursor != null && cursor.moveToFirst()){
            do{

                aulas.add(cursorParaAula(cursor));

            } while (cursor.moveToNext());
        }
    }
    
    finally {
      if(cursor != null){
        cursor.close();
      }
    }
      return aulas;
  }

  public int atualizarAula(Aula aula){
      ContentValues values = new ContentValues();

      values.put("nome_Aula", aula.getNomeAula());
      values.put("descricao_Aula", aula.getDescricaoAula());

      return db.update("aula",
              values,
              "id = ?",
              new String[]{String.valueOf(aula.getId())});
  }

  public int deletarAula(int aulaId, int alunoId){
      return db.delete("aula",
              "aula_Id = ? AND aluno_Id = ?",
              new String[]{
                      String.valueOf(aulaId),
                      String.valueOf(alunoId)
              });
  }
}
