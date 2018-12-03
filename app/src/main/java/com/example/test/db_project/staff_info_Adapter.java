package com.example.test.db_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class staff_info_Adapter extends BaseAdapter {
    Context context;
    ArrayList<staff_info> staff_infoArrayList;

    public  staff_info_Adapter(Context context, ArrayList<staff_info> staff_infoArrayList){
        this.context = context;
        this.staff_infoArrayList = staff_infoArrayList;
    }

    @Override
    public int getCount() {
        return this.staff_infoArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return staff_infoArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.staff_info,null);
        }

        TextView name_textView = convertView.findViewById(R.id.name);
        TextView position_textView = convertView.findViewById(R.id.position);
        TextView address_textView = convertView.findViewById(R.id.address);
        TextView phone_textView = convertView.findViewById(R.id.phone);

        name_textView.setText(staff_infoArrayList.get(position).getName());
        position_textView.setText(staff_infoArrayList.get(position).getPosition());
        address_textView.setText(staff_infoArrayList.get(position).getAddress());
        phone_textView.setText(staff_infoArrayList.get(position).getPhone());

        return convertView;
    }
}
