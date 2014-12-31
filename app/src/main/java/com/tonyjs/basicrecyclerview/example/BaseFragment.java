package com.tonyjs.basicrecyclerview.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by tony on 14. 12. 31..
 */
public abstract class BaseFragment extends Fragment{
    public interface Callback{
        public void onSectionAttached(int position);
    }
    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof Callback) {
            ((Callback) getActivity()).onSectionAttached(getPosition());
        }
    }

    public abstract int getPosition();
}
