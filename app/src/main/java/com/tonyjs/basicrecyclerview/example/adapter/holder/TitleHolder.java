package com.tonyjs.basicrecyclerview.example.adapter.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tonyjs.basicrecyclerview.adapters.viewholders.BasicViewHolder;
import com.tonyjs.basicrecyclerview.example.R;

/**
 * Created by tony on 14. 12. 31..
 */
public class TitleHolder extends BasicViewHolder<String> {
    public static TitleHolder getViewHolder(Context context, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new TitleHolder(context, inflater.inflate(R.layout.row_title, parent, false));
    }

    TextView mTvTitle;
    public TitleHolder(Context context, View itemView) {
        super(context, itemView);
        mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    public void onBindView(String item) {
        mTvTitle.setText("Type : " + item);
    }
}
