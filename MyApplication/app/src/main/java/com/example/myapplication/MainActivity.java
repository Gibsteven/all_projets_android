package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        editText = findViewById(R.id.editText);

        webView.setWebViewClient(new WebViewClient());
        webView .setWebChromeClient(new WebChromeClient());

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String text = editText.getText().toString();
                if (!TextUtils.isEmpty(text)){
                    if (Patterns.WEB_URL.matcher(text).matches())
                    {
                        loadUrl(text);
                    }else {
                        performSearch(text);
                    }
                }
                return false;
            }
        });
    }

    private void performSearch(String text) {
        String searchURl = "https://www.google.com/search?q=";
        webView.loadUrl(text);
    }

    private void loadUrl(String text)
    {
        if (text.startsWith("https://")||text.startsWith("http://")){
            webView.loadUrl(text);
        }else{
            webView.loadUrl("http://"+text);
        }
    }
}