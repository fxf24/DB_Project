package com.example.test.db_project.tabLayers;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            Fragment1 tabFragment1 = new Fragment1();
            return tabFragment1;
        }else if(position == 1){
            Fragment2 tabFragment2 = new Fragment2();
            return tabFragment2;
        }else if(position == 2){
            Fragment3 tabFragment3 = new Fragment3();
            return tabFragment3;
        }else if(position == 3){
            Fragment4 tabFragment4 = new Fragment4();
            return tabFragment4;
        }else if(position == 4){
            Fragment5 tabFragment5 = new Fragment5();
            return tabFragment5;
        }else{
            return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}