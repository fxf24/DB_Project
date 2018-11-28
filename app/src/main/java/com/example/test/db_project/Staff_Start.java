package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Staff_Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_start);
    }

    public void Reservation(View v){
        Intent intent_01 = new Intent(getApplicationContext(), Staff_Reservation.class);
        startActivity(intent_01);
    }

    public void Room(View v){
        Intent intent_02 = new Intent(getApplicationContext(), Staff_Room.class);
        startActivity(intent_02);
    }



}
