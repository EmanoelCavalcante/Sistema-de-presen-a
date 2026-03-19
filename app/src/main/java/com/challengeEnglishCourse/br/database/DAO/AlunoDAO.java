package com.challengeEnglishCourse.br.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.ArrayList;
import com.challengeEnglishCourse.br.model.Aluno;
import com.challengeEnglishCourse.br.database.DataBaseHelper;


public class AlunoDAO extends BaseDAO {
    private DataBaseHelper dbHelper;
    private SQLiteDatabase db;

    public AlunoDAO(Context context){
        super(context);
    }
    private Aluno cursorParaAluno(Cursor cursor){
        Aluno aluno = new Aluno();

        aluno.setNome(
                cursor.getString(cursor.getColumnIndexOrThrow("nome")));

        aluno.setId(
                cursor.getInt(cursor.getColumnIndexOrThrow("id")
                ));

        aluno.setMatricula(
                cursor.getLong(cursor.getColumnIndexOrThrow("matricula")
                ));

        return aluno;
    }

    public long inserirAlunos(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());

        return db.insert("aluno", null, values);
    }

    public List<Aluno> listarAlunos(){
        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();

        Cursor cursor = null;

        try{
            cursor = db.rawQuery(
                    "SELECT * FROM aluno",
                    null
            );

            if(cursor != null && cursor.moveToFirst()){
                do{
                    alunos.add(cursorParaAluno(cursor));
                } while(cursor.moveToNext());
            }
        } finally {
            if(cursor != null){
                cursor.close();
            }
        }
        return alunos;
    }

    public List<Aluno> buscarAlunoPorMatricula(long matricula){
      List <Aluno> alunos = new  ArrayList<>();
      Cursor cursor = null;
      try{
        cursor = db.rawQuery(

          "SELECT * FROM aluno WHERE matricula=? ", new String[]{String.valueOf(matricula)}
        );

            if (cursor != null && cursor.moveToFirst()){
                do{

                   alunos.add(cursorParaAluno(cursor));

                } while(cursor.moveToNext());
            }
        }
        finally{
          if(cursor != null){
            cursor.close();
          }
      }
      return alunos;
    }

    public List<Aluno> buscarAlunoPeloNome(String nome){
        List <Aluno> alunos = new  ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = db.rawQuery(

                    "SELECT * FROM aluno WHERE nome=? ", new String[]{nome}
            );

            if (cursor != null && cursor.moveToFirst()){
                do{

                    alunos.add(cursorParaAluno(cursor));

                } while(cursor.moveToNext());
            }
        }
        finally{
            if(cursor != null){
                cursor.close();
            }
        }
        return alunos;
    }

    public int atualizarAluno(Aluno aluno){
        ContentValues values = new ContentValues();

        values.put("nome", aluno.getNome());
        values.put("matricula", aluno.getMatricula());

        return db.update("aluno",
                values,
                "id = ?",
                new String[]{String.valueOf(aluno.getId())});
    }

    public int deletarAluno(int id){
        return db.delete("aluno",
                "id = ?",
                new String[]{String.valueOf(id)});
    }
}
