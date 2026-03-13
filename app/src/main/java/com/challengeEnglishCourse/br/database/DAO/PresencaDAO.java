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
  private SQLiteDataBase db;
  public PresencaDao(Context context){
    dbHelper = new DataBaseHelper(context);
    db = dbHelper.getWritableDataBase();
  }
  
  public long inserirPresenca(Presenca presenca){
    ContentValues values = new ContentValues();
    
    values.put("aula_Id", presenca.getAulaId());
    values.put("aluno_Id", presenca.getAlunoId());
    values.put("presenca", presenca.isPresenca() ? 1 : 0);
    
    db.insert("presenca", null, values);
  }
}
