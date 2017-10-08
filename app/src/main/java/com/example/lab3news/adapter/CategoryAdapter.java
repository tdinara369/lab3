package com.example.lab3news.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab3news.Category;
import com.example.lab3news.Item.Item;
//import com.example.lab3news.Item.SetViewHolder;
import com.example.lab3news.OnTapListener;
import com.example.lab3news.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Динара on 03.10.2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<Category> List;


    public CategoryAdapter(Context context, List<Category> List) {
        mContext = context;
        this.List = List;
        for (int i = 0; i < List.size(); i++){
            System.out.println(List.get(i).toString());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("ViewHolder", "Create");
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);

        return new CategoryAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e("ViewHolder", "Bind");
        Log.d("position", String.valueOf(position));
        CategoryAdapter.MyViewHolder viewHolder = (CategoryAdapter.MyViewHolder) holder;
        Category category = List.get(position);
        viewHolder.setPosition(position);
        viewHolder.Name.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return List.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Name;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.name);
        }


        public void setPosition(int position){
            this.position = position;
        }

    }
}
