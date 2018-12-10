package com.example.test.db_project;

import android.content.Intent;
import android.hardware.SensorDirectChannel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Customer_Reservation_Check extends AppCompatActivity {
    EditText reserv_ID, phone_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_reserv_check);

        reserv_ID = findViewById(R.id.reserv_id);
        phone_num = findViewById(R.id.phone_num);
    }

    public void OnClick(View v){
        Send_DB send_db = new Send_DB(Customer_Reservation_Check.this, 3);
        send_db.execute("reservation_check.php","u_rid="+reserv_ID.getText().toString(), phone_num.getText().toString(), reserv_ID.getText().toString());

//        Intent intent = new Intent(Customer_Reservation_Check.this, Customer_Reservation_inform.class);
//        startActivity(intent);
    }
}
