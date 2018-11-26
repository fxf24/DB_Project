package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Staff_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);
    }

    public void login(View v){
        Intent intent_01 = new Intent(getApplicationContext(), Staff_Start.class);
        startActivity(intent_01);
    }
}
