package com.sample.myflipviewer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView txtTitle;
    private ImageView imgPhoto;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        imgPhoto = itemView.findViewById(R.id.imgPhoto);
    }

    public TextView getTxtTitle() {
        return txtTitle;
    }

    public ImageView getImgPhoto() {
        return imgPhoto;
    }
}
