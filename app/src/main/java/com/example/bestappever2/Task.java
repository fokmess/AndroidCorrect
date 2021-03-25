package com.example.bestappever2;

public class Task {

    private String name, desc, date;

    public int getColorNote() {
        return colorNote;
    }

    public void setColorNote(int colorNote) {
        this.colorNote = colorNote;
    }

    private int colorNote;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private boolean expandable;

    //@Entity
    public Task(String name, String desc, String date, int colorNote) {
       // @PrimaryKey
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.colorNote = colorNote;
        this.expandable = false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }
}
