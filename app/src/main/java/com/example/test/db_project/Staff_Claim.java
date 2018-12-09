package com.example.test.db_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.test.db_project.Custom_Dataset.staff_claim_data;
import com.example.test.db_project.Custom_Dataset.staff_claim_adapter;

import java.util.ArrayList;


public class Staff_Claim extends AppCompatActivity implements View.OnClickListener {
    ListView lv1;
    ArrayList<staff_claim_data> data = new ArrayList<>();
    staff_claim_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_claim);

        lv1 = findViewById(R.id.claim);
        adapter = new staff_claim_adapter(Staff_Claim.this, data);
        lv1.setAdapter(adapter);

        Spinner Main_spinner = findViewById(R.id.spinner);

        //스피너 어댑터 설정
        ArrayAdapter adapterS = ArrayAdapter.createFromResource(this,R.array.location,android.R.layout.simple_spinner_item);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Main_spinner.setAdapter(adapterS);

        //스피너 이벤트 발생
        Main_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                data.clear();
                adapter.notifyDataSetChanged();
                Get_DB<staff_claim_data, staff_claim_adapter> get_db = new Get_DB<>(5, data, adapter);
                get_db.execute("claim.php","sql=select roomID, name, memo from claim natural join guest where roomID like '"+(position+2)+"%'");
//                select roomID, name, memo from claim natural join guest where roomID like '2%';
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v)
    {

    }
}
