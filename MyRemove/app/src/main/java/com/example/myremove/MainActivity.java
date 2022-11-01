package com.example.myremove;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private EditText et_text;
    private EditText et_text1;
    private Button button;
    private TextView textView;
    private TextView title;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_text1 = (EditText) findViewById(R.id.et_text1);
        title = (TextView) findViewById(R.id.title);
        textView = (TextView) findViewById(R.id.textView);
        et_text = (EditText) findViewById(R.id.et_text);
        button = (Button) findViewById(R.id.button);
        et_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.INVISIBLE);
            }
        });
            button.setOnClickListener(new View.OnClickListener() {
            //
            @Override
            public void onClick(View view) {

                if(et_text.getText().toString().length() > 0 )
                {
                    int url = et_text.getInputType();
                    int url1 = et_text1.getInputType();
                    int i = url + url1;
                    title.setText(i);

                }
                else
                {
                    textView.setText("Error, nothing word input");
                    textView.setTextColor(Color.RED);
                    textView.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Error, nothing word input", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
   public void openWebview()
   {
       Intent intent = new Intent(this,Webview.class);
       startActivity(intent);
   }
}