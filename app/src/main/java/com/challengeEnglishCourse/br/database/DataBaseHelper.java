package com.challengeEnglishCourse.br.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Chamadas.db";
    private static final int DB_VERSION = 1;

    public DataBaseHelper(Context context){
        super(context,
                DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db){
      super.onConfigure(db);
      db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE aluno(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "matricula TEXT NOT NULL UNIQUE)");

        db.execSQL("CREATE TABLE aula("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nome_aula TEXT NOT NULL,"+
            "data TEXT NOT NULL,"+
            "descricao_aula TEXT)");

        db.execSQL("CREATE TABLE presenca (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "aluno_id INTEGER NOT NULL, " +
        "aula_id INTEGER NOT NULL, " +
        "presente INTEGER NOT NULL DEFAULT 0 CHECK(presente IN (0, 1)), " +
        
        "FOREIGN KEY (aluno_id) REFERENCES aluno(id) ON DELETE CASCADE, " +
        "FOREIGN KEY (aula_id) REFERENCES aula(id) ON DELETE CASCADE, " +

         "UNIQUE(aula_id, aluno_id)" +

         ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS presenca");
        db.execSQL("DROP TABLE IF EXISTS aluno");
        db.execSQL("DROP TABLE IF EXISTS aula");
        onCreate(db);
    }
}
