package com.example.bestappever2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bestappever2.DataBase.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class GlobalTask extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Task> taskList;
    DBHelper db;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_task);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        db = new DBHelper(this);

        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        TaskAdapter taskAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(taskAdapter);
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                int swipeFlags =  ItemTouchHelper.END;
                return makeMovementFlags(0, swipeFlags);
            }
            @Override
            public boolean isItemViewSwipeEnabled() {
                return true;
            }
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                taskList.remove(pos);
                recyclerView.getAdapter().notifyDataSetChanged();
            }

        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void initData() {
        taskList = new ArrayList<>();

        SQLiteDatabase database = db.getWritableDatabase();

        Cursor cursor = database.query(DBHelper.TABLE_NOTES,
                null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int id_note = cursor.getColumnIndex(DBHelper.NOTE_ID);
            int id_name = cursor.getColumnIndex(DBHelper.TITLE_NOTE);
            int id_d= cursor.getColumnIndex(DBHelper.NOTE_DESCRIPTION);
            int id_check = cursor.getColumnIndex(DBHelper.NOTE_STATE);
            int id_type = cursor.getColumnIndex(DBHelper.NOTE_TYPE);
            int id_date = cursor.getColumnIndex(DBHelper.NOTE_DATE);

            do {
                 if(cursor.getString(id_type).equals(AddNote.GLOBAL))
                {
                    //Сделать генерацию цвета
                    Task note = new Task(cursor.getInt(id_note), cursor.getString(id_name),
                            cursor.getString(id_d), cursor.getString(id_date) , cursor.getInt(id_check) != 0, 1234);
                    taskList.add(note);
                }
            } while (cursor.moveToNext());

        }
    }

    public void addNote(View view) {

        startActivity(new Intent(this,
                AddNote.class));

    }
}