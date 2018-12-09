package com.example.test.db_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.test.db_project.Custom_Dataset.Bill_Adapter;
import com.example.test.db_project.Custom_Dataset.Bill_data;

import java.util.ArrayList;

public class Staff_Bill extends AppCompatActivity {
    ArrayList<Bill_data> data = new ArrayList<>();
    Bill_Adapter adapter;
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_bill);

        lv1 = findViewById(R.id.bill);
        adapter = new Bill_Adapter(Staff_Bill.this, data);
        lv1.setAdapter(adapter);

        Get_DB<Bill_data, Bill_Adapter> get_db = new Get_DB<>(2,data, adapter);
        get_db.execute("bill.php", "sql=select name, date, type, item, amount, price from bill natural join hr order by date;");
    }
}
