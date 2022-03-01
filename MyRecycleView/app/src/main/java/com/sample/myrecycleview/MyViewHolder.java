package com.sample.myrecycleview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    View view;
    TextView title;
    TextView tag;
    TextView desc;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
        this.title = view.findViewById(R.id.titleView);
        this.tag = view.findViewById(R.id.tagView);
        this.desc = view.findViewById(R.id.descView);
    }
}
