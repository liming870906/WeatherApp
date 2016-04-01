package cn.com.tarena.weatherapp.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.com.tarena.weatherapp.R;
import cn.com.tarena.weatherapp.adapter.FragmentCityAdapter;
import cn.com.tarena.weatherapp.entity.Weather;
import cn.com.tarena.weatherapp.ui.ChangeCityAct;

/**
 *
 */
public class FragmentHomeCity extends FragmentBase implements FragmentCityAdapter.AdapterCallBack{

    private GridView gvCities;
    private FragmentCityAdapter adapter ;
    private ArrayList<Weather> weathers;

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //获得布局对象
        View _view = inflater.inflate(R.layout.fragment_city,container,false);
        gvCities = (GridView) _view.findViewById(R.id.gv_fragment_city);
        //返回布局控件
        return _view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获得城市信息集合
        weathers = mApp.getWeathers();
        //初始化显示城市适配器对象
        adapter = new FragmentCityAdapter(weathers,mActivity.getApplicationContext(),mApp.getWeather(),this);
        //设置显示
        gvCities.setAdapter(adapter);
        //引用添加监听器方法
        addListener();
    }

    /**
     * 添加监听方法
     */
    private void addListener(){
        //城市GridView点击事件监听器方法
        gvCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mApp.getWeathers().size() == position){
                    //跳转到城市管理界面
//                    Toast.makeText(mActivity.getApplicationContext(), "跳转", Toast.LENGTH_SHORT).show();
                    //初始化意图对象
                    Intent intent = new Intent(mActivity, ChangeCityAct.class);
                    //开启界面
                    mActivity.startActivity(intent);
                }else{
                    //获得天气数据
                    Weather _weather = (Weather)adapter.getItem(position);
                    //更新当前天气
                    mApp.setWeather(_weather);
                    //更新数据
                    adapter.updateData(mApp.getWeathers(),mApp.getWeather());
                }
            }
        });
    }

    @Override
    public void updateCity(Weather weather) {
        //移除的不是默认的
        if(!weather.getmTodayWeather().getmCity().equals(mApp.getWeather().getmTodayWeather().getmCity())){
            //移除
            mApp.removeWeather(weather);
            //更新数据
            adapter.updateData(mApp.getWeathers(),mApp.getWeather());
        }else{
            //移除的是默认的
            if(mApp.getWeathers().size() > 1){
                mApp.removeWeather(weather);
                mApp.setWeather(mApp.getWeathers().get(0));
                adapter.updateData(mApp.getWeathers(),mApp.getWeather());

            }else{
                Toast.makeText(mActivity.getApplicationContext(),"至少有一个城市",Toast.LENGTH_LONG).show();
            }
        }
    }
}
