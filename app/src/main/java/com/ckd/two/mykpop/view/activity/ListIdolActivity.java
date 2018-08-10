package com.ckd.two.mykpop.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ckd.two.mykpop.R;
import com.ckd.two.mykpop.adapter.HomeRecycleAdapter;
import com.ckd.two.mykpop.adapter.ListIdolAdapter;
import com.ckd.two.mykpop.model.ItemHomePager;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListIdolActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ListIdolAdapter adapter;
    private List<ItemHomePager> list;
    private DatabaseReference mReference;
    private Intent intent;
    private String nameIdol;
    public static String KEY_NAME = "idol";
    public static String KEY_BOYS = "boys";
    public static String KEY_GIRL = "girls";
    public static String KEY_SOLO = "solo";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_idol);
        mReference = FirebaseDatabase.getInstance().getReference();
        intent = getIntent();
        nameIdol = intent.getStringExtra(KEY_NAME);
        initToolbar();
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.clear();
        mReference.child(nameIdol).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ItemHomePager itemHomePager = dataSnapshot.getValue(ItemHomePager.class);
                list.add(itemHomePager);
                adapter = new ListIdolAdapter(list, ListIdolActivity.this);
                recyclerView.setLayoutManager(new GridLayoutManager(ListIdolActivity.this, 2));
                recyclerView.setAdapter(adapter);
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
        recyclerView = (RecyclerView) findViewById(R.id.recycle_list_idol);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_list_idol);
        String title = "";
        if (KEY_BOYS.equals(nameIdol)) {
            title = this.getResources().getString(R.string.danh_sach_nhom_nhac_nam);
        } else if (KEY_GIRL.equals(nameIdol)) {
            title = this.getResources().getString(R.string.danh_sach_nhom_nhac_nu);
        } else if (KEY_SOLO.equals(nameIdol)) {
            title = this.getResources().getString(R.string.danh_sach_nghe_si_solo);
        }

        toolbar.setTitle(title);
        toolbar.setTitleTextColor(this.getResources().getColor(R.color.white));
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
}
