package com.sample.mydialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;

import com.sample.mydialog.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn.setOnClickListener(view -> {
            DialogFragment dialog = new MyFialogFragment();
            Bundle args = new Bundle();
            args.putString("txtName", binding.txtName.getText().toString());
            dialog.setArguments(args);
            dialog.show(getSupportFragmentManager(), "dialog_basic");
        });
    }
}