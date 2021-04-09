package com.example.bestappever2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;

public class Editor extends AppCompatActivity {

    EditText name;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);



        Bundle arguments = getIntent().getExtras();

        int keyColor = arguments.getInt("keyColor");
        String keyName  = arguments.get("keyName").toString();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable((keyColor)));
        actionBar.setTitle(keyName);
        name = findViewById(R.id.name);

        name.setText(keyName);
    }
}