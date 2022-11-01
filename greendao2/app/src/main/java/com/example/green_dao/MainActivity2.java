package com.example.green_dao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private TextView nom,email;
    private ImageView image;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nom = findViewById(R.id.nom);
        image = findViewById(R.id.image);
        email = findViewById(R.id.email);

        DBHelper dbHelper = new DBHelper(this);

        Cursor cursor = dbHelper.getUser();
        if (cursor.getCount() == 0){
           Toast.makeText(getApplicationContext(), "No entries", Toast.LENGTH_SHORT).show();
       }else{
            while (cursor.moveToNext()){
                nom.setText(""+cursor.getString(0));
                email.setText(""+cursor.getString(1));
                byte[] imageByte = cursor.getBlob(2);
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);
                image.setImageBitmap(bitmap);
          }
      }
    }
}