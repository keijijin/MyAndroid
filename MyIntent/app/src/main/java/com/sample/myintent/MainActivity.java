package com.sample.myintent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.sample.myintent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("LIFE", "onCreate");
/*
        ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if(result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        if(intent != null) {
                            String txtName = intent.getStringExtra("txtName");
                            Toast.makeText(MainActivity.this,
                                    String.format("こんにちは、%sさん！", txtName),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
 */
        binding.btn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, binding.txtName.getText().toString());
            startActivity(intent);
            //startForResult.launch(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFE", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFE", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFE", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFE", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFE", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFE", "onRestart");
    }
}