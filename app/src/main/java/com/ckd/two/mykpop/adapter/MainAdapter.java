package com.ckd.two.mykpop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ckd.two.mykpop.view.fragment.HomeFragment;
import com.ckd.two.mykpop.view.fragment.NewsFragment;

public class MainAdapter extends FragmentStatePagerAdapter {

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag=new HomeFragment();
                break;
            case 1:
                frag=new NewsFragment();
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
        switch (position){
            case 0:
                title="Trang chủ";
                break;
            case 1:
                title="Tin tức";
                break;
        }

        return title;
    }
}
