package com.yunfei.fragmentlazyloaddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by yunfei on 2016/11/25.
 */

public class DynamicFragmentActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPageFragment01 viewPageFragment01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_fragment_activity);
        findViewById(R.id.btn_hide).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);
        viewPageFragment01 = ViewPageFragment01.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, viewPageFragment01).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hide:
                getSupportFragmentManager().beginTransaction().hide(viewPageFragment01).commit();
                break;
            case R.id.btn_show:
                getSupportFragmentManager().beginTransaction().show(viewPageFragment01).commit();
                break;
            default:
                break;
        }
    }
}
