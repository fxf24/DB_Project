package com.example.test.db_project.Custom_Dataset;

public class Data{
    int src;
    String text1;
    String text2;
    String text3;
    String room_type, room_view;
    public Data(int src, String text1, String text2,String text3, String type, String view){
        this.src =src;
        this.text1=text1;
        this.text2=text2;
        this.text3=text3;
        this.room_type = type;
        this.room_view = view;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text2 = text3;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setType(String type) {
        this.room_type = type;
    }

    public String getRoom_view() {
        return room_view;
    }

    public void setView(String view) {
        this.room_view = view;
    }
}

