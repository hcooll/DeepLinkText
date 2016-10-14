package com.hc.deeplink.deeplinkapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        loadHtml();
    }

    public void loadHtml()
    {
        WebView webview = new WebView(this);
//        webview.setWebViewClient(new WebViewClient());
        WebSettings wSet = webview.getSettings();
        wSet.setJavaScriptEnabled(true);
        webview.loadUrl("file:///android_asset/deeplink_test.html");
        setContentView(webview);
    }
}
