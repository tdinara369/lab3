package com.example.lab3news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lab3news.FragmentActivity.CategoryFragment;
import com.example.lab3news.FragmentActivity.RecentNewsFragment;



public class ViewPagerAdapter extends FragmentPagerAdapter {
    int numTabs;
    public ViewPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs=numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                RecentNewsFragment rnewsFragment=new RecentNewsFragment();
                return rnewsFragment;
            case 1:
                CategoryFragment categoryFragment=new CategoryFragment();
                return categoryFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
