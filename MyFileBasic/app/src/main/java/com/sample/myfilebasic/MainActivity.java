package com.sample.myfilebasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.sample.myfilebasic.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        StringBuilder str = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(
                openFileInput("memo.dat")))) {
            String line;
            while((line = reader.readLine()) != null) {
                str.append(line);
                str.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        binding.txtMemo.setText(str.toString());

        binding.btnSave.setOnClickListener(view -> {
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            openFileOutput("memo.dat", Context.MODE_PRIVATE)))) {
                writer.write(binding.txtMemo.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}