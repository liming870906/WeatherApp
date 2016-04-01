package cn.com.tarena.weatherapp.ui;

import android.app.Application;

import java.util.ArrayList;
import java.util.Iterator;

import cn.com.tarena.weatherapp.entity.Weather;

/**
 * Created by liming on 16/3/2.
 */
public class WeatherApp extends Application {
    //天气实体类
    private Weather weather;
    //缓存城市信息集合
    private ArrayList<Weather> weathers;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化缓存城市集合
        weathers = new ArrayList<Weather>();
    }

    /**
     * 添加城市天气
     * @param weather
     */
    public void addWeather(Weather weather){
        weathers.add(weather);
    }

    /**
     * 清楚城市天气
     */
    public void clearWeather(){
        weathers.clear();
    }

    /**
     * 移除城市天气
     * @param weather
     */
    public void removeWeather(Weather weather){
        weathers.remove(weather);
    }

    /**
     * 获得城市天气集合
     * @return
     */
    public ArrayList<Weather> getWeathers() {
        if(weathers == null)
            return weathers = new ArrayList<Weather>();
        else
            return weathers;
    }

    /**
     * 判断元素是否存在
     * @param weather
     * @return
     */
    public boolean isInClude(Weather weather){
        //判断是否对象存在
        if(weathers.contains(weather)){
            int _index = weathers.indexOf(weather);
            weathers.remove(_index);
            weathers.add(_index,weather);
            return true;
        }else{
            //判断是否有一样的元素
            Iterator<Weather> iterator = weathers.iterator();
            //循环遍历
            while (iterator.hasNext()){
                //获得数据
                Weather _weather = iterator.next();
                //比较数据中城市是否一致
                if(_weather.getmTodayWeather().getmCity().equals(weather.getmTodayWeather().getmCity())){
                    int _index = weathers.indexOf(_weather);
                    weathers.remove(_index);
                    weathers.add(_index,weather);
                    return true;
                }
            }
            return false;
        }
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
