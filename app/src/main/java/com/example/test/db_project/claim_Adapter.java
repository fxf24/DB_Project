package com.example.test.db_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class claim_Adapter extends BaseAdapter {
    Context context;
    ArrayList<claim> claimArrayList;

    public claim_Adapter(Context context, ArrayList<claim> claimArrayList) {
        this.context = context;
        this.claimArrayList = claimArrayList;
    }

    @Override
    public int getCount() {
        return this.claimArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return claimArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.claim,null);
        }

        TextView claim_textView = convertView.findViewById(R.id.claim_content);
        TextView room_number_textView = convertView.findViewById(R.id.room_number);

        claim_textView.setText(claimArrayList.get(position).getClaim());
        room_number_textView.setText(String.valueOf(claimArrayList.get(position).getRoom_number()));

        return convertView;
    }
}

