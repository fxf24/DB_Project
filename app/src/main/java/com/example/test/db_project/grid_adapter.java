package com.example.test.db_project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class grid_adapter extends BaseAdapter {
    ArrayList<grid_data> data;
    Context context;

    public grid_adapter(ArrayList<grid_data> data, Context context) {
        this.data = data;
        this.context = context;
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

        if (convertView == null) {
            convertView = new Custom_Grid(context);
        }

        ((Custom_Grid) convertView).setData(data.get(position));
        return convertView;
    }

}

