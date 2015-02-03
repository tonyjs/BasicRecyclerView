package com.tonyjs.basicrecyclerview.example.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.tonyjs.basicrecyclerview.adapter.MultiRecyclerAdapter;
import com.tonyjs.basicrecyclerview.adapter.viewholder.BasicViewHolder;
import com.tonyjs.basicrecyclerview.example.adapter.holder.ItemHolder;
import com.tonyjs.basicrecyclerview.example.adapter.holder.TitleHolder;
import com.tonyjs.basicrecyclerview.example.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tony on 14. 12. 29..
 */
public class MultiItemAdapter extends MultiRecyclerAdapter {

    public static final int VIEW_TYPE_TITLE = 0;
    public static final int VIEW_TYPE_ITEM = 1;

    public MultiItemAdapter(Context context) {
        super(context);
    }

    @Override
    public BasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_TITLE:
                return TitleHolder.getViewHolder(getContext(), parent);
            default:
                return ItemHolder.getViewHolder(getContext(), parent);
        }
    }

    public void setItems(List<Item> items) {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item lhs, Item rhs) {
                return lhs.getType() < rhs.getType() ? -1 : +1;
            }
        });

        ArrayList<Row> rows = getRows(items);
        setRows(rows);
    }

    public ArrayList<Row> getRows(List<Item> items) {
        ArrayList<Row> rows = new ArrayList<>();

        int max = items.size();

        Item lastItem = items.get(0);
        int lastItemType = lastItem.getType();
        rows.add(getRow(Integer.toString(lastItemType), VIEW_TYPE_TITLE));
        rows.add(getRow(lastItem, VIEW_TYPE_ITEM));
        if (max <= 1) {
            return rows;
        }

        for (int i = 1; i < max; i++) {
            Item item = items.get(i);
            int itemType = item.getType();

            if (itemType != lastItemType) {
                rows.add(getRow(Integer.toString(itemType), VIEW_TYPE_TITLE));
            }
            rows.add(getRow(item, VIEW_TYPE_ITEM));

            lastItemType = itemType;
        }

        return rows;
    }

}
