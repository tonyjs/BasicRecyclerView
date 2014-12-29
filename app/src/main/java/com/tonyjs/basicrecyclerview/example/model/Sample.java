package com.tonyjs.basicrecyclerview.example.model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by tony on 14. 12. 29..
 */
public class Sample {
    public static final String[] DATA =
            ("allin ball calculator dog facebook google hashtagram instagram jake wharton"
                    + " korea lolipop man nineold orc pushbullet quip recyclerview sliplayout trello"
                    + " umano vingle wechat xiaomi youtube zxing").split(" ");

    public static ArrayList<Item> getItems(int startIndex) {
        ArrayList<Item> items = new ArrayList<>();

        for (int i = startIndex; i < startIndex + 20; i++) {
            int type = (int) (Math.random() * 3);
            Log.e("jsp", "type = " + type);
            Item item = new Item();
            item.setType(type);
            int rand = (int) (Math.random() * DATA.length);
            item.setTitle(DATA[rand]);
            items.add(item);
        }

        return items;
    }
}
