package com.tonyjs.basicrecyclerview.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tonyjs.basicrecyclerview.BasicRecyclerView;
import com.tonyjs.basicrecyclerview.example.adapter.MultiItemAdapter;
import com.tonyjs.basicrecyclerview.example.adapter.SimpleItemAdapter;
import com.tonyjs.basicrecyclerview.example.model.ItemFactory;

/**
 * Created by tony on 14. 12. 31..
 */
public class MultiItemFragment extends BaseFragment {

    private BasicRecyclerView mRecycler;
    private LinearLayoutManager mLayoutManager;
    private View mProgress;
    private MultiItemAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        mProgress = rootView.findViewById(R.id.progress);
        mRecycler = (BasicRecyclerView) rootView.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(mLayoutManager);
        mAdapter = new MultiItemAdapter(getActivity());
        mRecycler.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter.setItems(ItemFactory.getItems(0));
    }

    @Override
    public int getPosition() {
        return 1;
    }
}
