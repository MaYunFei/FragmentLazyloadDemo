package com.yunfei.fragmentlazyloaddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by yunfei on 2016/11/24.
 */

public class ViewPageFragment01 extends BaseFragment {
    public static ViewPageFragment01 newInstance() {
        return new ViewPageFragment01();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log("onCreateView");
        View rootView = inflater.inflate(R.layout.base_fragment, container, false);
        ((EditText) rootView.findViewById(R.id.et)).setText(TAG);
        return rootView;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint())
        {
            Log.i("01","显示");
        }
    }
}
