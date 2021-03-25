package com.example.bestappever2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GlobalTask extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_task);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        TaskAdapter taskAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(taskAdapter);

    }

    private void initData() {


        taskList = new ArrayList<>();
        taskList.add(new Task("Test 1","123112313","01-12-2000", Color.parseColor("#FFFF9800")));
        taskList.add(new Task("Test 11","31312323","01-12-2000", Color.parseColor("#FF03DAC5")));
        taskList.add(new Task("Test 12","12332323","01-12-2000", Color.parseColor("#F1345600")));
    }

    public void addNote(View view) {

        startActivity(new Intent(this,
                AddNote.class));

    }
}