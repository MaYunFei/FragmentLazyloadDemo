package com.yunfei.fragmentlazyloaddemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by yunfei on 2016/11/24.
 */

public class BaseFragment extends Fragment {

    public final String TAG = getClass().getSimpleName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log("onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log("onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log("onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log("onStart");
    }


    @Override
    public void onResume() {
        super.onResume();
        Log("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log("onDetach");
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log("setUserVisibleHint");
        Log("visable = " + getUserVisibleHint());
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log("onHiddenChanged = " + hidden);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log("onSaveInstanceState");
    }


    protected void Log(String msg) {
        Log(TAG, msg);
    }

    public static void Log(String TAG, String msg) {
        Log.e(TAG, msg);
    }

}
