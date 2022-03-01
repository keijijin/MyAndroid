package com.sample.mydatepick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(view -> {
            MyDialogFragment myDiaog = new MyDialogFragment();
            myDiaog.show(getSupportFragmentManager(), "datepick_dialog");
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(view -> {
            MyTimeDialogFragment myTimeDialog = new MyTimeDialogFragment();
            myTimeDialog.show(getSupportFragmentManager(), "timepick_dialog");
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(view -> {
            MyCustomDialogFragment myCustomDialog = new MyCustomDialogFragment();
            EditText txtName = findViewById(R.id.txtName);
            Bundle args = new Bundle();
            args.putString("txtName", txtName.getText().toString());
            myCustomDialog.setArguments(args);
            myCustomDialog.show(getSupportFragmentManager(), "custom_dialog");
        });
    }
}