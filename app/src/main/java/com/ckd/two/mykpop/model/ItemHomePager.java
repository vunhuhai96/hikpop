package com.ckd.two.mykpop.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ItemHomePager {
    private String image;
    private String name;

    public ItemHomePager() {
    }

    public ItemHomePager(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
