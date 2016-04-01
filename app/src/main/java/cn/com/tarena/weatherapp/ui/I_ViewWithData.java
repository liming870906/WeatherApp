package cn.com.tarena.weatherapp.ui;

/**
 * Created by liming on 16/1/20.
 */
public interface I_ViewWithData<T> {
    void bindDataOnViewItem(T t);
    void onError();
}
