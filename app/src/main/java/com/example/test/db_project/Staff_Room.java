package com.example.test.db_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.test.db_project.Custom_Dataset.staff_room_adapter;
import com.example.test.db_project.Custom_Dataset.staff_room_data;

import java.util.ArrayList;

public class Staff_Room extends AppCompatActivity {
    ArrayList<staff_room_data> data = new ArrayList<>();
    ListView lv1;
    staff_room_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_room);

        lv1 = findViewById(R.id.room_check);
        adapter = new staff_room_adapter(Staff_Room.this, data);
        lv1.setAdapter(adapter);

        Spinner Main_spinner = findViewById(R.id.spinner_room);

        //스피너 어댑터 설정
        ArrayAdapter adapterS = ArrayAdapter.createFromResource(this,R.array.location,android.R.layout.simple_spinner_item);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Main_spinner.setAdapter(adapterS);

        Main_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                data.clear();
                adapter.notifyDataSetChanged();
                Get_DB<staff_room_data, staff_room_adapter> get_db = new Get_DB<>(4, data, adapter);
                get_db.execute("room.php","sql=select roomID, clean, amenity, availability from availability where roomID like '" +(position+2)+"%'");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Get_DB<staff_room_data, staff_room_adapter> get_db = new Get_DB<>(4, data, adapter);
//                get_db.execute("room.php","sql=select roomID, clean, amenity, availability from availability where roomID like '" +(position+2)+"%'");
            }
        });
//        select roomID, clean, amenity, availability from availability;
    }
}
