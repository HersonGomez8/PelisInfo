package com.hersongomez.pelisinfo.mvp.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.hersongomez.pelisinfo.R;
import com.hersongomez.pelisinfo.mvp.view.Cartelera;

public class MainActivity extends AppCompatActivity {

    //Variable con tiempo de duración de 3 seg en el splash
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Tiempo de espera en el splash
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Cartelera.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}