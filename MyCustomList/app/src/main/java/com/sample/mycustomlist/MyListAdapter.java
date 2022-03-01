package com.sample.mycustomlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListItem> data;
    private int resource;
    private LayoutInflater inflater;

    public MyListAdapter(Context context, ArrayList<ListItem> data, int resource) {
        this.context = context;
        this.data = data;
        this.resource = resource;
        inflater = (LayoutInflater) this.context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public ListItem getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ListItem item = (ListItem) getItem(position);
        View sview = (convertView != null) ? convertView : inflater.inflate(resource, null);
        ((TextView) sview.findViewById(R.id.titleView)).setText(item.getTitle());
        ((TextView) sview.findViewById(R.id.tagView)).setText(item.getTag());
        ((TextView) sview.findViewById(R.id.descView)).setText(item.getDesc());
        return sview;
    }
}
