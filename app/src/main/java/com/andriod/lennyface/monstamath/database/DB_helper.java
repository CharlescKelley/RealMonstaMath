package com.andriod.lennyface.monstamath.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DB_helper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "monsta_math_gamesave.db";
    public static final int DB_VERSION = 1;

    public DB_helper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MonstaMath_SavedData.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MonstaMath_SavedData.SQL_DELETE);
        onCreate(db);
    }
}
