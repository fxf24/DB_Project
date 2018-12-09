package com.example.test.db_project.Custom_Dataset;

import android.view.View;

public class staff_claim_data {
    public String room;
    public String name;
    public String claim;

    public staff_claim_data(String room, String name, String claim){
        this.room = room;
        this.name = name;
        this.claim = claim;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public View.OnClickListener onClickListener;

}
