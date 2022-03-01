package com.sample.mylistbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.sample.mylistbasic.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final ArrayList<String> data = new ArrayList<>();
        data.add("胡椒");
        data.add("ターメリック");
        data.add("コリアンダー");
        data.add("生姜");
        data.add("ニンニク");
        data.add("サフラン");
        data.add("オレガノ");
        data.add("クミン");
        data.add("グローブ");
        data.add("シナモン");
        data.add("ナツメグ");
        data.add("セージ");
        data.add("タイム");
        data.add("パクチー");
        data.add("カモミール");
        data.add("バジル");
        data.add("パプリカ");
        data.add("マスタード");
        data.add("レモングラス");
        data.add("ローズマリー");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, data);
        binding.listView.setAdapter(adapter);

        binding.listView.setTextFilterEnabled(true);

        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(s == null || s.equals("")) {
                    binding.listView.clearTextFilter();
                } else {
                    binding.listView.setFilterText(s);
                }
                return false;
            }
        });

        binding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.remove(((TextView)view).getText().toString());
                return false;
            }
        });

        binding.listView.setOnItemClickListener((av,view,n,l)->{
            displaySelectedItems();
        });
        
        binding.listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                displaySelectedItems();
            }
        });

        binding.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView,
                                 int firstVisibleItem,
                                 int visibleItemCount,
                                 int totalItemCount) {
                if(firstVisibleItem + visibleItemCount + 3 > totalItemCount) {
                    adapter.add("新　胡椒");
                    adapter.add("新　ターメリック");
                    adapter.add("新　コリアンダー");
                }
            }
        });
    }

    private void displaySelectedItems() {
        String msg = "選択したのは、";
        for(int i = 0; i < binding.listView.getChildCount(); i++) {
            CheckedTextView check = (CheckedTextView) binding.listView.getChildAt(i);
            if(check.isChecked()) {
                msg += check.getText() + ", ";
            }
        }
        msg = msg.substring(0, msg.length() - 2);
        msg += "です。";
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}