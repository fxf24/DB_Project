package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Customer_Reservation_Check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_reserv_check);
    }

    public void OnClick(View v){
        Intent intent = new Intent(Customer_Reservation_Check.this, Customer_Reservation_inform.class);
        startActivity(intent);
    }
}
