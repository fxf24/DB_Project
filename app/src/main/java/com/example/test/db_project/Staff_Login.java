package com.example.test.db_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Staff_Login extends AppCompatActivity {
    EditText id, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        id = findViewById(R.id.id);
        pw = findViewById(R.id.pw);
    }

    public void login(View v){
//        Send_DB send_db = new Send_DB(getApplicationContext());
//        send_db.execute("http://192.168.0.18/Login.php", id.getText().toString(), pw.getText().toString());
        Intent intent_01 = new Intent(Staff_Login.this, Staff_Start.class);
        startActivity(intent_01);
    }
}
