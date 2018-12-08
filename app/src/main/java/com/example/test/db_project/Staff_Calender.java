package com.example.test.db_project;

import android.app.Activity;

import android.os.Bundle;

import android.widget.CalendarView;

import android.widget.Toast;





public class Staff_Calender extends Activity {

    public String schedule(int a, int b){
        String schedule[][] = new String[50][50];//2차원 배열을 사용하여 월,일의 값을 달력에서 받아와 그날짜의 근무자 명단을 리턴할 수 있다.
        schedule[10][30]="Staff A\nStaff Aa";//10월 30일 근무표에 Staff A,Staff Aa 저장
        schedule[10][29]="Staff B";//10월 30일 근무표에 Staff B 저장
        return schedule[a][b];
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_staff_calender);
        //CalendarView 인스턴스 만들기

        CalendarView calendar = findViewById(R.id.calendar);
        //리스너 등록
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                // TODO Auto-generated method stub

                Toast.makeText(Staff_Calender.this, ""+year+"/"+month+"/"

                        +dayOfMonth+"\n"+schedule(month+1,dayOfMonth), Toast.LENGTH_SHORT).show();
                        //month값에 +1 해줘야 scheudule 배열에서 날짜와 같은 인덱스안의 값을 리턴가능

            }
        });
    }







}




