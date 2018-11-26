package com.example.test.db_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;



public class Data{
    int src;
    String text1;
    String text2;
    String text3;

    public Data(int src, String text1, String text2,String text3){
        this.src =src;
        this.text1=text1;
        this.text2=text2;
        this.text3=text3;


    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text2 = text3;
    }
}

