package com.tonyjs.basicrecyclerview.example.adapter.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tonyjs.basicrecyclerview.adapters.viewholders.BasicViewHolder;
import com.tonyjs.basicrecyclerview.example.R;
import com.tonyjs.basicrecyclerview.example.model.Item;

/**
 * Created by tony on 14. 12. 29..
 */
public class ProgressHolder extends BasicViewHolder<Item> {

    public static ProgressHolder getViewHolder(Context context, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ProgressHolder(context, inflater.inflate(R.layout.item_progress, parent, false));
    }

    private ProgressHolder(Context context, View itemView) {
        super(context, itemView);
    }

}
