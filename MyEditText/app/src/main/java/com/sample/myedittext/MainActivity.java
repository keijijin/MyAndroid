package com.sample.myedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sample.myedittext.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(view -> {
            EditText txtName = findViewById(R.id.txtName);
            TextView textResult = findViewById(R.id.textResult);
            textResult.setText(String.format("こんにちは、%sさん！", txtName.getText().toString()));
        });

 */
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnSend.setOnClickListener(view -> binding.textResult.setText(String.format(getString(R.string.greet, binding.txtName.getText().toString()))));
    }
}