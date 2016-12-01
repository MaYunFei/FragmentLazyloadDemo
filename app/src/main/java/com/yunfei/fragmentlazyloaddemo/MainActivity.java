package com.yunfei.fragmentlazyloaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yunfei.fragmentlazyloaddemo.lazy.LazyViewPageActivity;

public class MainActivity extends AppCompatActivity {

    public static final String[] title = {"静态添加", "动态添加", "ViewPage","Tab_layout","LazyViewPage"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
            ArrayListFragment list = new ArrayListFragment();
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, list).commit();
        }

    }

    public static class ArrayListFragment extends ListFragment {
        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setListAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, title));
        }


        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            switch (position) {
                case 0:
                    startActivity(new Intent(getContext(), StaticFragmentActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(getContext(), DynamicFragmentActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(getContext(), ViewPageActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(getContext(), TabLayoutActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(getContext(), LazyViewPageActivity.class));
                    break;
                default:
                    break;
            }

        }
    }
}
