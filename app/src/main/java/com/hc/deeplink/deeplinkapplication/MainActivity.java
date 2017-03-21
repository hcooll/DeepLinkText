package com.hc.deeplink.deeplinkapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import static com.hc.deeplink.deeplinkapplication.R.id.webview;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private Button mButton1;
    private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(webview);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);

        loadHtml();

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String jsStr = "javascript:getAndroidShareContent()";

                mWebView.loadUrl(jsStr);

            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String jsStr = "javascript:postMessage(\"" + "哈哈" + "\")";

                mWebView.loadUrl(jsStr);

            }
        });
    }

    public void loadHtml() {
//        WebView webview = new WebView(this);
//        webview.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
//        mWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;
//            }
//
//            @Override
//            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
//                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setMessage("Ssl cert invalid");
//                builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        handler.proceed();
//                    }
//                });
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        handler.cancel();
//                    }
//                });
//                final AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        });
        mWebView.addJavascriptInterface(this, "android");
        WebSettings wSet = mWebView.getSettings();
        wSet.setJavaScriptEnabled(true);
        wSet.setJavaScriptCanOpenWindowsAutomatically(true);

        wSet.setUserAgentString("");
        wSet.setJavaScriptEnabled(true);
        wSet.setDomStorageEnabled(true);      // 启用localStorage 和 essionStorage，相当于Android的SharePreference
        wSet.setDatabaseEnabled(true);        // 启用Webdatabase数据库
        wSet.setSupportZoom(true);
        wSet.setBuiltInZoomControls(true);   // 设置可以支持缩放
        wSet.setDisplayZoomControls(false);   // 隐藏缩放按钮
        wSet.setUseWideViewPort(true);        //设置可在大视野范围内上下左右拖动，并且可以任意比例缩放
        wSet.setLoadWithOverviewMode(true);   //此属性为true表示用尽可能大的视野展示页面，一般和上一属性搭配使用。

//        mWebView.loadUrl("file:///android_asset/lucky_bag_test.html");
        mWebView.loadUrl("file:///android_asset/deeplink_test.html");
//        mWebView.loadUrl("file:///android_asset/js_test.html");
//        mWebView.loadUrl("http://kitty.live/agreement/luckybag_en.html");
//        setContentView(webview);
    }

    @JavascriptInterface
    public void share(String message, String message2,String message3,String message4) {
        Toast.makeText(this," 1: "+ message + " 2: " + message2 + " 3: " + message3+ " 4: " + message4, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void postMessage(String message) {
        Toast.makeText(this, "postMessage-->>" + message, Toast.LENGTH_SHORT).show();
    }
}
