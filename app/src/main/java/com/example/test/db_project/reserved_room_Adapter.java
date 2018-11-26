package com.example.test.db_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


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

        TextView room_textView = convertView.findViewById(R.id.room);
        TextView date_textView = convertView.findViewById(R.id.date);
        TextView staff_name_textView = convertView.findViewById(R.id.staff_name);

        String room = String.valueOf(reserved_roomArrayList.get(position).getRoom());
        room_textView.setText(room);
        date_textView.setText(reserved_roomArrayList.get(position).getDate());
        staff_name_textView.setText(reserved_roomArrayList.get(position).getStaff_name());

        return convertView;
    }
}
