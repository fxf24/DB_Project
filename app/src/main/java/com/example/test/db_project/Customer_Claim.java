package com.example.test.db_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class Customer_Claim extends AppCompatActivity {
    String reservID, rID, gID;
    EditText claim;
    String memo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custromer_claim);
        Intent intent = getIntent();

        reservID = intent.getStringExtra("reservID");
        claim = findViewById(R.id.memo);

    }

    public void OnClick(View v) {
        if (v.getId() == R.id.cancel) {
            this.finish();
        } else if (v.getId() == R.id.send_claim) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Customer_Claim.this);
            memo = claim.getText().toString();
            builder.setTitle("클레임")
                    .setIcon(R.drawable.alert_image)
                    .setMessage("등록하시겠습니까?")
                    .setPositiveButton("확인",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Customer_Claim.this, Customer_start.class);
                                    Send_DB send_db = new Send_DB(Customer_Claim.this, 4);
                                    send_db.execute("customer_claim1.php","sql=select roomID, guestID from reservation where reservID ="+reservID);
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
                                            rID = c.getString("roomID");
                                            gID = c.getString("guestID");
                                        }
                                    } catch (Exception e) {
                                        Log.e("test4", e.toString());
                                    }
                                    Log.e("test5", rID+gID);

                                    Send_DB send_db2 = new Send_DB(Customer_Claim.this, 4);
                                    send_db2.execute("customer_claim2.php","sql=insert into claim(roomID, guestID, memo,state) values " +
                                            "("+rID+","+gID+",'" +memo+"','no')");

                                    Toast.makeText(Customer_Claim.this,"등록되었습니다!", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }
                            })
                    .setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();

//            Intent intent = new Intent(Customer_Claim.this, Customer_start.class);
//            startActivity(intent);
        }
    }
}
