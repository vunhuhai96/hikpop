package com.ckd.two.mykpop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ckd.two.mykpop.view.fragment.HomeFragment;
import com.ckd.two.mykpop.view.fragment.InfoFragment;
import com.ckd.two.mykpop.view.fragment.NewsFragment;

public class DetailAdapter extends FragmentStatePagerAdapter {

    public DetailAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new InfoFragment();
                break;
            case 1:
                frag = new InfoFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Thông tin";
                break;
            case 1:
                title = "Thành viên";
                break;
        }

        return title;
    }
}