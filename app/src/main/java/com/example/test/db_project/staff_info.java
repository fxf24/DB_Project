package com.example.test.db_project;

public class staff_info {
    String name;
    String position;
    String address;
    String phone;

    public staff_info(String name, String position, String address, String phone){
        this.name = name;
        this.position = position;
        this.address = address;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}