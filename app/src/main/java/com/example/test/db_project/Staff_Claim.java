package com.example.test.db_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Staff_Claim extends AppCompatActivity {

    ListView claim_list;
    claim_Adapter ca1;
    ArrayList<claim> claimArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_claim);
        claim_list = findViewById(R.id.claim_list);

        claimArrayList = new ArrayList<>();

        claimArrayList.add(new claim("수건이 부족해요",909));
        claimArrayList.add(new claim("변기가 막혔어요",810));
        claimArrayList.add(new claim("위층 시끄러워요",710));

        ca1 = new claim_Adapter(Staff_Claim.this, claimArrayList);
        claim_list.setAdapter(ca1);
    }
}
