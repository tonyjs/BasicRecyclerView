package com.tonyjs.basicrecyclerview.example.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.tonyjs.basicrecyclerview.adapters.BasicRecyclerAdapter;
import com.tonyjs.basicrecyclerview.adapters.viewholders.BasicViewHolder;
import com.tonyjs.basicrecyclerview.example.adapter.holder.ItemHolder;
import com.tonyjs.basicrecyclerview.example.adapter.holder.ProgressHolder;
import com.tonyjs.basicrecyclerview.example.model.Item;

/**
 * Created by tony on 14. 12. 29..
 */
public class InfiniteItemAdapter extends BasicRecyclerAdapter<Item>{
    public interface OnReachDownListener {
        public void onReachDown();
    }

    public static final int VIEW_TYPE_ITEM = 0;
    public static final int VIEW_TYPE_PROGRESS = 1;

    public InfiniteItemAdapter(Context context) {
        super(context);
    }

    private OnReachDownListener mOnReachDownListener;

    public void setOnReachDownListener(OnReachDownListener onReachDownListener) {
        mOnReachDownListener = onReachDownListener;
    }

    @Override
    public BasicViewHolder getViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_PROGRESS:
                return ProgressHolder.getViewHolder(getContext(), parent);
            default:
                return ItemHolder.getViewHolder(getContext(), parent);
        }
    }

    @Override
    public void onBindViewHolder(BasicViewHolder viewHolder, int position) {
        viewHolder.onBindView(getItem(position));
        int size = getItems().size();
        if (mOnReachDownListener != null && position == size - 3) {
            mOnReachDownListener.onReachDown();
        }
    }

    @Override
    public int getItemCount() {
        int itemCount = super.getItemCount() + 1;
        if (itemCount < 2) {
            itemCount = 0;
        }
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        int max = getItems().size();
        if (position == max) {
            return VIEW_TYPE_PROGRESS;
        } else {
            return VIEW_TYPE_ITEM;
        }
    }
}
