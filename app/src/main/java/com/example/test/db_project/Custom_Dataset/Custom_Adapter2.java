package com.example.test.db_project.Custom_Dataset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.test.db_project.R;

import java.util.ArrayList;

/**
 * Created by jiwoong on 2018. 12. 5..
 */

public class Custom_Adapter2 extends BaseAdapter {

    ArrayList<Data2> data2;
    Context context2;

    public Custom_Adapter2(ArrayList<Data2> data2, Context context2){
        this.data2 =data2;
        this.context2=context2;
    }

    @Override
    public int getCount() {
        return data2.size();
    }

    @Override
    public Object getItem(int i) {
        return data2.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context2);

        if(view == null){
            view = inflater.inflate(R.layout.activity_customer_reservation, null);
        }


        TextView customer_name = view.findViewById(R.id.customer_name);
        TextView customer_phone = view.findViewById(R.id.customer_phone);
        TextView customer_group_num = view.findViewById(R.id.customer_group_num);
        TextView check_in = view.findViewById(R.id.check_in);
        TextView check_out = view.findViewById(R.id.check_out);


        customer_name.setText(data2.get(i).text4);
        customer_phone.setText(data2.get(i).text5);
        customer_group_num.setText(data2.get(i).text6);
        check_in.setText(data2.get(i).text7);
        check_out.setText(data2.get(i).text8);


        return view;
    }
}
