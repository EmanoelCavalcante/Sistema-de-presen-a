package com.challengeEnglishCourse.br.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.ArrayList;
import com.challengeEnglishCourse.br.model.Presenca;
import com.challengeEnglishCourse.br.database.DataBaseHelper;

public class PresencaDAO {
  private DataBaseHelper dbHelper;
  private SQLiteDatabase db;
  public PresencaDAO(Context context){
    dbHelper = new DataBaseHelper(context);
    db = dbHelper.getWritableDatabase();
  }
  
  public long inserirPresenca(Presenca presenca){
    ContentValues values = new ContentValues();
    
    values.put("aula_Id", presenca.getAulaId());
    values.put("aluno_Id", presenca.getAlunoId());
    values.put("presenca", presenca.isPresenca() ? 1 : 0);
    
   return db.insert("presenca", null, values);
  }
  
  public List<Presenca> listarPresencas(){
    List<Presenca> presencas = new ArrayList<>();
    
    Cursor cursor = null;
    try{
      cursor = db.rawQuery("SELECT * FROM presenca", null);
    }
    while (cursor.moveToNext()){
      Presenca presenca = new Presenca();
      
      presenca.setAulaId(cursor.getInt(cursor.getColumnIndexOrThrow("aula_Id")));
      
      presenca.setAlunoId(cursor.getInt(cursor.getColumnIndexOrThrow("aluno_id")));
      
      boolean presente = cursor.getInt(cursor.getColumnIndexOrThrow("presenca")) == 1;
      
      presenca.isPresenca(presente);
      
      presencas.add(presenca);
    }
    
    finally{
      if(cursor != null){
        cursor.close();
      }
    }
    return presencas;
  }
}
