package com.example.bestappever2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskVH> {

    List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new TaskVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskVH holder, int position) {

        Task task = taskList.get(position);
        holder.linearLayout.setBackgroundColor(task.getColorNote());
        holder.descTxt.setText(task.getDesc());
        holder.checkBox.setChecked(task.state);
        holder.checkBox.setText(task.getName());
        holder.dateTxt.setText(task.getDate());
        holder.expendableLayout.setVisibility(holder.expendableLayout.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskVH extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView descTxt, dateTxt;
        CheckBox checkBox;
        LinearLayout linearLayout;
        LinearLayout expendableLayout;


        public TaskVH(@NonNull View itemView) {
            super(itemView);

            //cardView = itemView.findViewById(R.id.Card);
            dateTxt = itemView.findViewById(R.id.dateTxt);
            descTxt = itemView.findViewById(R.id.description);
            checkBox = itemView.findViewById(R.id.checktask);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   taskList.get(getAdapterPosition()).state = !taskList.get(getAdapterPosition()).state;

                }
            });
            linearLayout = itemView.findViewById(R.id.linear_layout);
            expendableLayout = itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    expendableLayout.setVisibility(taskList.get(getAdapterPosition()).visibility ? View.VISIBLE : View.GONE);
                }
            });
            linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    Context context = v.getContext();

                    Intent intent = new Intent(context, AddNote.class);
                    intent.putExtra("task",taskList.get(getAdapterPosition()));

                    context.startActivity(intent);

                    return true;
                }
            });

        }
    }

}
