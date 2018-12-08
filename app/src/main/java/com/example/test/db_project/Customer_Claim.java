package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Customer_Claim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custromer_claim);
    }

    public void OnClick(View v) {
        if (v.getId() == R.id.button13) {
            Intent intent = new Intent(Customer_Claim.this, Customer_start.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button14) {
            Intent intent = new Intent(Customer_Claim.this, Customer_start.class);
            startActivity(intent);
        }
    }
}
