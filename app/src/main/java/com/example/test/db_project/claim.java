package com.example.test.db_project;

public class claim {
    private String claim;
    private int room_number;

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public claim(String claim, int room_number) {
        this.claim = claim;
        this.room_number = room_number;
    }
}




