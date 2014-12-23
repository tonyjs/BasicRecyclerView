package com.tonyjs.basicrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tonyjs.basicrecyclerview.adapters.viewholders.BasicViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony.park on 14. 11. 5..
 */
public abstract class BasicRecyclerAdapter<T> extends RecyclerView.Adapter {

    protected Context mContext;
    protected LayoutInflater mInflater;
    public BasicRecyclerAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public BasicRecyclerAdapter(Context context, List<T> items) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        setItems(items);
    }

    protected List<T> mItems;
    public void setItems(List<T> items){
        mItems = items;
        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        if (mItems == null) {
            setItems(items);
            return;
        }

        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void addItemsOnTop(List<T> items) {
        if (mItems == null) {
            setItems(items);
            return;
        }

        mItems.addAll(0, items);
        notifyDataSetChanged();
    }

    public void addItem(T item) {
        if (mItems == null) {
            mItems = new ArrayList<T>();
        }
        mItems.add(item);
        notifyItemInserted(mItems.size() - 1);
    }

    public void removeItem(int position) {
        if (getItemCount() > position) {
            mItems.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public BasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(parent, viewType);
    }

    public abstract BasicViewHolder getViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindViewHolder((BasicViewHolder) holder, position);
    }

    public abstract void onBindViewHolder(BasicViewHolder viewHolder, int position);

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public T getItem(int position) {
        return getItemCount() > position ? mItems.get(position) : null;
    }

}
