package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test.db_project.Custom_Dataset.Custom_Adapter2;
import com.example.test.db_project.Custom_Dataset.Data2;

import java.util.ArrayList;

public class Customer_Reservation extends AppCompatActivity {
    Button b1;
    String check_in;
    String check_out;
    ArrayList<Data2> data2;
    EditText e1, e2;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reservation);

        b1 = findViewById(R.id.cust_reserv_confirm);

        Custom_Adapter2 adapter2;
        data2 = new ArrayList<>();


        e1=findViewById(R.id.checkin);
        e2=findViewById(R.id.checkout);

        data2.add(new Data2(null,null,null,e1.toString(),e2.toString()));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_in = e1.getText().toString();
                check_out = e2.getText().toString();
                Intent intent = new Intent(Customer_Reservation.this, Customer_Reservation_Room.class);
                intent.putExtra("check_in", check_in);
                intent.putExtra("check_out", check_out);
                startActivity(intent);
            }
        });
    }
}
