package com.example.bestappever2.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 11;
    public static final String DB_NAME = "BD_note"; //название базы данных

    public static final String TABLE_NOTES = "notes"; //название таблицы

    public static final String NOTE_ID = "id_name"; //ид заметки
    public static final String TITLE_NOTE = "title"; // заголовок
    public static final String NOTE_DESCRIPTION = "description"; // описание
    public static final String NOTE_DATE = "date"; // дата чего-то
    public static final String NOTE_STATE = "state"; // состояние заметки выполнена или нет
    public static final String NOTE_TYPE = "type"; //  тип заметки daily/global

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NOTES + "(" + NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE_NOTE + " text, " + NOTE_DESCRIPTION + " text, " + NOTE_DATE + " text, " + NOTE_STATE + " integer, " + NOTE_TYPE + " text" + ")");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i < i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
            onCreate(sqLiteDatabase);
        }

    }
}
