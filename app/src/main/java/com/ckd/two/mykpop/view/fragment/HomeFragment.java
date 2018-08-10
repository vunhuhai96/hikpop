package com.ckd.two.mykpop.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ckd.two.mykpop.R;
import com.ckd.two.mykpop.adapter.HomeRecycleAdapter;
import com.ckd.two.mykpop.adapter.HomeViewpagerAdapter;
import com.ckd.two.mykpop.model.ItemHomePager;
import com.ckd.two.mykpop.view.activity.DetailsActivity;
import com.ckd.two.mykpop.view.activity.ListIdolActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ViewPager viewPager;
    private RecyclerView recyclerViewBoy;
    private RecyclerView recyclerViewGirl;
    private RecyclerView recyclerViewSolo;
    private HomeViewpagerAdapter homeViewpagerAdapter;
    private HomeRecycleAdapter homeBoyAdapter, homeGirlAdapter, homeSoloAdapter;
    private List<ItemHomePager> listHomePager;
    private List<ItemHomePager> listHomeBoy, listHomeGirl, listHomeSolo;
    private CircleIndicator indicator;
    private Handler handler;
    private int delay = 5000;
    private int page = 0;
    private DatabaseReference mReference;

    public HomeFragment() {
        handler = new Handler();
    }

    Runnable runnable = new Runnable() {
        public void run() {
            if (homeViewpagerAdapter.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            viewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        mReference = FirebaseDatabase.getInstance().getReference();
        initView();
        initViewpager();
        initRecycleBoy();
        initRecycleGirl();
        initRecycleSolo();
        return view;
    }

    private void initRecycleGirl() {
        listHomeGirl = new ArrayList<>();
        listHomeGirl.clear();
        mReference.child("girls").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ItemHomePager itemHomePager = dataSnapshot.getValue(ItemHomePager.class);
                listHomeGirl.add(itemHomePager);
                homeGirlAdapter = new HomeRecycleAdapter(listHomeGirl, getContext());
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewGirl.setLayoutManager(layoutManager);
                recyclerViewGirl.setAdapter(homeGirlAdapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initRecycleSolo() {
        listHomeSolo = new ArrayList<>();
        listHomeSolo.clear();
        mReference.child("solo").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ItemHomePager itemHomePager = dataSnapshot.getValue(ItemHomePager.class);
                listHomeSolo.add(itemHomePager);
                homeSoloAdapter = new HomeRecycleAdapter(listHomeSolo, getContext());
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewSolo.setLayoutManager(layoutManager);
                recyclerViewSolo.setAdapter(homeSoloAdapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initRecycleBoy() {
        listHomeBoy = new ArrayList<>();
        listHomeBoy.clear();
        mReference.child("boys").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ItemHomePager itemHomePager = dataSnapshot.getValue(ItemHomePager.class);
                listHomeBoy.add(itemHomePager);
                homeBoyAdapter = new HomeRecycleAdapter(listHomeBoy, getContext());
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewBoy.setLayoutManager(layoutManager);
                recyclerViewBoy.setAdapter(homeBoyAdapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initViewpager() {
        listHomePager = new ArrayList<>();
        listHomePager.clear();
        mReference.child("hot").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ItemHomePager itemHomePager = dataSnapshot.getValue(ItemHomePager.class);
                listHomePager.add(itemHomePager);
                homeViewpagerAdapter = new HomeViewpagerAdapter(getContext(), listHomePager);
                viewPager.setAdapter(homeViewpagerAdapter);
                indicator.setViewPager(viewPager);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void initView() {
        viewPager = (ViewPager) view.findViewById(R.id.view_pager_home);
        recyclerViewBoy = (RecyclerView) view.findViewById(R.id.recycle_boy);
        recyclerViewGirl = (RecyclerView) view.findViewById(R.id.recycle_girl);
        recyclerViewSolo = (RecyclerView) view.findViewById(R.id.recycle_solo);
        indicator = (CircleIndicator) view.findViewById(R.id.circle_indicator);
        view.findViewById(R.id.tv_show_more_boy).setOnClickListener(this);
        view.findViewById(R.id.tv_show_more_girl).setOnClickListener(this);
        view.findViewById(R.id.tv_show_more_solo).setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, delay);
    }


    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_show_more_boy:
                Intent intent = new Intent(getContext(), ListIdolActivity.class);
                intent.putExtra("idol","boys");
                startActivity(intent);
                break;
            case R.id.tv_show_more_girl:
                Intent intent1 = new Intent(getContext(), ListIdolActivity.class);
                intent1.putExtra("idol","girls");
                startActivity(intent1);
                break;
            case R.id.tv_show_more_solo:
                Intent intent2 = new Intent(getContext(), ListIdolActivity.class);
                intent2.putExtra("idol","solo");
                startActivity(intent2);
                break;

        }
    }
}
