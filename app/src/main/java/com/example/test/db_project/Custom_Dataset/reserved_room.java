package com.example.test.db_project.Custom_Dataset;

public class reserved_room {
    private String staffID;
    private String date;
    private String name;
    private String phone_num;
    private String type;
    private String view;
    private String reservID;

    public reserved_room(String staffID, String date, String name, String phone_num, String type, String view, String reservID) {
        this.staffID = staffID;
        this.date = date;
        this.name = name;
        this.phone_num = phone_num;
        this.type = type;
        this.view = view;
        this.reservID = reservID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getReservID() {
        return reservID;
    }

    public void setReservID(String reservID) {
        this.reservID = reservID;
    }
}



