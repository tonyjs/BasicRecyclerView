package com.tonyjs.basicrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.tonyjs.basicrecyclerview.adapter.viewholder.BasicViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony.park on 14. 11. 5..
 */
public abstract class BasicRecyclerAdapter<T> extends RecyclerView.Adapter<BasicViewHolder> {

    private Context mContext;

    public BasicRecyclerAdapter(Context context) {
        mContext = context;
    }

    public BasicRecyclerAdapter(Context context, List<T> items) {
        mContext = context;
        setItems(items);
    }

    private List<T> mItems = new ArrayList<>();

    public void setItems(List<T> items) {
        mItems.clear();
        if (items != null && !items.isEmpty()) {
            mItems.addAll(items);
        }
        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void addItemsOnTop(List<T> items) {
        mItems.addAll(0, items);
        notifyDataSetChanged();
    }

    public void addItem(T item) {
        mItems.add(item);
        notifyItemInserted(mItems.size() - 1);
    }

    public void removeItem(int position) {
        if (getItemCount() > position) {
            mItems.remove(position);
            notifyItemRemoved(position);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(BasicViewHolder holder, int position) {
        holder.onBindView(getItem(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public T getItem(int position) {
        int max = mItems.size();
        return max > position ? mItems.get(position) : null;
    }

    public Context getContext() {
        return mContext;
    }

    public List<T> getItems() {
        return mItems;
    }

}
