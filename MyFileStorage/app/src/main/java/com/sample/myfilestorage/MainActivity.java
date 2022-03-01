package com.sample.myfilestorage;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.sample.myfilestorage.databinding.ActivityMainBinding;

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

        ActivityResultLauncher<Intent> forResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    Intent intent = result.getData();
                    if(intent != null) {
                        Uri title = intent.getData();
                        if(intent != null && result.getResultCode() == RESULT_OK) {
                            StringBuilder str = new StringBuilder();
                            try(BufferedReader reader = new BufferedReader(
                                    new InputStreamReader(
                                            getContentResolver().openInputStream(title)))) {
                                String line;
                                while((line = reader.readLine()) != null) {
                                    str.append(line);
                                    str.append(System.getProperty("line.separator"));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            binding.txtMemo.setText(str.toString());
                        }
                    }
                });
        Intent is = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        is.setType("text/plain");
        is.putExtra(Intent.EXTRA_TITLE, "memo.txt");
        forResult.launch(is);

        ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    Intent intent = result.getData();
                    if (intent != null) {
                        Uri title = intent.getData();
                        if(title != null && result.getResultCode() == RESULT_OK) {
                            try(BufferedWriter writer = new BufferedWriter(
                                    new OutputStreamWriter(
                                            getContentResolver().openOutputStream(title)))) {
                                writer.write(binding.txtMemo.getText().toString());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

        binding.btnSave.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TITLE, "memo.txt");
            startForResult.launch(intent);
        });
    }
}