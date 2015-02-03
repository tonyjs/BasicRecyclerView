package com.tonyjs.basicrecyclerview.adapter.viewholder;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by tony.park on 13. 12. 9.
 */
public class SparseViewHolder {
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if(viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View child = viewHolder.get(id);
        if(child == null) {
            child = view.findViewById(id);
            viewHolder.put(id, child);
        }
        return (T) child;
    }
}
