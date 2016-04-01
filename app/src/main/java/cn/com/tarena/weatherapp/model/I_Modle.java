package cn.com.tarena.weatherapp.model;

import cn.com.tarena.weatherapp.controller.I_OnGetDataListener;

/**
 * Created by liming on 16/1/20.
 */
public interface I_Modle<T,S> {
    void loadData(T parameter,I_OnGetDataListener<S> callback);
}
