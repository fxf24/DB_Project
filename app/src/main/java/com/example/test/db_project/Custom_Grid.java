package com.example.test.db_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Custom_Grid extends LinearLayout {
    ImageView iv1;
    TextView tv1;

    public Custom_Grid(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.custom_grid, this);
        iv1 = findViewById(R.id.iv1);
        tv1 = findViewById(R.id.tv1);
    }

    public void setData(Grid_data gd){
        iv1.setImageResource(gd.src);
        tv1.setText(gd.text1);
    }
}
