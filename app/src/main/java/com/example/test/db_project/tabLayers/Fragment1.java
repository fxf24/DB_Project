package com.example.test.db_project.tabLayers;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.test.db_project.staff_info;
import com.example.test.db_project.staff_info_Adapter;
import java.util.ArrayList;

public class Fragment1 extends ListFragment {

    staff_info_Adapter adapter;
    ArrayList<staff_info> staff_infoArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        staff_infoArrayList = new ArrayList<>();
        staff_infoArrayList.add(new staff_info("김재무","과장","jm123@jojo.com","01012345678"));
        staff_infoArrayList.add(new staff_info("김회계","부장","hk876@jojo.com","01087654321"));

        adapter = new staff_info_Adapter(getActivity(), staff_infoArrayList);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
