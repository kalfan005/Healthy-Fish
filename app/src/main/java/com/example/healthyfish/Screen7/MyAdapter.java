package com.example.healthyfish.Screen7;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.healthyfish.Screen7.Fragment1.Seafish;
import com.example.healthyfish.Screen7.Fragment2.Backwaterfish;
import com.example.healthyfish.Screen7.Fragment3.Fishfish;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Seafish seafish = new Seafish();
                return seafish;
            case 1:
                Backwaterfish backwaterfish = new Backwaterfish();
                return backwaterfish;
            case 2:
                Fishfish fishfish = new Fishfish();
                return fishfish;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}