package cn.com.tarena.weatherapp.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.com.tarena.weatherapp.entity.CurrentWeather;
import cn.com.tarena.weatherapp.entity.FutureWeather;
import cn.com.tarena.weatherapp.entity.TodayWeather;
import cn.com.tarena.weatherapp.entity.Weather;
import cn.com.tarena.weatherapp.entity.WeatherId;
import cn.com.tarena.weatherapp.model.I_Modle;
import cn.com.tarena.weatherapp.model.WeatherModle;
import cn.com.tarena.weatherapp.ui.I_ViewWithData;

/**
 * Created by liming on 16/1/25.
 */
public class WeatherController extends A_Controller<String,String,Weather>{


    /**
     * 构造方法
     * @param mViewWithData
     */
    public WeatherController(I_ViewWithData<Weather> mViewWithData) {
        super(mViewWithData);
    }

    /**
     * 获得数据
     */
    @Override
    public void getData(String parameter) {
        //调用加载数据方法
        mModle.loadData(parameter, new I_OnGetDataListener<String>() {
            @Override
            public void onSuccess(String pData) {
                Weather _weather;
                try {
                    _weather = parseJson(pData);
                    mViewWithData.bindDataOnViewItem(_weather);
                } catch (JSONException e) {
                    e.printStackTrace();
                    mViewWithData.onError();
                }
                //返回成功方法
            }

            @Override
            public void onFail() {
                mViewWithData.onError();
            }
        });
    }

    /**
     * 获得模型对象
     * @return
     */
    @Override
    public I_Modle getModle() {
        //获得模型对象
        I_Modle<String,String> i_modle = new WeatherModle();
        return i_modle;
    }

    private Weather parseJson(String json) throws JSONException {
        Weather _weather = new Weather();
        JSONObject jsonObject = new JSONObject(json);
        int resultcode = jsonObject.optInt("resultcode");
        if (resultcode == 200) {
            JSONObject jsonResult = new JSONObject(
                    jsonObject.optString("result"));
            // 解析当前实况天气
            JSONObject jsonCurrentWeather = new JSONObject(
                    jsonResult.optString("sk"));
            CurrentWeather currentWeather = new CurrentWeather();
            // 当前湿度
            currentWeather.setmHumidity(jsonCurrentWeather
                    .optString("humidity"));
            // 当前温度
            currentWeather
                    .setmTemperature(jsonCurrentWeather.optString("temp"));
            // 更新时间
            currentWeather.setmTime(jsonCurrentWeather.optString("time"));
            // 当前风向
            currentWeather.setmWindDirection(jsonCurrentWeather
                    .optString("wind_direction"));
            // 当前风力
            currentWeather.setmWindStrength(jsonCurrentWeather
                    .optString("wind_strength"));
            // -------------------------------------------------------
            // 解析当天天气
            JSONObject jsonTodayWeather = new JSONObject(
                    jsonResult.optString("today"));
            TodayWeather todayWeather = new TodayWeather();
            // 城市
            todayWeather.setmCity(jsonTodayWeather.getString("city"));
            // 舒适度指数
            todayWeather.setmComfortIndex(jsonTodayWeather
                    .getString("comfort_index"));
            // 日期
            todayWeather.setmDateY(jsonTodayWeather.getString("date_y"));
            // 穿衣建议
            todayWeather.setmDressingAdvice(jsonTodayWeather
                    .getString("dressing_advice"));
            // 穿衣指数
            todayWeather.setmDressingIndex(jsonTodayWeather
                    .getString("dressing_index"));
            // 干燥指数
            todayWeather.setmDryingIndex(jsonTodayWeather
                    .getString("drying_index"));
            // 晨练指数
            todayWeather.setmExerciseIndex(jsonTodayWeather
                    .getString("exercise_index"));
            // 今日温度
            todayWeather.setmTemperature(jsonTodayWeather
                    .getString("temperature"));
            // 旅游指数
            todayWeather.setmTravelIndex(jsonTodayWeather
                    .getString("travel_index"));
            // 紫外线强度
            todayWeather.setmUvIndex(jsonTodayWeather.getString("uv_index"));
            // 洗车指数
            todayWeather
                    .setmWashIndex(jsonTodayWeather.getString("wash_index"));
            // 今日天气
            todayWeather.setmWeather(jsonTodayWeather.getString("weather"));
            // 星期
            todayWeather.setmWeek(jsonTodayWeather.getString("week"));
            // 风向
            todayWeather.setmWind(jsonTodayWeather.getString("wind"));
            // 解析天气我i恶意标识
            JSONObject jsonWeatherId = new JSONObject(
                    jsonTodayWeather.optString("weather_id"));
            WeatherId weatherId = new WeatherId();
            // 天气标识00：晴
            weatherId.setmFa(jsonWeatherId.optInt("fa"));
            // 天气标识53：霾 如果fa不等于fb，说明是组合天气
            weatherId.setmFb(jsonWeatherId.optInt("fb"));
            // 设置太尼奇指数
            todayWeather.setmWeatherId(weatherId);
            // ----------------------------
            JSONArray jsonArray = jsonResult.optJSONArray("future");
            List<FutureWeather> futureWeathers = null;
            if (jsonArray != null) {
                futureWeathers = new ArrayList<FutureWeather>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonFuture = jsonArray.getJSONObject(i);
                    FutureWeather futureWeather = new FutureWeather();
                    futureWeather.setmDate(jsonFuture.optString("date"));
                    futureWeather.setmTemperature(jsonFuture
                            .optString("temperature"));
                    futureWeather.setmWeather(jsonFuture.optString("weather"));
                    futureWeather.setmWeek(jsonFuture.optString("week"));
                    futureWeather.setmWind(jsonFuture.optString("wind"));

                    JSONObject jsonFutureWeatherId = new JSONObject(
                            jsonFuture.optString("weather_id"));
                    WeatherId _Id = new WeatherId();
                    _Id.setmFa(jsonFutureWeatherId.optInt("fa"));
                    _Id.setmFb(jsonFutureWeatherId.optInt("fa"));

                    futureWeather.setmWeatherId(_Id);
                    // 添加未来天气
                    futureWeathers.add(futureWeather);
                }
            }
            // 添加数据
            _weather.setmCurrentWeather(currentWeather);
            _weather.setmTodayWeather(todayWeather);
            _weather.setmFutureWeathers(futureWeathers);
            return _weather;
        }
        return null;
    }
}
