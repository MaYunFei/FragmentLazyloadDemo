package com.yunfei.fragmentlazyloaddemo.lazy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yunfei.fragmentlazyloaddemo.BaseFragment;

/**
 * Created by yunfei on 2016/11/25.
 */

public abstract class LazyFragment extends BaseFragment {
    protected boolean isViewCreated = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint() && isViewCreated) {
            //当前可见
            onVisible();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
    }

    /**
     * fragment 在当前窗口显示
     * 可以执行数据加载
     */
    protected abstract void onVisible();
}
