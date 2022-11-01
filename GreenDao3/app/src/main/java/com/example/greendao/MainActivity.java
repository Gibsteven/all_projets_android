package com.example.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper DatabaseHelper;
    Button btnAdd;
     Button btnViewData;
     EditText editText;
    EditText editText1;
    ListView listView;
    TextView textView;
    //String time;
  //  Calendar calendar;
    DaoMaster master;
    DaoSession session;
    UsersDao usersDao;


    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText1);
        btnAdd = findViewById(R.id.btnAdd);
        btnViewData = findViewById(R.id.btnView);
        DatabaseHelper = new DatabaseHelper(MainActivity.this);
        listView = findViewById(R.id.list_view);
        arrayList = DatabaseHelper.getText();
       textView =findViewById(R.id.textView);
        //calendar = Calendar.getInstance();

        ////////////

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"Database_name");
        Database db = helper.getWritableDb();
        session = new DaoMaster(db).newSession();
        usersDao = session.getUsersDao();

        ///////////////////////

       /// §§§§§§§§§§§§§§§*******Time*****§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§

        //time = pad(calendar.get(Calendar.HOUR))+":"+pad(calendar.get(Calendar.MINUTE));
        //textView.setText(time);


        ///§§§§§§§§§§§§§§§*******Time*****§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§

        arrayAdapter = new ArrayAdapter(MainActivity.this,
            android.R.layout.simple_spinner_item,arrayList);
        listView.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                String text1 = editText1.getText().toString();

              //  ***********************************************
                Users  users = new Users();
                users.setNom(text);
                usersDao.insert(users);
             //   ***********************************************


                if (!text.isEmpty())
                {
                    if (DatabaseHelper.addText(text))
                    {
                        editText.setText("");
                        Toast.makeText(MainActivity.this, "Data Inserted...", Toast.LENGTH_SHORT).show();
                        arrayAdapter.clear();
                        arrayList.addAll(DatabaseHelper.getText());
                        arrayAdapter.notifyDataSetChanged();
                        listView.invalidateViews();
                        listView.refreshDrawableState();
                    }
                }

                //
                if (!text1.isEmpty())
                {
                    if (DatabaseHelper.addText(text1))
                    {
                        editText1.setText("");
                        Toast.makeText(MainActivity.this,"Data Inserted...", Toast.LENGTH_SHORT).show();
                        arrayAdapter.clear();
                        arrayList.addAll(DatabaseHelper.getText());
                        arrayAdapter.notifyDataSetChanged();
                        listView.invalidateViews();
                        listView.refreshDrawableState();
                    }
                }
            }
        });
    }

    public String pad(int i) {
        if ( i<0 ){
            return "0"+1;
        }
        return String.valueOf(i);
    }
}