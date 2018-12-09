package com.example.test.db_project;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Customer_Reservation extends AppCompatActivity {
    Button confirm;
    TextView check_in, check_out;
    EditText name, phone, group_num;
    RadioGroup breakfast, parking;
    String bf, pk;

    void real()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("예약하시겠습니까")
                .setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"예를 선택했습니다.",Toast.LENGTH_LONG).show();

                    }
                })
                .setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"아니오를 선택했습니다.",Toast.LENGTH_LONG).show();
                    }
                }).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reservation);

        confirm = findViewById(R.id.cust_reserv_confirm);

        name = findViewById(R.id.customer_name);
        phone = findViewById(R.id.customer_phone);
        group_num = findViewById(R.id.customer_group_num);

        check_in=findViewById(R.id.checkin);
        check_out=findViewById(R.id.checkout);

        breakfast = findViewById(R.id.breakfast);
        parking = findViewById(R.id.parking);

        breakfast.check(R.id.breakfast_no);
        parking.check(R.id.parking_no);
        bf = "No";
        pk = "No";

        breakfast.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                bf = rb.getText().toString();
            }
        });

        parking.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                pk = rb.getText().toString();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("") || phone.getText().toString().equals("")|| group_num.getText().toString().equals("")
                        || check_in.getText().toString().equals("")|| check_out.getText().toString().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Customer_Reservation.this);

                    builder.setTitle("빈칸알림")
                            .setIcon(R.drawable.alert_image)
                            .setMessage("빈칸이 있습니다")
                            .setPositiveButton("닫기", null).show();
                }
                else{
                    Intent intent = new Intent(Customer_Reservation.this, Customer_Reservation_Room.class);
                    intent.putExtra("customer_name", name.getText().toString());
                    intent.putExtra("customer_phone", phone.getText().toString());
                    intent.putExtra("customer_group_num", group_num.getText().toString());
                    intent.putExtra("check_in", check_in.getText().toString());
                    intent.putExtra("check_out", check_out.getText().toString());
                    intent.putExtra("breakfast", bf);
                    intent.putExtra("parking", pk);
//                    Toast.makeText(Customer_Reservation.this,bf+pk,Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        showDatePickerDialog(check_in);
        showDatePickerDialog(check_out);
    }

    private void showDatePickerDialog(final TextView textView)
    {
        // Get open DatePickerDialog button.
        textView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                // Create a new OnDateSetListener instance. This listener will be invoked when user click ok button in DatePickerDialog.
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuffer strBuf = new StringBuffer();
                        strBuf.append(year);
                        strBuf.append("-");
                        strBuf.append(month+1);
                        strBuf.append("-");
                        strBuf.append(dayOfMonth);

                        textView.setText(strBuf.toString());
                    }
                };

                // Get current year, month and day.
                Calendar now = Calendar.getInstance();
                int year = now.get(java.util.Calendar.YEAR);
                int month = now.get(java.util.Calendar.MONTH);
                int day = now.get(java.util.Calendar.DAY_OF_MONTH);

                // Create the new DatePickerDialog instance.
                DatePickerDialog datePickerDialog = new DatePickerDialog(Customer_Reservation.this, onDateSetListener, year, month, day);

                // Set dialog icon and title.
//                datePickerDialog.setIcon(R.drawable.if_snowman);
                datePickerDialog.setTitle("Please select date.");

                // Popup the dialog.
                datePickerDialog.show();
            }
        });
    }
}
