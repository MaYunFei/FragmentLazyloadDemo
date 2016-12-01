package com.yunfei.fragmentlazyloaddemo.lazy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunfei.fragmentlazyloaddemo.R;

/**
 * Created by yunfei on 2016/12/1.
 */

public class MyLazyFragment extends LazyFragment {

    ContentLoadingProgressBar progressBar;


    @Override
    protected void onVisible() {
        progressBar.show();
        progressBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.hide();
            }
        }, 5000);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lazy_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = (ContentLoadingProgressBar) view.findViewById(R.id.content_pb);
    }
}
