package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startactivity);

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

    public void OnClick(View v) {
        if (v.getId() == R.id.button2) {
            Intent intent = new Intent(StartActivity.this, Customer_start.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button3) {
            Intent intent = new Intent(StartActivity.this, Staff_Login.class);
            startActivity(intent);
        }
    }
}