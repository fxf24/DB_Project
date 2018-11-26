package com.example.test.db_project;

public class reserved_room {
    private int room;
    private String date;
    private String staff_name;

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public reserved_room(int room, String date, String staff_name) {
        this.room = room;
        this.date = date;
        this.staff_name = staff_name;
    }
}



