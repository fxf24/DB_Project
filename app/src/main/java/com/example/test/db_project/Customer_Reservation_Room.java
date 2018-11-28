package com.example.test.db_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Customer_Reservation_Room extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reservation_room);

        ListView lv1;
        ArrayList<Data> data = new ArrayList<>();
        Custom_Adapter adapter;

        lv1 = findViewById(R.id.list_view2);
        adapter = new Custom_Adapter(data, this);
        data.add(new Data(R.mipmap.ic_launcher, "룸타입", "수용인원", "가격"));
        data.add(new Data(R.mipmap.ic_launcher, "룸타입", "수용인원", "가격"));
        data.add(new Data(R.mipmap.ic_launcher, "룸타입", "수용인원", "가격"));
        data.add(new Data(R.mipmap.ic_launcher, "룸타입", "수용인원", "가격"));
        data.add(new Data(R.mipmap.ic_launcher, "룸타입", "수용인원", "가격"));
        data.add(new Data(R.mipmap.ic_launcher, "룸타입", "수용인원", "가격"));
        data.add(new Data(R.mipmap.ic_launcher, "룸타입", "수용인원", "가격"));

        lv1.setAdapter(adapter);
    }
}
