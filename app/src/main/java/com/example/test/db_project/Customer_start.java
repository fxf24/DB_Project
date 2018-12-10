package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Customer_start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_start);
    }

    public void OnClick(View v){
        if(v.getId() == R.id.reservation){
            Intent intent = new Intent(Customer_start.this, Customer_Reservation.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.reservation_check){
            Intent intent = new Intent(Customer_start.this, Customer_Reservation_Check.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.claim){
            Intent intent = new Intent(Customer_start.this, Customer_Claim.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.main){
            Intent intent = new Intent(Customer_start.this, StartActivity.class);
            startActivity(intent);
        }
    }
}
