package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // ** INITIALISATION des differentes variables ** //

    private Button connect_btn;
    private EditText et_edit;
    private TextView TextError;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ** ATTRIBUTION des differentes fonctions au variable initialisées **//

        TextError =(TextView) findViewById(R.id.TextError);
        connect_btn = (Button) findViewById(R.id.connect_btn);
        et_edit = (EditText) findViewById(R.id.et_edit);
        et_edit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view)
            {
                TextError.setVisibility(View.INVISIBLE);
            }
        });
        connect_btn.setOnClickListener(new View.OnClickListener()
        {
            // ** CONDITION d'entrée de texte ** //
            @Override
            public void onClick(View view)
            {

                if (et_edit.getText().toString().length() > 0 )
                {
                    Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                    String url = et_edit.getText().toString();
                    intent.putExtra("ref",url);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_right,R.anim.slide_right);
                }
                // ** (CONDITION-ACTION) pour qu'au cas où aucuns n'ai été Entré ** //
                else
                {
                    TextError.setText("Error, nothing word input");
                    TextError.setTextColor(Color.RED);
                    TextError.setVisibility(View.VISIBLE);
                }
            }

        });
    }


    //  ** Les differents options pour le plein d'ecran dans le WebView ** //

    private int hideSystemBars()

    {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    // ** L_option code de retour entre les differentes Activitées Principales **//

    @Override
    public void onBackPressed()

    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}