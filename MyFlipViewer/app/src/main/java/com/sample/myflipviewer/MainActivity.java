package com.sample.myflipviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ListItem> data = new ArrayList<>();
        data.add(new ListItem("街を走る電車","電車",
                ContextCompat.getDrawable(this, R.drawable.tab_icon1),
                ContextCompat.getDrawable(this, R.drawable.train)));
        data.add(new ListItem("我が家のおじさん猫", "猫",
                ContextCompat.getDrawable(this, R.drawable.tab_icon2),
                ContextCompat.getDrawable(this, R.drawable.cat)));
        data.add(new ListItem("咲き乱れる花々", "花",
                ContextCompat.getDrawable(this, R.drawable.tab_icon3),
                ContextCompat.getDrawable(this, R.drawable.flower)));

        TabLayout tabs = findViewById(R.id.tabs);
        ViewPager2 pager = findViewById(R.id.pager);
        pager.setAdapter(new MyListAdapter(data));
        new TabLayoutMediator(tabs, pager, (tab, position) -> {
            tab.setText(data.get(position).getShortTitle());
            tab.setContentDescription("Page "+ (position+1));
            tab.setIcon(data.get(position).getIcon());
        }).attach();
    }
}