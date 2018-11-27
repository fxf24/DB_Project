package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

            View dialog = View.inflate(this,R.layout.activity_customer_reservation, null);

        }
        else if(v.getId() == R.id.reservation_check){

        }
        else if(v.getId() == R.id.claim){

        }
    }
}
