package com.example.test.db_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class Reservation extends AppCompatActivity {

    ListView reservation_list;
    reserved_room_Adapter ra1;
    ArrayList<reserved_room> reserved_roomArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        reservation_list = findViewById(R.id.reservation_list);

        reserved_roomArrayList = new ArrayList<>();

        reserved_roomArrayList.add(new reserved_room(101, "2018.09.07", "홍길동"));
        reserved_roomArrayList.add(new reserved_room(102, "2018.09.07", "홍길동"));
        reserved_roomArrayList.add(new reserved_room(103, "2018.09.07", "홍길동"));

        ra1 = new reserved_room_Adapter(Reservation.this, reserved_roomArrayList);
        reservation_list.setAdapter(ra1);
    }
}
