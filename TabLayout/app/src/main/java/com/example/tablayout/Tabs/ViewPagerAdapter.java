package com.example.tablayout.Tabs;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        final Fragment[] fragment = {null};

        if (position == 0) {
            fragment[0] = new FragmentSunday();
        } else if (position == 1) {
            fragment[0] = new FragmentMonday();
        } else if (position == 2) {
            fragment[0] = new FragmentTuesday();
        } else if (position == 3) {
            fragment[0] = new FragmentWednesday();
        } else if (position == 4) {
            fragment[0] = new FragmentThursday();
        }
        return fragment[0];
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "SUN";
        } else if (position == 1) {
            return "MON";
        } else if (position == 2) {
            return "TUE";
        }else if (position == 3) {
            return "WED";
        }else if (position == 4) {
            return "THU";
        }
        return null;
    }

}
