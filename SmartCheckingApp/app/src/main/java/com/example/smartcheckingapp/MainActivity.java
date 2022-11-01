package com.example.smartcheckingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btn_connect;
    private EditText mail,pw;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = (EditText) findViewById(R.id.mail);
        pw = (EditText) findViewById(R.id.pw);
        btn_connect = (Button) findViewById(R.id.btn_connect);
        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
                //mail.getText().toString().length()>0 && pw.getText().toString().length()>0
                if (mail.getText().toString().contentEquals("steven@gmail.com") && pw.getText().toString().contentEquals("oub"))
                {
                    //Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                    String Inpmail = mail.getText().toString();
                    i.putExtra("mail",Inpmail);
                    String InpPw = pw.getText().toString();
                    i.putExtra("pw",InpPw);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Remplissage obligatoire des champs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}