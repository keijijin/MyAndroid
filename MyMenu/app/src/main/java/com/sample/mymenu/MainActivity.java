package com.sample.mymenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerForContextMenu(findViewById(R.id.constraint));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.option_menu, menu);
        menu.add(0,0,0,"Home").setIcon(R.drawable.menu1);
        SubMenu sm1 = menu.addSubMenu(0,1,1,"Help").setIcon(R.drawable.menu2);
        sm1.add(0,2,0,"Search").setIcon(R.drawable.menu3);
        sm1.add(0,3,1,"Import").setIcon(R.drawable.menu4);
        sm1.add(0,4,2,"Export").setIcon(R.drawable.menu5);
        sm1.add(0,5,3,"Version").setIcon(R.drawable.menu6);
        SubMenu sm2 = menu.addSubMenu(0,6,2,"Config").setIcon(R.drawable.menu7);
        sm2.add(0,7,0,"Brightness").setIcon(R.drawable.menu8);
        sm2.add(0,8,1,"Volume").setIcon(R.drawable.menu9);
        sm2.add(0,9,2,"Crypt").setIcon(R.drawable.menu10);
        menu.add(0,10,3,"TrashBox").setIcon(R.drawable.menu11);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast toast = Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT);
        toast.show();
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.option_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,
                item.getTitle(),
                Toast.LENGTH_LONG).show();
        return true;
    }
}