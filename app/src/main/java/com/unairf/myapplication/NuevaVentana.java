package com.unairf.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

public class NuevaVentana extends AppCompatActivity {
    private WebView webview;
    private FloatingActionButton floating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_ventana);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setTitle("Elige una web y pulsa el botón");


        String url = getIntent().getStringExtra("url");


        //sdsds

        webview = (WebView)findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
                devolverUrl(view);

            }
        });
    }

    public void devolverUrl(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("newUrl", webview.getUrl());
        setResult(RESULT_OK, intent);
        finish();

    }


}
