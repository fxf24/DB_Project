package com.example.test.db_project;

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
        Send_DB send_db = new Send_DB(Staff_Login.this, 1);
        String send_data = "u_id=" + id.getText().toString() + "&u_pw=" + pw.getText().toString();
        send_db.execute("Login.php", send_data, pw.getText().toString());
    }
}
