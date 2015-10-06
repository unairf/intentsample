package com.unairf.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private TextView textview;
    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void abrirVentana(View v) {
        edittext = (EditText)findViewById(R.id.editText);


        Intent intent = new Intent(this,NuevaVentana.class);
        intent.putExtra("url",edittext.getText().toString());
        startActivityForResult(intent, 666);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textview = (TextView)findViewById(R.id.textview3);
        textview.setText(data.getStringExtra("newUrl"));
        final MediaPlayer rammingSpeed = MediaPlayer.create(this, R.raw.speed);
        TextView textview;
        textview = (TextView)findViewById(R.id.textview5);
        textview.setText("El enlace que has devuelto es: ");
        rammingSpeed.start();

    }
}
