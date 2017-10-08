package com.example.lab3news.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab3news.FragmentActivity.DetailActivity;
import com.example.lab3news.Item.Item;
import com.example.lab3news.OnTapListener;
import com.example.lab3news.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Динара on 02.10.2017.
 */

public class RecentNewsAdapter extends RecyclerView.Adapter<RecentNewsAdapter.SetViewHolder> {
    private Activity activity;
    private List<Item> items = Collections.emptyList();
    private OnTapListener onTapListener;
    public RecentNewsAdapter(Activity activity, List<Item> items){
        this.activity=activity;
        this.items=items;
    }
    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent,false);
        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, final int position) {
        holder.txt_title.setText(items.get(position).getTitle());
        holder.txt_date.setText(items.get(position).getDate());
        //holder.txt_body.setText(items.get(position).getBody());

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    class SetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_title;
        public TextView txt_date;
        public TextView txt_body;

        public SetViewHolder(View itemView) {
            super(itemView);
            txt_title=(TextView) itemView.findViewById(R.id.text_word);
            txt_date=(TextView) itemView.findViewById(R.id.txt_date);
            txt_body=(TextView) itemView.findViewById(R.id.txt_body);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Intent intent=new Intent(activity, DetailActivity.class);
            intent.putExtra("items", items.get(getAdapterPosition()));
            activity.startActivity(intent);
        }
    }




}
