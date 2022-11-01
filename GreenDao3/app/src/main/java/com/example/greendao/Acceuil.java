package com.example.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Acceuil extends AppCompatActivity {
    UsersDao user;

    DatabaseHelper DatabaseHelper;
    private TextView Text = findViewById(R.id.Text);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        DatabaseHelper = new DatabaseHelper(Acceuil.this);
    }
}