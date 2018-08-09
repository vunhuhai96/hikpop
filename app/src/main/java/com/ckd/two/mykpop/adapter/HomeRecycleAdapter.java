package com.ckd.two.mykpop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ckd.two.mykpop.R;
import com.ckd.two.mykpop.model.ItemHomePager;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.ViewHolder> {
    private List<ItemHomePager> list;
    private Context context;

    public HomeRecycleAdapter(List<ItemHomePager> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_home, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecycleAdapter.ViewHolder holder, int position) {
        ItemHomePager itemHomePager = list.get(position);

        Glide.with(context).load(itemHomePager.getImage()).into(holder.imageView);
        holder.textView.setText(itemHomePager.getName());
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CircleImageView imageView;
        LinearLayout layout;
        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.tv_name_home_idol);
            imageView = (CircleImageView) v.findViewById(R.id.img_home_idol);
            //layout = (LinearLayout) v.findViewById(R.id.linear_video);
        }
    }
}
