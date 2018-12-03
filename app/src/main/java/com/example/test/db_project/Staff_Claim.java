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

        String[] strClaim = {"수건이 더 필요해요", "밤11시에 와인을 갖다주세요", "방청소좀 해주세요", "전기가 들어오지 않습니다",
                 "수영장이 더러워요", "조식이 맛없어요", "스키 장비를 빌리고싶어요", "낚시용품 있나요", "3일뒤에 오겠습니다"};

        String[] strName = {"가나다", "마바사", "아자차", "카타파", "하", "ABC", "DEF", "GHI", "JKL"};
        int nDatCnt=0;
        //데이터 입력. 데이터베이스에서 끌어올 부분이라 그냥 대충했어요
        ArrayList<ItemData> Data1 = new ArrayList<>();
        for (int i=0; i<9; ++i)
        {
            ItemData Item1 = new ItemData();
            Item1.strNum = "10" + (i+1) + "호";
            Item1.strClaim = strClaim[nDatCnt];
            Item1.strName = strName[nDatCnt];
            Item1.onClickListener = (View.OnClickListener) this;
            Data1.add(Item1);
            nDatCnt++;
            if (nDatCnt >= strClaim.length) nDatCnt = 0;
        }

        ArrayList<ItemData> Data2 = new ArrayList<>();
        for(int j = 0; j<9; ++j){
            ItemData Item2 = new ItemData();
            Item2.strNum = "20" + (j+1) + "호";
            Item2.strClaim = strClaim[nDatCnt++];
            Item2.onClickListener = (View.OnClickListener) this;
            Data2.add(Item2);
            if (nDatCnt >= strClaim.length) nDatCnt = 0;
        }

        ArrayList<ItemData> Data3 = new ArrayList<>();
        for(int k = 0; k<9; ++k){
            ItemData Item3 = new ItemData();
            Item3.strNum = "30" + (k+1) + "호";
            Item3.strClaim = strClaim[nDatCnt++];
            Data3.add(Item3);
            if (nDatCnt >= strClaim.length) nDatCnt = 0;
        }

        ArrayList<ItemData> Data4 = new ArrayList<>();
        for(int l = 0; l<9; ++l){
            ItemData Item4 = new ItemData();
            Item4.strNum = "40" + (l+1) + "호";
            Item4.strClaim = strClaim[nDatCnt++];
            Data4.add(Item4);
            if (nDatCnt >= strClaim.length) nDatCnt = 0;
        }

        ArrayList<ItemData> Data5 = new ArrayList<>();
        for(int m = 0; m<9; ++m){
            ItemData Item5 = new ItemData();
            Item5.strNum = "50" + (m+1) + "호";
            Item5.strClaim = strClaim[nDatCnt++];
            Data5.add(Item5);
            if (nDatCnt >= strClaim.length) nDatCnt = 0;
        }

        // ListView, Adapter 생성 및 연결 ------------------------
        m_oListView1 = (ListView)findViewById(R.id.floor_1);
        ListAdapter Adapter1 = new ListAdapter(Data1);
        m_oListView1.setAdapter(Adapter1);

        m_oListView2 = (ListView)findViewById(R.id.floor_2);
        ListAdapter Adapter2 = new ListAdapter(Data2);
        m_oListView2.setAdapter(Adapter2);

        m_oListView3 = (ListView)findViewById(R.id.floor_3);
        ListAdapter Adapter3 = new ListAdapter(Data3);
        m_oListView3.setAdapter(Adapter3);

        m_oListView4 = (ListView)findViewById(R.id.floor_4);
        ListAdapter Adapter4 = new ListAdapter(Data4);
        m_oListView4.setAdapter(Adapter4);

        m_oListView5 = (ListView)findViewById(R.id.floor_5);
        ListAdapter Adapter5 = new ListAdapter(Data5);
        m_oListView5.setAdapter(Adapter4);

        Spinner Main_spinner = (Spinner)findViewById(R.id.spinner);

        //스피너 어댑터 설정
        ArrayAdapter adapterS = ArrayAdapter.createFromResource(this,R.array.location,android.R.layout.simple_spinner_item);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Main_spinner.setAdapter(adapterS);



        //스피너 이벤트 발생
        Main_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String floor = (String) parent.getItemAtPosition(position);
                if (floor.equals("1층")){
                    m_oListView1.setVisibility(View.VISIBLE);
                    m_oListView2.setVisibility(View.INVISIBLE);
                    m_oListView3.setVisibility(View.INVISIBLE);
                    m_oListView4.setVisibility(View.INVISIBLE);
                    m_oListView5.setVisibility(View.INVISIBLE);
                }else if (floor.equals("2층")){
                    m_oListView2.setVisibility(View.VISIBLE);
                    m_oListView1.setVisibility(View.INVISIBLE);
                    m_oListView3.setVisibility(View.INVISIBLE);
                    m_oListView4.setVisibility(View.INVISIBLE);
                    m_oListView5.setVisibility(View.INVISIBLE);
                }else if (floor.equals("3층")){
                    m_oListView3.setVisibility(View.VISIBLE);
                    m_oListView1.setVisibility(View.INVISIBLE);
                    m_oListView2.setVisibility(View.INVISIBLE);
                    m_oListView4.setVisibility(View.INVISIBLE);
                    m_oListView5.setVisibility(View.INVISIBLE);
                }else if (floor.equals("4층")){
                    m_oListView4.setVisibility(View.VISIBLE);
                    m_oListView1.setVisibility(View.INVISIBLE);
                    m_oListView2.setVisibility(View.INVISIBLE);
                    m_oListView3.setVisibility(View.INVISIBLE);
                    m_oListView5.setVisibility(View.INVISIBLE);
                }else if (floor.equals("5층")){
                    m_oListView5.setVisibility(View.VISIBLE);
                    m_oListView1.setVisibility(View.INVISIBLE);
                    m_oListView2.setVisibility(View.INVISIBLE);
                    m_oListView3.setVisibility(View.INVISIBLE);
                    m_oListView4.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v)
    {
        View oParentView = (View)v.getParent();
        TextView oTextClaim = (TextView) oParentView.findViewById(R.id.textClaim);
        String position = (String) oParentView.getTag();

        AlertDialog.Builder oDialog = new AlertDialog.Builder(this,
                android.R.style.Theme_DeviceDefault_Light_Dialog);
        int a = Integer.parseInt(position) + 1;
        String strMsg = "10"+ a +"호 클레임입니다.\n내용 :" + oTextClaim.getText();
        oDialog.setMessage(strMsg)
                .setPositiveButton("확인", null)
                .show();
    }
}
