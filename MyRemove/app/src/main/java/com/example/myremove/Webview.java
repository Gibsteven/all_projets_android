package com.example.myremove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {
    private View decorView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        webView = (WebView) findViewById(R.id.webView);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        decorView = getWindow().getDecorView();

        Bundle res = getIntent().getExtras();
        String val= res.get("ref").toString();
        webView.loadUrl(val);
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {
            @Override
            public void onSystemUiVisibilityChange(int visibility)
            {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
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
    private class Callback extends WebViewClient
    {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event)
        {
            return false;
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

    int counter = 0;

    @Override
    public void onBackPressed()

    {
        counter++;
        if(counter == 1)
        {
            Intent i =new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
        else
        {
            super.onBackPressed();
        }
    }
    private void openActivity()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}