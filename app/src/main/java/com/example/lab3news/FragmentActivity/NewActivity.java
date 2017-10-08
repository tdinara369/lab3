package com.example.lab3news.FragmentActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lab3news.Item.Item;
import com.example.lab3news.R;

/**
 * Created by Динара on 03.10.2017.
 */

public class NewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapse_news);


        Item items = getIntent().getParcelableExtra("items");

        TextView textView = (TextView) findViewById(R.id.text_word);
        TextView textView1 = (TextView) findViewById(R.id.txt_date);
        TextView textView2 = (TextView) findViewById(R.id.txt_body);

        textView.setText(items.getTitle());
        textView1.setText(items.getDate());
        textView2.setText(items.getBody());
    }
}
