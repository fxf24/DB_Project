package com.example.test.db_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.test.db_project.Custom_Dataset.Custom_Adapter;
import com.example.test.db_project.Custom_Dataset.Data;

import java.util.ArrayList;

public class Customer_Reservation_Room extends AppCompatActivity {
    String room_type, room_view;
    ArrayList<Data> data;
    ListView lv1;
    String name, phone, group, check_in, check_out, breakfast, parking;

//intent.putExtra("customer_name", name.getText().toString());
//        intent.putExtra("customer_phone", phone.getText().toString());
//        intent.putExtra("customer_group_num", group_num.getText().toString());
//        intent.putExtra("check_in", check_in.getText().toString());
//        intent.putExtra("check_out", check_out.getText().toString());
//        intent.putExtra("breakfast", bf);
//        intent.putExtra("parking", pk);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reservation_room);


        data = new ArrayList<>();

        Custom_Adapter adapter;

        lv1 = findViewById(R.id.list_view2);

        adapter = new Custom_Adapter(data, this);
        data.add(new Data(R.drawable.standardroom, "Standard Room(city)", "2~4인", "$300.0","standard", "city"));
        data.add(new Data(R.drawable.standardroom, "Standard Room(river)", "2~4인", "$500.0","standard", "river"));
        data.add(new Data(R.drawable.familyroom, "Family Room(city)", "4~6인", "$1000.0","family", "city"));
        data.add(new Data(R.drawable.familyroom, "Family Room(river)", "4~6인", "$1200.0","family", "river"));
        data.add(new Data(R.drawable.suiteroom, "Suite Room(city)", "2~4인", "$5000.0","suite", "city"));
        data.add(new Data(R.drawable.suiteroom, "Suite Room(river)", "2~4인", "$5000.0","suite", "river"));


        lv1.setAdapter(adapter);

        Intent intent = getIntent();

        name = intent.getStringExtra("customer_name");
        phone = intent.getStringExtra("customer_phone_num");
        group = intent.getStringExtra("customer_group_num");
        breakfast = intent.getStringExtra("breakfast");
        parking = intent.getStringExtra("parking");
        check_in = intent.getStringExtra("check_in");
        check_out = intent.getStringExtra("check_out");


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                room_type = data.get(i).getText1();
                room_view = data.get(i).getRoom_view();

                AlertDialog.Builder builder = new AlertDialog.Builder(Customer_Reservation_Room.this);

                builder.setTitle("예약확인")
                        .setIcon(R.drawable.alert_image)
                        .setMessage("예약하시겠습니까?")
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(Customer_Reservation_Room.this, Customer_Reservation_inform.class);
                                        intent.putExtra("customer_name", name);
                                        intent.putExtra("customer_phone", phone);
                                        intent.putExtra("customer_group_num", group);
                                        intent.putExtra("check_in", check_in);
                                        intent.putExtra("check_out", check_out);
                                        intent.putExtra("breakfast", breakfast);
                                        intent.putExtra("parking", parking);
                                        intent.putExtra("room_type", room_type);
                                        intent.putExtra("room_view", room_view);
                                        startActivity(intent);
                                    }
                                })
                        .setNegativeButton("닫기",null)
                        .show();




            }
        });
    }
}