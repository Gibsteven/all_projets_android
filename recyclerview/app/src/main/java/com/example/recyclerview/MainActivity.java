package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass>userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();

    }

    private void initData() {

        userList = new ArrayList<>();
        userList.add(new ModelClass(R.drawable.logo,"Anjali","10:45 Am","How are you?","____________"));
        userList.add(new ModelClass(R.drawable.logo1,"johny Tout pour la qualité","11:45 Am","I am fine!","____________"));
        userList.add(new ModelClass(R.drawable.logo2,"Mariam Tout pour la qualité","11:45 Am","How are you?","____________"));
        userList.add(new ModelClass(R.drawable.logo3,"browny","11:45 Am","I am fine!","____________"));

    }

    private void initRecyclerView(){

        recyclerView=findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}