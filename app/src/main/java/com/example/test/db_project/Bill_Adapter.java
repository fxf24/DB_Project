package com.example.test.db_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Bill_Adapter extends BaseAdapter {
    ArrayList<Bill_data> data;
    Context context;

    public Bill_Adapter(Context context, ArrayList<Bill_data> data){
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
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.bill_adapter, null);

        TextView name = convertView.findViewById(R.id.name);
        TextView date= convertView.findViewById(R.id.date);
        TextView type = convertView.findViewById(R.id.type);
        TextView item = convertView.findViewById(R.id.item);
        TextView amount = convertView.findViewById(R.id.amount);
        TextView price = convertView.findViewById(R.id.price);

        name.setText(data.get(position).getName());
        date.setText(data.get(position).getDate());
        type.setText(data.get(position).getType());
        item.setText(data.get(position).getItem());
        amount.setText(data.get(position).getAmount());
        price.setText(data.get(position).getPrice());

        return convertView;
    }
}
