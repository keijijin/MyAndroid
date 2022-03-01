package com.sample.mycustomlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.sample.mycustomlist.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] titles = {"革命のエチュード", "G線上のアリア", "シャコンヌ", "夜の女王のアリア", "春の海"};
        String[] tags = {"ピアノ", "バイオリン", "チェロ", "声楽", "箏"};
        String[] descs = {"ピアノの詩人と言われたショパンの代表的なピアノ曲です。",
                "バッハの作品。バイオリンのG線上のみで演奏できることからこのタイトルで親しまれています。",
                "バッハの作品。パルティータ第２番の終曲です。",
                "モーツアルト作曲のオペラ「魔笛」の中のアリアです。",
                "宮城道雄の作品です。曲の舞台は鞆の浦と言われています。"};
/*        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        for(int i = 0; i < titles.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("title", titles[i]);
            item.put("tag", tags[i]);
            item.put("desc", descs[i]);
            data.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item,
                new String[] {"title","tag","desc"},
                new int[]{R.id.titleView, R.id.tagView, R.id.descView});
        binding.listView.setAdapter(adapter);

 */
        ArrayList<ListItem> data = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            ListItem item = new ListItem();
            item.setId((new Random()).nextLong());
            item.setTitle(titles[i]);
            item.setTag(tags[i]);
            item.setDesc(descs[i]);
            data.add(item);
        }

        MyListAdapter adapter = new MyListAdapter(this, data, R.layout.list_item);
        binding.listView.setAdapter(adapter);
    }
}