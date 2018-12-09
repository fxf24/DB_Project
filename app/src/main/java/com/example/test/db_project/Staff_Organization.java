package com.example.test.db_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.test.db_project.Custom_Dataset.staff_info;
import com.example.test.db_project.Custom_Dataset.staff_info_Adapter;

import java.util.ArrayList;

public class Staff_Organization extends AppCompatActivity {
    ArrayList<staff_info> staff_infos = new ArrayList<>();
    staff_info_Adapter adapter;
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_organization);

        Spinner Main_spinner = findViewById(R.id.spinner_org);

        //스피너 어댑터 설정
        ArrayAdapter adapterS = ArrayAdapter.createFromResource(this,R.array.department,android.R.layout.simple_spinner_item);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Main_spinner.setAdapter(adapterS);

        lv1 = findViewById(R.id.staffs);
        adapter = new staff_info_Adapter(Staff_Organization.this, staff_infos);
        lv1.setAdapter(adapter);
        Main_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                staff_infos.clear();
                adapter.notifyDataSetChanged();
                Log.e("test2",String.valueOf(position));
                Get_DB<staff_info, staff_info_Adapter> get_db = new Get_DB<>(1, staff_infos, adapter);
                get_db.execute("organization.php", "sql=select name, position, phone_num from hr where deptID=" +(position+1));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}