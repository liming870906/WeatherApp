package cn.com.tarena.weatherapp.controller;

/**
 * Created by liming on 16/1/26.
 */
public interface I_OnGetDataListener<T> {
    public void onSuccess(T pData);
    public void onFail();
}
