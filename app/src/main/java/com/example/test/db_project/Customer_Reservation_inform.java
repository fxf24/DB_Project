package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Customer_Reservation_inform extends AppCompatActivity {
    TextView tv1;
    TextView checkin;
    TextView checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reservation_inform);
        Intent intent = getIntent();
        tv1 = findViewById(R.id.room_type);
        checkin = findViewById(R.id.check_in);
        checkout = findViewById(R.id.check_out);

        String room_type = intent.getStringExtra("room_type");
        String tv= tv1.getText().toString() + room_type;

        String check_in = intent.getStringExtra("check_in");
        String tv2= checkin.getText().toString() + check_in;

        String check_out = intent.getStringExtra("check_out");
        String tv3= checkout.getText().toString() + check_out;

        tv1.setText(tv);
        checkin.setText(tv2);
        checkout.setText(tv3);
    }

    public void OnClick(View v){
        Intent intent = new Intent(Customer_Reservation_inform.this, Customer_start.class);
        startActivity(intent);
    }
}