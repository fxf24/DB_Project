package com.example.test.db_project.Custom_Dataset;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.test.db_project.R;

import java.util.ArrayList;

public class room_list_adapter extends BaseAdapter {
    ArrayList<staff_room_data> data;
    Context context;

    public room_list_adapter(Context context, ArrayList<staff_room_data> data){
        this.context = context;
        this.data = data;
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
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.room_list_1,null);
        }

        TextView room = convertView.findViewById(R.id.room_m);
        TextView clean = convertView.findViewById(R.id.clean);
        TextView amenity = convertView.findViewById(R.id.amenity);
        TextView avail = convertView.findViewById(R.id.avail);

        room.setText(data.get(position).getRoom());
        clean.setText(data.get(position).getClean());
        amenity.setText(data.get(position).getAmenity());
        avail.setText(data.get(position).getAvail());

        return convertView;
    }
}
