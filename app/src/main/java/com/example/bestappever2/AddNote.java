package com.example.bestappever2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

public class AddNote extends AppCompatActivity {

    CalendarView calendarView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        calendarView = findViewById(R.id.calendarView);

        editText = findViewById(R.id.editTextTextPersonName);

        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendarView.getDate());
        //editText.setText(currentDate);

       // taskList.add(new Task("Test 13","12311231312312331312323123112313123112313123123313123231231233131232312311231312312331312323","11-11-1111"));
      // taskList.add(new Task("Test 13","12311231312312331312323123112313123112313123123313123231231233131232312311231312312331312323","11-11-1111"));
       // taskList.add(new Task("Test 13","12311231312312331312323123112313123112313123123313123231231233131232312311231312312331312323","11-11-1111"));

    }
}