package com.changetheworldfrom2015.arriving;

import android.R.integer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by qiucenzhang on 7/17/15.
 */
public class ItemFragment extends Fragment {
    private int position;

    public ItemFragment(int position) {
        this.position = position;
    }
    /* (non-Javadoc)
     * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        tv.setText("这是第" + position + "个Fragment");
        return tv;
    }
}
