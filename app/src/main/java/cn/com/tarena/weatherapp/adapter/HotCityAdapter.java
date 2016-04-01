package cn.com.tarena.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import cn.com.tarena.weatherapp.R;

/**
 * Created by liming on 16/3/5.
 */
public class HotCityAdapter extends BaseAdapter {

    //显示热门城市
    private String[] mHotCity;
    private LayoutInflater inflater;

    /**
     * 构造方法
     * @param mHotCity
     * @param context
     */
    public HotCityAdapter(String[] mHotCity, Context context){
        this.mHotCity = mHotCity;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mHotCity.length;
    }

    @Override
    public Object getItem(int position) {
        return mHotCity[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = this.inflater.inflate(R.layout.activity_change_city_gv_item,parent,false);
        TextView tvHotCity = (TextView) convertView.findViewById(R.id.tv_change_host_city_item);
        //设置热门城市
        tvHotCity.setText(mHotCity[position]);
        return convertView;
    }
}
