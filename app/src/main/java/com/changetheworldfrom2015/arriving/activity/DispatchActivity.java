package com.changetheworldfrom2015.arriving.activity;

import com.parse.ui.ParseLoginDispatchActivity;

/**
 * Created by qiucenzhang on 7/15/15.
 */
public class DispatchActivity extends ParseLoginDispatchActivity{
    @Override
    protected Class<?> getTargetClass() {
        return MainActivity.class;
    }
}
