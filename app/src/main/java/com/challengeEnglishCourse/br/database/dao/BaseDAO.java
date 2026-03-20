package com.challengeEnglishCourse.br.database.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.challengeEnglishCourse.br.database.DataBaseHelper;


public abstract class BaseDAO {
    protected SQLiteDatabase db;
    protected DataBaseHelper dbHelper;

    public BaseDAO(Context context){
        dbHelper = new DataBaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
}
