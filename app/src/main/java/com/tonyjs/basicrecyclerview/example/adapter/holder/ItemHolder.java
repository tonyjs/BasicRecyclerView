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
public class ItemHolder extends BasicViewHolder<Item> {

    public static ItemHolder getViewHolder(Context context, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ItemHolder(context, inflater.inflate(R.layout.row_item, parent, false));
    }

    TextView mTvType;
    TextView mTvTitle;

    private ItemHolder(Context context, View itemView) {
        super(context, itemView);
        mTvType = (TextView) itemView.findViewById(R.id.tv_type);
        mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    public void onBindView(Item item) {
        mTvType.setText(Integer.toString(getPosition()));
        mTvTitle.setText(item.getTitle());
    }
}
