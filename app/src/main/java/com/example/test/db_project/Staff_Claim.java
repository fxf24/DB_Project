package com.example.test.db_project;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class Staff_Claim extends AppCompatActivity implements View.OnClickListener {
    private ListView m_oListView1 = null;
    private ListView m_oListView2 = null;
    private ListView m_oListView3 = null;
    private ListView m_oListView4 = null;
    private ListView m_oListView5 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_claim);

        Spinner Main_spinner = (Spinner)findViewById(R.id.spinner);

        //스피너 어댑터 설정
        ArrayAdapter adapterS = ArrayAdapter.createFromResource(this,R.array.location,android.R.layout.simple_spinner_item);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Main_spinner.setAdapter(adapterS);



        //스피너 이벤트 발생
        Main_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

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
