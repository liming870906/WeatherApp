package cn.com.tarena.weatherapp.ui.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import cn.com.tarena.weatherapp.R;
import cn.com.tarena.weatherapp.controller.A_Controller;
import cn.com.tarena.weatherapp.controller.WeatherController;
import cn.com.tarena.weatherapp.entity.Weather;
import cn.com.tarena.weatherapp.ui.I_ViewWithData;
import cn.com.tarena.weatherapp.utils.LunarCalendar;

/**
 * 天气预报
 *
 * @author liming
 */
public class FragmentHomeForecast extends FragmentBase implements I_ViewWithData<Weather> {

    //控制类
    private A_Controller<String, String, Weather> controller;
    //布局控件
    private ImageView ivWeatherIcon;
    private TextView tvTemperature, tvCityName, tvChinaCalendar;
    private EditText etSearchCityName;
    private Button btnSearch;

    /**
     * 构造方法
     */
    public FragmentHomeForecast() {
        super();
        //声明控制类对象
        controller = new WeatherController(this);
    }

    /**
     * 设置显示布局
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //获得布局对象
        View _view = inflater.inflate(R.layout.fragment_forecast, container, false);
        //获得控件对象的引用
        tvCityName = (TextView) _view.findViewById(R.id.tv_forecast_city_name);
        tvTemperature = (TextView) _view.findViewById(R.id.tv_forecast_temperature);
        tvChinaCalendar = (TextView) _view.findViewById(R.id.tv_forecast_china_calendar);
        etSearchCityName = (EditText) _view.findViewById(R.id.et_forecast_search_city_name);
        btnSearch = (Button) _view.findViewById(R.id.btn_forecast_search);
        //返回布局控件
        return _view;
    }

    /**
     * 添加监听方法
     */
    private void addListener() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得城市名称
                String _cityName = etSearchCityName.getText().toString().trim();
                controller.getData(_cityName);
            }
        });
    }

    /**
     * 初始化加载数据
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addListener();
        if(mApp.getWeather() != null){
            updateData(mApp.getWeather());
        }else {
            controller.getData("北京");
        }
    }

    /**
     * 返回数据
     *
     * @param weather
     */
    @Override
    public void bindDataOnViewItem(final Weather weather) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mApp.setWeather(weather);
                updateData(weather);
            }
        });
    }

    @Override
    public void onError() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mActivity, "加载失败", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateData(Weather pWeather) {
        //添加城市
        addWeather(pWeather);
        //显示城市信息
        tvCityName.setText(pWeather.getmTodayWeather().getmCity());
        //显示当前气温
        tvTemperature.setText(pWeather.getmTodayWeather().getmTemperature());
        //获得系统时间
        Date date = new Date();
        //显示农历日期
        tvChinaCalendar.setText("农历：" + new LunarCalendar(date.getYear() + 1900, date.getMonth() + 1, date.getDay()).getFullInfo());
    }

    /**
     * 添加天气放缓存中
     */
    private void addWeather(Weather weather){
        //判断天气是否存在
        if(!mApp.isInClude(weather)){
            mApp.addWeather(weather);
        }
    }
}
