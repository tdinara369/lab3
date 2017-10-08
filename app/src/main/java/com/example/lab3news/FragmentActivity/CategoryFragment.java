package com.example.lab3news.FragmentActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.lab3news.Category;
import com.example.lab3news.DatabaseHelper;
import com.example.lab3news.Item.Item;
import com.example.lab3news.R;
import com.example.lab3news.adapter.CategoryAdapter;


import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {
    CategoryAdapter categoryAdapter;
    List<Category> categoryList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categoryfragment, container, false);


        for(int i=0; i<10; i++){
            Category category = new Category("MyCategory");
            categoryList.add(category);
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        categoryAdapter = new CategoryAdapter(getActivity(), categoryList);
        GridLayoutManager llm = new GridLayoutManager(this.getContext(), 2);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(categoryAdapter);

        return view;
    }
}
