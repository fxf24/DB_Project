package com.example.test.db_project;

import android.app.Activity;

import android.app.ListActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.CalendarView;

import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.test.db_project.Custom_Dataset.staff_info_Adapter;

public class Staff_Calender extends Activity {
    String schedule[][] = new String[13][32];

    public void schedule(){
        for(int i = 0; i<13; i++){
            for(int j= 0; j<32; j++){
                schedule[i][j] = " ";
            }
        }
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_staff_calender);
        //CalendarView 인스턴스 만들기

        schedule();
        Log.e("test3",schedule[1][1]);

        Get_DB<Void, staff_info_Adapter> get_db = new Get_DB<>(6, schedule);
        get_db.execute("fom.php","sql=select name,month(date),day(date) from fom NATURAL JOIN hr order by date");
        CalendarView calendar = findViewById(R.id.calendar);
        //리스너 등록
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                // TODO Auto-generated method stub

                Toast.makeText(Staff_Calender.this, ""+year+"-"+(month+1)+"-"

                        +dayOfMonth+"\n"+schedule[month+1][dayOfMonth], Toast.LENGTH_SHORT).show();
                        //month값에 +1 해줘야 scheudule 배열에서 날짜와 같은 인덱스안의 값을 리턴가능

            }
        });

//        select name,date from fom NATURAL JOIN hr order by date
    }
}




