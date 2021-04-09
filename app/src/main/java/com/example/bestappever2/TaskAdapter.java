package com.example.bestappever2;

import android.content.Context;
import android.content.Intent;
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
        holder.checkBox.setText(task.getName());
        holder.dateTxt.setText(task.getDate());
        boolean isExpandable = taskList.get(position).isExpandable();
        holder.expendableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
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
        RelativeLayout expendableLayout;


        public TaskVH(@NonNull View itemView) {
            super(itemView);

            //cardView = itemView.findViewById(R.id.Card);
            dateTxt = itemView.findViewById(R.id.dateTxt);
            descTxt = itemView.findViewById(R.id.description);
            checkBox = itemView.findViewById(R.id.checktask);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expendableLayout = itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Task task = taskList.get(getAdapterPosition());
                    task.setExpandable(!task.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    Context context = v.getContext();

                    Task task = taskList.get(getAdapterPosition());
                    Intent[] intent = new Intent[]{new Intent(context, Editor.class)};
                    intent[0].putExtra("keyName",task.getName());
                    intent[0].putExtra("keyDesc",task.getDesc());
                    intent[0].putExtra("keyColor",task.getColorNote());



                    context.startActivities(intent);

                    return true;
                }
            });

        }
    }

}
