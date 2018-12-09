package com.example.test.db_project.Custom_Dataset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.db_project.R;

import java.util.ArrayList;

public class staff_claim_adapter extends BaseAdapter
{
    Context context;
    private ArrayList<staff_claim_data> data;


    public staff_claim_adapter(Context context, ArrayList<staff_claim_data> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount()
    {
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
        }

        TextView oTextNum = convertView.findViewById(R.id.roomNum);
        TextView oTextClaim = convertView.findViewById(R.id.textClaim);
        TextView oTextName = convertView.findViewById(R.id.textName);
        Button oBtn = convertView.findViewById(R.id.btnSelector);

        oTextNum.setText(data.get(position).getRoom());
        oTextClaim.setText(data.get(position).getClaim());
        oTextName.setText(data.get(position).getName());
        oBtn.setOnClickListener(data.get(position).onClickListener);

        return convertView;
    }
}