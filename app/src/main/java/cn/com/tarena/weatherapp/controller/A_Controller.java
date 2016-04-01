package cn.com.tarena.weatherapp.controller;

import cn.com.tarena.weatherapp.model.I_Modle;
import cn.com.tarena.weatherapp.ui.I_ViewWithData;

/**
 * Created by liming on 16/1/20.
 */
public abstract class A_Controller<T,S,F> {
    protected I_ViewWithData<F> mViewWithData;
    protected I_Modle<T,S> mModle;

    public A_Controller(I_ViewWithData<F> mViewWithData){
        this.mViewWithData = mViewWithData;
        this.mModle = getModle();
    }

    /**
     * 获取数据
     */
    public abstract void getData(T t);
    public abstract I_Modle getModle();
}
