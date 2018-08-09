package com.ckd.two.mykpop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ckd.two.mykpop.R;
import com.ckd.two.mykpop.model.ItemHomePager;

import java.util.List;

public class HomeViewpagerAdapter extends PagerAdapter {
    private List<ItemHomePager> list;
    private Context context;
    private LayoutInflater inflater;

    public HomeViewpagerAdapter(Context context, List<ItemHomePager> list) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object.equals(view);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = inflater.inflate(R.layout.item_viewpager_home, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_home_pager);
        TextView textView = (TextView) itemView.findViewById(R.id.tv_name_home_pager);

        ItemHomePager itemHomePager = list.get(position);

        Glide.with(context).load(itemHomePager.getImage()).into(imageView);
        textView.setText(itemHomePager.getName());

        // ThÃªm itemView vÃ o viewPager
        container.addView(itemView);
        return itemView;
    }

}
