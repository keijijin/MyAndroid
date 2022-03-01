package com.sample.myinputs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.sample.myinputs.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.chk.setOnCheckedChangeListener((buttonView, isChecked) ->{
            Toast.makeText(MainActivity.this,
                    isChecked ? R.string.mailOn : R.string.mailOff,
                    Toast.LENGTH_SHORT).show();
        });

        binding.toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(MainActivity.this,
                    isChecked ? R.string.mailOn : R.string.mailOff,
                    Toast.LENGTH_SHORT).show();
        });

        binding.sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(MainActivity.this,
                    isChecked ? R.string.sayYes : R.string.sayNo,
                    Toast.LENGTH_SHORT).show();
        });

        binding.rgroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radio = group.findViewById(checkedId);
            Toast.makeText(MainActivity.this,
                    String.format("「%s」が選択されました。", radio.getText().toString()),
                    Toast.LENGTH_SHORT).show();
        });

        binding.seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
             }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,
                        String.format("現在値：%d", seekBar.getProgress()),
                        Toast.LENGTH_SHORT).show();
            }
        });

        createSpinner();

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner sp = (Spinner) adapterView;
                Toast.makeText(MainActivity.this,
                        String.format("選択項目：%s", sp.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void createSpinner() {
        ArrayList<String> list = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN);
        Calendar cal = Calendar.getInstance();
        for(int i = 0; i < 10; i++) {
            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
            list.add(format.format(cal.getTime()));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, list);
        binding.spinner.setAdapter(adapter);
    }
}