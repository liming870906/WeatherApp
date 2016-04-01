package cn.com.tarena.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import cn.com.tarena.weatherapp.R;
import cn.com.tarena.weatherapp.entity.Weather;

/**
 * Created by liming on 16/3/3.
 */
public class FragmentCityAdapter extends BaseAdapter {

    private ArrayList<Weather> weathers;
    private Weather mWeather;
    private LayoutInflater inflater;
    private AdapterCallBack callback;

    /**
     * 构造方法
     * @param weathers
     */
    public FragmentCityAdapter(ArrayList<Weather> weathers,Context context,Weather weather,AdapterCallBack callback) {
        this.weathers = weathers;
        this.inflater = LayoutInflater.from(context);
        this.mWeather = weather;
        this.callback = callback;
    }

    /**
     * 更新数据
     * @param weathers
     * @param weather
     */
    public void updateData(ArrayList<Weather> weathers, Weather weather){
        this.weathers = weathers;
        this.mWeather = weather;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return weathers.size()+1;
    }

    @Override
    public Object getItem(int position) {
        return weathers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(weathers.size() == position){
            convertView = inflater.inflate(R.layout.fragment_city_gv_item_add,parent,false);
        }else{
            ViewHolder _holder;
            if(convertView == null){
                convertView = inflater.inflate(R.layout.fragment_city_gv_item,parent,false);
                _holder = new ViewHolder();
                _holder.tvCityName = (TextView)convertView.findViewById(R.id.tv_fragment_city_item_cityname);
                _holder.tvWeather = (TextView)convertView.findViewById(R.id.tv_fragment_city_item_weather);
                _holder.tvTemp = (TextView)convertView.findViewById(R.id.tv_fragment_city_item_temp);
                _holder.tvDefault = (TextView)convertView.findViewById(R.id.tv_fragment_city_item_default);
                _holder.btnRemove = (Button) convertView.findViewById(R.id.btn_fragment_city_item_remove);
                convertView.setTag(_holder);
            }else{
                _holder = (ViewHolder) convertView.getTag();
            }
            //获得天气对象
            final Weather weather = weathers.get(position);
            if(weather != null && _holder != null){
                _holder.tvCityName.setText(weather.getmTodayWeather().getmCity());
                _holder.tvWeather.setText(weather.getmTodayWeather().getmWeather());
                _holder.tvTemp.setText(weather.getmTodayWeather().getmTemperature());
                if(weather.getmTodayWeather().getmCity().equals(mWeather.getmTodayWeather().getmCity())){
                    _holder.tvDefault.setText("默认");
                }else{
                    _holder.tvDefault.setText("未默认");
                }
                _holder.btnRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callback.updateCity(weather);
                    }
                });
            }
        }
        return convertView;
    }

    /**
     * 缓存类
     */
    class ViewHolder{
        TextView tvCityName,tvTemp,tvWeather,tvDefault;
        Button btnRemove;
    }
    public interface AdapterCallBack{
        void updateCity(Weather weather);
    }
}
