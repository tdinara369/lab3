package com.example.lab3news.FragmentActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab3news.Item.Item;
import com.example.lab3news.R;

public class DetailActivity extends AppCompatActivity {
    TextView text_word, txt_date, txt_body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        text_word=(TextView) findViewById(R.id.text_word);
        txt_date=(TextView) findViewById(R.id.txt_date);
        txt_body=(TextView) findViewById(R.id.txt_body);

        Item items= (Item) getIntent().getSerializableExtra("items");
        if(items!=null){
            text_word.setText(items.getTitle());
            txt_date.setText(items.getDate());
            txt_body.setText(items.getBody());
        }
    }
}
