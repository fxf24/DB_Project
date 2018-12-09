package com.example.test.db_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.example.test.db_project.Custom_Dataset.Grid_adapter;
import com.example.test.db_project.Custom_Dataset.Grid_data;

import java.util.ArrayList;

public class Parking extends AppCompatActivity {
    ArrayList<Grid_data> parking_info= new ArrayList<>();
    Grid_adapter adapter;
    GridView gv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        Spinner Main_spinner = findViewById(R.id.parking_floor);

        //스피너 어댑터 설정
        ArrayAdapter adapterS = ArrayAdapter.createFromResource(this,R.array.parking,android.R.layout.simple_spinner_item);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Main_spinner.setAdapter(adapterS);

        gv1 = findViewById(R.id.parking);
        adapter = new Grid_adapter(parking_info, Parking.this);
        gv1.setAdapter(adapter);
        Main_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parking_info.clear();
                adapter.notifyDataSetChanged();
                Log.e("test2",String.valueOf(position));
                Get_DB<Grid_data, Grid_adapter> get_db = new Get_DB<>(3, parking_info, adapter);
                get_db.execute("parking.php", "sql=select location, availability from parking where floor='"+ (position+1)+"B'");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
