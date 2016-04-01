package cn.com.tarena.weatherapp.model;

import cn.com.tarena.weatherapp.controller.I_OnGetDataListener;
import cn.com.tarena.weatherapp.utils.Constant;
import cn.com.tarena.weatherapp.utils.HttpUtils;

/**
 * Created by liming on 16/1/25.
 */
public class WeatherModle implements I_Modle<String,String> {


    @Override
    public void loadData(String parameter, I_OnGetDataListener<String> callback) {
        //拼接URL字符串
        StringBuffer _stringBuffer = new StringBuffer();
        _stringBuffer.append(Constant.URL);
        _stringBuffer.append("?format=2");
        _stringBuffer.append("&cityname="+parameter);
        _stringBuffer.append("&key="+Constant.KEY);
        //请求数据
        HttpUtils.doGetAsyn(_stringBuffer.toString(), callback);
    }
}
