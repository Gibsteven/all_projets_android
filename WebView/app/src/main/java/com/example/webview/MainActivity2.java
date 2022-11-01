package com.example.webview;

import static java.nio.file.Paths.get;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
{
    // ** DECLARATION des differentes variables ** //

    private WebView webView;
    private View decorView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        // ** ATTRIBUTION des differentes fonctions au variable initialisées **//

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        decorView = getWindow().getDecorView();
        overridePendingTransition(R.anim.slide_left,R.anim.slide_left);
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {
            @Override
            public void onSystemUiVisibilityChange(int visibility)
            {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });


        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());


        Bundle res = getIntent().getExtras();
        String val= res.getString("ref");
        webView.loadUrl(val);


    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
        {
            decorView.setSystemUiVisibility(hideSystemBars());
        }

    }

    private int hideSystemBars()
    {

            return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
    }