package cn.com.tarena.weatherapp.ui.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.tarena.weatherapp.ui.WeatherApp;

/**
 * 碎片的基类，包含公共的方法。
 * 所有的Fragment都要继承该类
 */
public abstract class FragmentBase extends Fragment {

    protected Activity mActivity;
    protected View mFragmentView;
    protected Handler mHandler;
    protected WeatherApp mApp;

    /**
     * 初始化方法
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        mApp = (WeatherApp) mActivity.getApplication();
    }

    /**
     * 设置显示布局
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentView = getFragmentView(inflater,container,savedInstanceState);
        mHandler = new Handler();
        return mFragmentView;
    }

    /**
     * 获得子类控件
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public abstract View getFragmentView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState);

}
