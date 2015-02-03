package com.tonyjs.basicrecyclerview.example.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.tonyjs.basicrecyclerview.adapter.BasicRecyclerAdapter;
import com.tonyjs.basicrecyclerview.adapter.viewholder.BasicViewHolder;
import com.tonyjs.basicrecyclerview.example.adapter.holder.ItemHolder;
import com.tonyjs.basicrecyclerview.example.model.Item;

/**
 * Created by tony on 14. 12. 31..
 */
public class SimpleItemAdapter extends BasicRecyclerAdapter<Item>{
    public SimpleItemAdapter(Context context) {
        super(context);
    }

    @Override
    public BasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ItemHolder.getViewHolder(getContext(), parent);
    }
}
