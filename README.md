# Fragment 懒加载

[TOC]

## 什么时候需要懒加载？
这个情况一般存在于`ViewPage`中使用使用`FragmentPagerAdapter`，使用ViewPage加载大量的`Fragment`，由于`ViewPage`会预先加载Fragment导致没有显示的`Fragment`会在后台预先加载，造成流量浪费。
## 原理
主要靠的是`Fragment`的`void setUserVisibleHint(boolean isVisibleToUser)`方法
`ViewPage` 在设置当前视图是会调用 `adapter.setPrimaryItem(ViewGroup container, int position, Object object) ` 的方法，`FragmentPagerAdapter`中调用`Fragment`的`setUserVisibleHint`方法

``` @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment)object;
        if (fragment != mCurrentPrimaryItem) {
            if (mCurrentPrimaryItem != null) {
                mCurrentPrimaryItem.setMenuVisibility(false);
                mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            mCurrentPrimaryItem = fragment;
        }
    }
```

**注意事项**
`setUserVisibleHint`方法，在`onCreateView`之前调用
如果在`setUserVisibleHint`,操作`View`（显示Loading）可能会出现空指针，因为还没有创建View所以要考虑在onCreateView之后
![setUserVisibleHint 生命周期关系](http://ww4.sinaimg.cn/large/65e4f1e6jw1fabkfu02joj20gk0fe79l.jpg)


## 实现
设置标记位，重写`Fragment`的`setUserVisibleHint`

```
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
```

参考
[Andriod开发技巧——Fragment的懒加载](http://blog.csdn.net/maosidiaoxian/article/details/38300627)



