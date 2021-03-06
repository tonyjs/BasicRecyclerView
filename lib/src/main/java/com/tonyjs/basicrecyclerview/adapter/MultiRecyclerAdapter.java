package com.tonyjs.basicrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.tonyjs.basicrecyclerview.adapter.viewholder.BasicViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony.park on 14. 11. 28..
 */
public abstract class MultiRecyclerAdapter extends RecyclerView.Adapter<BasicViewHolder> {

    private Context mContext;
    public MultiRecyclerAdapter(Context context) {
        mContext = context;
    }

    private List<Row> mRows = new ArrayList<>();

    public void setRows(List<Row> rows){
        mRows.clear();
        if (rows != null && !rows.isEmpty()) {
            mRows.addAll(rows);
        }
        notifyDataSetChanged();
    }

    public void addRows(List<Row> rows){
        mRows.addAll(rows);
        notifyDataSetChanged();
    }

    public void addRowsOnTop(List<Row> rows){
        mRows.addAll(0, rows);
        notifyDataSetChanged();
    }

    public void addRowOnTop(Object item, int viewType) {
        mRows.add(0, new Row(item, viewType));
        notifyItemInserted(0);
    }

    public void addRow(Object item, int viewType) {
        mRows.add(new Row(item, viewType));
        notifyItemInserted(mRows.size() - 1);
    }

    public void removeRow(int position) {
        int max = getItemCount();
        if (max > position) {
            mRows.remove(position);
            notifyItemRemoved(position);
        }
    }

    public List<Row> getRows() {
        return mRows;
    }

    protected Row getRow(Object item, int viewType) {
        return new Row(item, viewType);
    }

    public Row getRow(int position) {
        return getItemCount() > position ? mRows.get(position) : null;
    }

    @Override
    public int getItemCount() {
        return mRows.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(BasicViewHolder holder, int position) {
        holder.onBindView(getItem(position));
    }

    public Object getItem(int position) {
        return getItemCount() > position ? mRows.get(position).getItem() : null;
    }

    @Override
    public int getItemViewType(int position) {
        return mRows.get(position).getItemViewType();
    }

    public Context getContext() {
        return mContext;
    }

    public static class Row {
        private Object item;
        private int itemViewType;

        public Row(Object item, int viewType) {
            this.item = item;
            this.itemViewType = viewType;
        }

        public Object getItem() {
            return item;
        }

        public void setItem(Object item) {
            this.item = item;
        }

        public int getItemViewType() {
            return itemViewType;
        }

        public void setItemViewType(int itemViewType) {
            this.itemViewType = itemViewType;
        }
    }
}
