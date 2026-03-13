package com.challengeEnglishCourse.br.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.ArrayList;
import com.challengeEnglishCourse.br.model.Aula;

import com.challengeEnglishCourse.br.database.DataBaseHelper;
public class AulaDAO {
  private DataBaseHelper dbHelper;
  private SQLiteDataBase db;
  
  public AulaDAO(Context context){
    dbHelper = new DataBaseHelper(context);
    db = dbHelper.getWritableDatabase();
  }
  
  public long inserirAula(Aula aula){
    ContentValues values = new ContentValues();
    values.put("nome_Aula", aula.getNomeAula());
    values.put("data_Aula", aula.getData());
    values.put("descricao_Aula", aula.getDescricaoAula());
    
    return db.insert("aula", null, values);
  }
  
  public List<Aulas> listarAulas(){
    List<Aulas> aulas = new ArrayList<>();
    
    try{
      Cursor cursor = db.rawQuery(
        "SELECT * FROM aula", null);
    }
    
    while(cursor.moveToNext()){
      Aula aula = new Aula();
      
      aula.setNomeAula(cursor.getString(cursor.getColumnIndexOrThrow("nome_Aula")));
      
      aula.setData(cursor.getString(cursor.getColumnIndexOtThrow("data")));
      
      aula.setDescricaoAula(cursor.getString(cursor.getColumnIndexOrThrow("descricao_Aula")));
      
      aulas.add(aula);
    }
    
    finally {
      if(cursor != null){
        cursor.close();
      }
      return aulas;
    }
  }
}
