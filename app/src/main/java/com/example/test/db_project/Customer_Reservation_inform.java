package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Customer_Reservation_inform extends AppCompatActivity {
    TextView tv1,checkin, checkout, test1;
    boolean reserv_check = false;
    Button claim;
    String reservID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reservation_inform);
        Intent intent = getIntent();
        tv1 = findViewById(R.id.room_type);
        checkin = findViewById(R.id.check_in);
        checkout = findViewById(R.id.check_out);
        test1 = findViewById(R.id.reservation_id);
        claim = findViewById(R.id.claim);

        reservID = intent.getStringExtra("reservID");
        String test_ = test1.getText().toString() +reservID;

        String room_type = intent.getStringExtra("room_type");
        String room_view = intent.getStringExtra("room_view");
        String tv= tv1.getText().toString() + room_type +"("+room_view+")";

        String check_in = intent.getStringExtra("check_in");
        String tv2= checkin.getText().toString() + check_in;

        String check_out = intent.getStringExtra("check_out");
        String tv3= checkout.getText().toString() + check_out;

        reserv_check = intent.getBooleanExtra("reserv_check", false);
        if(reserv_check){
            claim.setVisibility(View.VISIBLE);
        }
        test1.setText(test_);
        tv1.setText(tv);
        checkin.setText(tv2);
        checkout.setText(tv3);

    }

    public void OnClick(View v){
        if(v.getId() == R.id.yes){
            Intent intent = new Intent(Customer_Reservation_inform.this, Customer_start.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.claim){
            Intent intent = new Intent(Customer_Reservation_inform.this, Customer_Claim.class);
            intent.putExtra("reservID", reservID);
            startActivity(intent);
        }
    }
}