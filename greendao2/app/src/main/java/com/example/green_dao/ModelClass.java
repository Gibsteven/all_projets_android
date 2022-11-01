package com.example.green_dao;
import android.graphics.Bitmap;

public class ModelClass {
    private String edit1,edit2 ;
    private Bitmap img;

    public ModelClass(String edit1, String edit2, Bitmap img) {
        this.edit1 = edit1;
        this.edit2 = edit2;
        this.img = img;
    }

    public String getEdit1() {
        return edit1;
    }

    public void setEdit1(String edit1) {
        this.edit1 = edit1;
    }

    public String getEdit2() {
        return edit2;
    }

    public void setEdit2(String edit2) {
        this.edit2 = edit2;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}
