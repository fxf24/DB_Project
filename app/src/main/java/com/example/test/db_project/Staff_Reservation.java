package com.example.test.db_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.test.db_project.Custom_Dataset.reserved_room;
import com.example.test.db_project.Custom_Dataset.reserved_room_Adapter;

import java.util.ArrayList;

public class Staff_Reservation extends AppCompatActivity {
    ListView reservation_list;
    reserved_room_Adapter ra1;
    ArrayList<reserved_room> reserved_roomArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_reservation);

        reservation_list = findViewById(R.id.reservation_list);
        reserved_roomArrayList = new ArrayList<>();
        ra1 = new reserved_room_Adapter(Staff_Reservation.this, reserved_roomArrayList);
        reservation_list.setAdapter(ra1);

        Get_DB<reserved_room, reserved_room_Adapter> get_db = new Get_DB<>(7, reserved_roomArrayList, ra1);
        get_db.execute("reservation.php","sql=select ifnull(roomID, 0), ifnull(reserv_date,'null'), name from reservation natural join guest order by reserv_date");
    }
}
