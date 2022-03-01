package com.sample.myconvinient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.sample.myconvinient.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.rating.setOnRatingBarChangeListener(((ratingBar, rating, fromUser) -> {
            ratingBar.setContentDescription(Float.toString(rating));
            Toast.makeText(MainActivity.this,
                    String.format("現在の評価は、%fです。", rating),
                    Toast.LENGTH_SHORT).show();
        }));
    }
}