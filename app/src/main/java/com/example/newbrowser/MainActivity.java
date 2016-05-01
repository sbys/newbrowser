package com.example.newbrowser;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
  WebView webView;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pb=(ProgressBar)findViewById(R.id.progressbar);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.baidu.com/");
        webView.setWebViewClient(new WebViewClient(){
            public void onPageStarted(WebView view,String url, Bitmap favicon){
                super.onPageStarted(view,url,favicon);
                pb.setVisibility(View.VISIBLE);
            }
            public void onPageFinished(WebView view,String url){
                super.onPageFinished(view, url);
                pb.setVisibility(View.GONE);
            }
            public void onReceivedError(WebView view, int errorCode,String des,String failurl){
                super.onReceivedError(view,errorCode,des,failurl);
                pb.setVisibility(View.GONE);
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
     public boolean onKeyDown(int keycode,KeyEvent event){
        if(keycode==KeyEvent.KEYCODE_BACK){
            webView.goBack();
            return  true;
        }
        return super.onKeyDown(keycode,event);
    }

}