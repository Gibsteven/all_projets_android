package com.example.textrecongnition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView_data;
    Button scan_btn;
    private static final int REQUEST_CAMERA_CODE = 100;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_data=findViewById(R.id.textview_data);
        scan_btn = findViewById(R.id.scan_btn);


        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA )!= PackageManager.PERMISSION_GRANTED)

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.CAMERA

            }, REQUEST_CAMERA_CODE );


        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}