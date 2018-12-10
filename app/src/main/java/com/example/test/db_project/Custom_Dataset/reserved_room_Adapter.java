package com.example.test.db_project.Custom_Dataset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.test.db_project.R;

import java.util.ArrayList;

public class reserved_room_Adapter extends BaseAdapter {
    Context context;
    ArrayList<reserved_room> reserved_roomArrayList;

    public reserved_room_Adapter(Context context, ArrayList<reserved_room> reserved_roomArrayList) {
        this.context = context;
        this.reserved_roomArrayList = reserved_roomArrayList;
    }

    @Override
    public int getCount() {
        return this.reserved_roomArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return reserved_roomArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.reserved_room,null);
        }

        TextView staffID = convertView.findViewById(R.id.staffID);
        TextView date = convertView.findViewById(R.id.date);
        TextView name = convertView.findViewById(R.id.name);
        TextView phone = convertView.findViewById(R.id.phone_num);

        staffID.setText(reserved_roomArrayList.get(position).getStaffID());
        date.setText(reserved_roomArrayList.get(position).getDate());
        name.setText(reserved_roomArrayList.get(position).getName());
        phone.setText(reserved_roomArrayList.get(position).getPhone_num());

        return convertView;
    }
}
