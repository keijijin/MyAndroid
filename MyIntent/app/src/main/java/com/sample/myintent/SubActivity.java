package com.sample.myintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sample.myintent.databinding.ActivityMainBinding;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        findViewById(R.id.btn2).setOnClickListener(v -> {
            Intent intent = new Intent();
            EditText editText = findViewById(R.id.txtName2);
            intent.putExtra("txtName", editText.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });

        String txtName = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        Toast.makeText(this,
                String.format("こんにちは、%sさん！", txtName),
                Toast.LENGTH_SHORT).show();

        Log.d("LIFE", "sub_onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFE", "sub_onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFE", "sub_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFE", "sub_onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFE", "sub_onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFE", "sub_onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFE", "sub_onRestart");
    }
}
