package com.example.green_dao;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    ImageView img;
    EditText edit1,edit2;

    DBHelper dbHelper;

    private static final int PICK_IMAGE_REQUEST=99;
    private Uri imagePath;
    private Bitmap imageToStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        submit = findViewById(R.id.submit);
        img = findViewById(R.id.img);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        dbHelper = new DBHelper(this);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choseImage();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeImage();
            }
        });
    }

    private void choseImage() {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent,PICK_IMAGE_REQUEST);
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode ==RESULT_OK && data != null && data.getData() != null){
                imagePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(),imagePath);
                img.setImageBitmap(imageToStore);
            }
        }
            catch (Exception e)
            {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
    }
    private void storeImage(){
        if (!edit1.getText().toString().isEmpty() && !edit2.getText().toString().isEmpty()
                && img.getDrawable()!= null && imageToStore != null )
        {
            dbHelper.storeData(new ModelClass(edit1.getText().toString(),edit2.getText().toString(),imageToStore));
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(),"Please fill all th fields",Toast.LENGTH_SHORT).show();
    }
}