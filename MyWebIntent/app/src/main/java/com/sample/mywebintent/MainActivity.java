package com.sample.mywebintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnSend);
        button.setOnClickListener(v -> {
            EditText txtKeywd = findViewById(R.id.txtUrl);
            /*
            startActivity(
                    new Intent(
                            Intent.ACTION_SENDTO,
                            Uri.parse(txtUrl.getText().toString())
                    )
            );
             */
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, txtKeywd.getText().toString());
            startActivity(intent);
        });
    }
}