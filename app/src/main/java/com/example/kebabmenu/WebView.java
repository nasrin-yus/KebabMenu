package com.example.kebabmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        android.webkit.WebView web=findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://www.bbc.com/news");
    }
}