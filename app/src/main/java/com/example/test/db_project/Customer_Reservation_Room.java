package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.test.db_project.Custom_Dataset.Custom_Adapter;
import com.example.test.db_project.Custom_Dataset.Data;
import com.example.test.db_project.Custom_Dataset.Data2;

import java.util.ArrayList;

public class Customer_Reservation_Room extends AppCompatActivity {
    String room_type;
    ArrayList<Data> data;
    ArrayList<Data2> data2;
    ListView lv1;
    String checkin;
    String checkout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reservation_room);


        data = new ArrayList<>();

        Custom_Adapter adapter;

        lv1 = findViewById(R.id.list_view2);

        adapter = new Custom_Adapter(data, this);
        data.add(new Data(R.drawable.standardroom, "Standard Room(city)", "2~4인", "$300.0"));
        data.add(new Data(R.drawable.standardroom, "Standard Room(river)", "2~4인", "$500.0"));
        data.add(new Data(R.drawable.familyroom, "Family Room(city)", "4~6인", "$1000.0"));
        data.add(new Data(R.drawable.familyroom, "Family Room(river)", "4~6인", "$1200.0"));
        data.add(new Data(R.drawable.suiteroom, "Suite Room(city)", "2~4인", "$5000.0"));
        data.add(new Data(R.drawable.suiteroom, "Suite Room(river)", "2~4인", "$5000.0"));


        lv1.setAdapter(adapter);

        Intent intent = getIntent();

        checkin = intent.getStringExtra("check_in");
        checkout = intent.getStringExtra("check_out");


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                room_type = data.get(i).getText1();

                Intent intent = new Intent(Customer_Reservation_Room.this, Customer_Reservation_inform.class);
                intent.putExtra("room_type", room_type);
                intent.putExtra("check_in", checkin);
                intent.putExtra("check_out", checkout);
                startActivity(intent);
            }
        });
    }
}