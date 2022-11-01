package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;
    ArrayList<Contact>listContact = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list =findViewById(R.id.recycler);
        list.setLayoutManager(new LinearLayoutManager(this));
        remplir();
        CardAdapter adapter = new CardAdapter(this,listContact);
        list.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void remplir()
    {
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));
        listContact.add(new Contact("ComtactOne","2222222"));



    }


}