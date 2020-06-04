package com.example.myapplication.Modules.Mine.Setting;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class SettingItemModel implements MultiItemEntity {
    private int type;
    private String text;

    public SettingItemModel(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public int getItemType() {
        return type;
    }
}
