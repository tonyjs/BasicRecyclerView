package com.tonyjs.basicrecyclerview.example;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tonyjs.basicrecyclerview.BasicRecyclerView;
import com.tonyjs.basicrecyclerview.example.adapter.InfiniteItemAdapter;
import com.tonyjs.basicrecyclerview.example.model.ItemFactory;

/**
 * Created by tony on 14. 12. 29..
 */
public class InfiniteItemFragment extends BaseFragment
            implements InfiniteItemAdapter.OnReachDownListener{

    private BasicRecyclerView mRecycler;
    private LinearLayoutManager mLayoutManager;
    private View mProgress;
    private InfiniteItemAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        mProgress = rootView.findViewById(R.id.progress);
        mProgress.setVisibility(View.VISIBLE);
        mRecycler = (BasicRecyclerView) rootView.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(mLayoutManager);
        mAdapter = new InfiniteItemAdapter(getActivity());
        mAdapter.setOnReachDownListener(this);
        mRecycler.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        requestItems();
    }

    private boolean mInProcess = false;
    private void requestItems() {
        mInProcess = true;
        mHandler.sendEmptyMessageDelayed(0, 3000);
    }

    private void requestMoreItems() {
        mInProcess = true;
        mIndex += 20;
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private int mIndex = 0;

    public void handleItems(int mIndex) {
        mAdapter.addItems(ItemFactory.getItems(mIndex));
        if (mProgress.getVisibility() != View.GONE) {
            mProgress.setVisibility(View.GONE);
        }
        mInProcess = false;
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            handleItems(mIndex);
        }
    };

    @Override
    public void onReachDown() {
        if (mInProcess) {
            return;
        }
        requestMoreItems();
    }

    @Override
    public int getPosition() {
        return 2;
    }
}
