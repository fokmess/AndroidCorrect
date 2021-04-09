package com.example.bestappever2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bestappever2.DataBase.DBHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

public class AddNote extends AppCompatActivity {

    public final static String DAILY = "daily";
    public final static String GLOBAL = "global";

    CalendarView calendarView;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        calendarView = findViewById(R.id.calendarView);

        DBHelper db = new DBHelper(this);

        database = db.getWritableDatabase();


    }

    public void add(View view) {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendarView.getDate());

        String title = ((EditText) (findViewById(R.id.editTextTextPersonName))).getText().toString();
        String description = ((EditText) (findViewById(R.id.editTextTextMultiLine))).getText().toString();

        if (description.isEmpty()) {
            Toast.makeText(this, "Ошибка!\n Пустое описание.", Toast.LENGTH_SHORT).show();
            return;
        }


        if (title.isEmpty())
            title = "Заметка ";


        ContentValues newValues = new ContentValues();

        newValues.put(DBHelper.TITLE_NOTE, title);
        newValues.put(DBHelper.NOTE_DESCRIPTION, description);
        newValues.put(DBHelper.NOTE_DATE, currentDate);
        newValues.put(DBHelper.NOTE_STATE, 0);
        newValues.put(DBHelper.NOTE_TYPE, GLOBAL);

        database.insert(DBHelper.TABLE_NOTES, null,newValues);





        Toast.makeText(this, "Заметка создана успешно", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void close(View view) {
        finish();
    }
}