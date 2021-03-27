package com.example.bestappever2;

public class Task {

    private  int id;
    boolean state;
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


    public Task(int id,String name, String desc, String date, boolean state, int colorNote) {
       // @PrimaryKey
        this.id  = id;
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.state = state;
        this.colorNote = colorNote;
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


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
