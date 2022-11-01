package com.example.myfirsttest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //DaoMaster master;
    DaoSession session;
    UsersDao usersDao;
    TextView tv1,tv2;
    EditText edit,edit1;
    Button btn;
            @SuppressLint("MissingInflatedId")
            @Override
            protected void onCreate(Bundle savedInstanceState) {

                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);
                tv1 = findViewById(R.id.tv1);
                tv2=findViewById(R.id.tv2);
                btn = findViewById(R.id.btn);
                edit = findViewById(R.id.edit);
                edit1 = findViewById(R.id.edit1);

                      DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"Database_name");
                      Database db = helper.getWritableDb();
                     session = new DaoMaster(db).newSession();
                     usersDao = session.getUsersDao();

                     btn.setOnClickListener(view -> {

                         Users  users = new Users();
                         String nom = edit.getText().toString().trim();
                         String prenom = edit1.getText().toString().trim();
                         users.setNom(nom);
                         users.setPrenom(prenom);
                         usersDao.insert(users);

                         List<Users> us=  usersDao.loadAll();


                         for (Users get:us){

                             tv1.setText(get.getNom());
                             tv2.setText(get.getPrenom());

//                             Intent i = new Intent(getApplicationContext(),MainActivity2.class);
           //                  startActivity(i);
                         }
                     });
                }
}