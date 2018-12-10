package com.example.test.db_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.db_project.Custom_Dataset.Custom_Adapter;
import com.example.test.db_project.Custom_Dataset.Data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Customer_Reservation_Room extends AppCompatActivity {
    String room_type, room_view;
    ArrayList<Data> data;
    ListView lv1;
    String name, phone, group, check_in, check_out, breakfast, parking;
    String guestID, reservID;

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
        phone = intent.getStringExtra("customer_phone");
        group = intent.getStringExtra("customer_group_num");
        breakfast = intent.getStringExtra("breakfast");
        parking = intent.getStringExtra("parking");
        check_in = intent.getStringExtra("check_in");
        check_out = intent.getStringExtra("check_out");


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                room_type = data.get(i).getRoom_type();
                room_view = data.get(i).getRoom_view();

                AlertDialog.Builder builder = new AlertDialog.Builder(Customer_Reservation_Room.this);

                builder.setTitle("예약확인")
                        .setIcon(R.drawable.alert_image)
                        .setMessage("예약하시겠습니까?")
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(Customer_Reservation_Room.this, Customer_Reservation_inform.class);
                                        Toast.makeText(Customer_Reservation_Room.this,"잠시만 기다려주세요...", Toast.LENGTH_SHORT).show();
                                        Send_DB send_db = new Send_DB(intent, 2);
                                        send_db.execute("insert_guest.php","sql=insert into guest(name, phone_num, guest_num) values('"+name+"','"+phone+"',"+group+")|" +
                                                "SELECT guestID FROM guest order by guestID desc limit 1");
                                        try{
                                            Thread.sleep(1000);
                                        }catch (Exception e){
                                            Log.e("test4", e.toString());
                                        }
                                        String test = send_db.getText();
                                        JSONArray data;
                                        try {
                                            JSONObject jsonObj = new JSONObject(test);
                                            data = jsonObj.getJSONArray("result");

                                            for (int i = 0; i < data.length(); i++) {
                                                JSONObject c = data.getJSONObject(i);
                                                String gID = c.getString("guestID");
                                                guestID = gID;
                                            }
                                        } catch (Exception e) {
                                            Log.e("test4", e.toString());
                                        }
                                        Log.e("test4",guestID);

                                        Toast.makeText(Customer_Reservation_Room.this,"잠시만 기다려주세요...", Toast.LENGTH_SHORT).show();
                                        Send_DB send_db2 = new Send_DB(intent, 2);
                                        send_db2.execute("insert_reservation.php","sql=insert into reservation(guestID, breakfast, parking, reserv_date,type,view, begin, end) " +
                                                "values("+guestID+",'"+breakfast+"','"+parking+"',now(),'"+room_type+"','"+room_view+"','"+check_in+"','"+check_out+"')|" +
                                                "SELECT reservID FROM reservation order by reservID desc limit 1");

                                        try{
                                            Thread.sleep(1000);
                                        }catch (Exception e){
                                            Log.e("test4", e.toString());
                                        }

                                        String rID = send_db2.getText();
                                        try {
                                            JSONObject jsonObj = new JSONObject(rID);
                                            data = jsonObj.getJSONArray("result");

                                            for (int i = 0; i < data.length(); i++) {
                                                JSONObject c = data.getJSONObject(i);
                                                String r_ID = c.getString("reservID");
                                                reservID = r_ID;
                                            }
                                        } catch (Exception e) {
                                            Log.e("test4", e.toString());
                                        }
                                        Log.e("test4",reservID);
                                        intent.putExtra("reservID", reservID);
                                        intent.putExtra("check_in", check_in);
                                        intent.putExtra("check_out", check_out);
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