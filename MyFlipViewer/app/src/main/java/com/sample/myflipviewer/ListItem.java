package com.sample.myflipviewer;

import android.graphics.drawable.Drawable;

public class ListItem {
    private String title;
    private String shortTitle;
    private Drawable icon;
    private Drawable photo;

    public ListItem(String title, String shortTitle, Drawable icon, Drawable photo) {
        this.title = title;
        this.shortTitle = shortTitle;
        this.icon = icon;
        this.photo = photo;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getPhoto() {
        return photo;
    }
}
