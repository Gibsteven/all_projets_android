package com.example.smartcheckingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView list;
    ArrayList<Contact> listContact = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list =findViewById(R.id.recycler);
        list.setLayoutManager(new LinearLayoutManager(this));
        remplir();
        CardAdapter adapter = new CardAdapter(this,listContact);
        list.setAdapter(adapter);
    }

    private void remplir()
    {
        listContact.add(new Contact("bradley","","","","","","",R.drawable.img));
        listContact.add(new Contact("john","","","","","","",R.drawable.in));
        listContact.add(new Contact("vianey","","","","","","",R.drawable.img));
        listContact.add(new Contact("hach","","","","","","",R.drawable.img));
        listContact.add(new Contact("rfrrf","","","","","","",R.drawable.img));
        listContact.add(new Contact("rfrrf","","","","","","",R.drawable.img));
        listContact.add(new Contact("rfrrf","","","","","","",R.drawable.img));
        listContact.add(new Contact("rfrrf","","","","","","",R.drawable.img));
        listContact.add(new Contact("rfrrf","","","","","","",R.drawable.img));
        listContact.add(new Contact("rfrrf","","","","","","",R.drawable.img));
        listContact.add(new Contact("rfrrf","","","","","","",R.drawable.img));


    }


}