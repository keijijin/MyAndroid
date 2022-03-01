package com.sample.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sample.mywebview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnHome.setOnClickListener(view -> {
            binding.wv.loadUrl(getString(R.string.web_home));
        });

        binding.btnEnv.setOnClickListener(view -> {
            binding.wv.loadUrl(getString(R.string.web_env));
        });

        binding.btnPub.setOnClickListener(view -> {
            binding.wv.loadUrl(getString(R.string.web_pub));
        });
    }
}