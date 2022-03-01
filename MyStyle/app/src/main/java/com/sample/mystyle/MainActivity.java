package com.sample.mystyle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(com.google.android.material.R.style.Theme_MaterialComponents);
        setContentView(R.layout.activity_main);
    }
}