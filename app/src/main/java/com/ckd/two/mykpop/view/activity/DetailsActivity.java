package com.ckd.two.mykpop.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.ckd.two.mykpop.R;
import com.ckd.two.mykpop.adapter.DetailAdapter;
import com.ckd.two.mykpop.adapter.MainAdapter;

public class DetailsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private DetailAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initToolBar();
        initView();
        initViewPager();
        initData();
    }

    private void initViewPager() {
        FragmentManager manager = getSupportFragmentManager();
        adapter = new DetailAdapter(manager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        toolbar.setTitle("BTS");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData() {

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.detail_view_pager);
        tabLayout = (TabLayout) findViewById(R.id.detail_tab_layout);
    }
}
