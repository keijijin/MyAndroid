package com.sample.myrecycleview;

public class ListItem {
    private long id = 0;
    private String title = null;
    private String tag = null;
    private String desc = null;

    public ListItem(long id, String title, String tag, String desc) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.desc = desc;
    }

    public ListItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
