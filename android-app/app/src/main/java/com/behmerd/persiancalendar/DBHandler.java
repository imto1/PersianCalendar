package com.behmerd.persiancalendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DataBase Handler
 */

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context context){
        super(context,"PerCalDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
