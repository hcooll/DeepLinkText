package com.hc.deeplink.deeplinkapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

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
//        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;
//            }
//        });
        WebSettings wSet = webview.getSettings();
        wSet.setJavaScriptEnabled(true);
        wSet.setJavaScriptCanOpenWindowsAutomatically(true);
        webview.loadUrl("file:///android_asset/deeplink_test.html");
        setContentView(webview);
    }
}
