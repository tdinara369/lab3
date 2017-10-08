package com.example.lab3news.FragmentActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab3news.DatabaseHelper;
import com.example.lab3news.Item.Item;
import com.example.lab3news.R;
import com.example.lab3news.adapter.RecentNewsAdapter;

import java.util.ArrayList;


public class RecentNewsFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private ArrayList<Item> arrayList=new ArrayList<Item>();
    private Cursor cursor;
    private RecentNewsAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup=(ViewGroup) inflater.inflate(R.layout.list_item, container,false);
        recyclerView=(RecyclerView) viewGroup.findViewById(R.id.recycler_view);
        loadDatabase();
        return viewGroup;
    }

    public void loadDatabase(){
        databaseHelper=new DatabaseHelper(getActivity());
        try {
            databaseHelper.checkAndCopyDatabase();
            databaseHelper.openDatabase();
        } catch (SQLiteException e){
            e.printStackTrace();
        }
        try {
            cursor = databaseHelper.QueryData("select * from news");
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        Item item = new Item();
                        item.setTitle(cursor.getString(1));
                        item.setDate(cursor.getString(2));
                        item.setBody(cursor.getString(4));
                        arrayList.add(item);
                    } while ((cursor.moveToNext()));
                }
            }
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        adapter=new RecentNewsAdapter(getActivity(),arrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
