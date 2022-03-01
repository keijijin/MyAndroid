package com.sample.mytablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFlag = findViewById(R.id.btnFlag);
        btnFlag.setOnClickListener(view -> {
            TableLayout tbl = findViewById(R.id.tbl);
            tbl.setColumnCollapsed(1,flag);
            flag = !flag;
        });
    }
}