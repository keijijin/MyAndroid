package com.sample.myflipviewer;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<ListItem> data;

    public MyListAdapter(List<ListItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.getTxtTitle().setText(data.get(position).getTitle());
        holder.getImgPhoto().setImageDrawable(data.get(position).getPhoto());
        holder.getImgPhoto().setContentDescription(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
