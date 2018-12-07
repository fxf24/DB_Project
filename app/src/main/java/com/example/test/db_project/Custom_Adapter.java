package com.example.test.db_project;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Custom_Adapter extends  BaseAdapter{
    ArrayList<Data> data;
    Context context;

    public Custom_Adapter(ArrayList<Data> data, Context context){
        this.data =data;
        this.context=context;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_layout, null);
        }

        ImageView iv1 = convertView.findViewById(R.id.iv1);
        TextView tv1 = convertView.findViewById(R.id.tv1);
        TextView tv2 = convertView.findViewById(R.id.tv2);
        TextView tv3 = convertView.findViewById(R.id.tv3);

        iv1.setImageResource(data.get(position).src);
        tv1.setText(data.get(position).text1);
        tv2.setText(data.get(position).text2);
        tv3.setText(data.get(position).text3);


        return convertView;
    }
}

