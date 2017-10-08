package com.example.lab3news.Item;


import java.io.Serializable;

public class Item implements Serializable{
    int id;
    String title;
    String date;
    String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
