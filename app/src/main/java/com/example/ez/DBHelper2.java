package com.example.ez;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper2 extends SQLiteOpenHelper {

    public static final int DATABASE_VRSOIN = 1;
    //public static final String DATABASE_NAME = "userDB";
    public static final String TABLE_CONTACTS = "users";

    public static final String KEY_ID = "_id";
    public static final String KEY_SUBJECT = "name";
    public static final String KEY_HOMEWORK = "password";

    public DBHelper2(@Nullable Context context, @Nullable String name) {
        super(context, name, null, DATABASE_VRSOIN);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CONTACTS + "(" + KEY_ID
                + " integer primary key, " + KEY_SUBJECT + " text," + KEY_HOMEWORK + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONTACTS);

        onCreate(db);
    }
    public void del(SQLiteDatabase db)
    {

    }


}

