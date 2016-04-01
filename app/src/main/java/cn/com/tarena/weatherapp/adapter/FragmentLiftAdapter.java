package cn.com.tarena.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.com.tarena.weatherapp.R;
import cn.com.tarena.weatherapp.entity.Weather;
import cn.com.tarena.weatherapp.ui.WeatherApp;

/**
 * Created by liming on 16/2/25.
 * @author liming
 */
public class FragmentLiftAdapter extends BaseAdapter{
    //声明显示图片和文本资源数组
    private int[] icons;
    private String[] texts;
    private Weather weather;
    //布局加载器
    private LayoutInflater inflater;


    /**
     * 构造方法
     * @param icons
     * @param texts
     */
    public FragmentLiftAdapter(Context context,int[] icons, String[] texts,Weather weather){
        this.icons = icons;
        this.texts = texts;
        this.inflater = LayoutInflater.from(context);
        this.weather = weather;
    }

    /**
     * 显示Item的个数
     * @return
     */
    @Override
    public int getCount() {
        if(this.icons.length > 0)
            return this.icons.length;
        return 0;
    }

    /**
     * 显示Entity的对象
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return null;
    }

    /**
     * 显示Entity对象的表示
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * 显示View的布局对象
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //声明缓存类对象
        ViewHolder _holder;
        //判断是否View是否为NULL
        if(convertView == null){
            //获得布局中的控件
            convertView = this.inflater.inflate(R.layout.fragment_lift_gv_item,parent,false);
            //声明缓存类对象
            _holder = new ViewHolder();
            //获得控件对象
            _holder.ivIcon = (ImageView)convertView.findViewById(R.id.iv_fragment_lift_gv_item_theme_icon);
            _holder.tvTheme = (TextView)convertView.findViewById(R.id.tv_fragment_item_gv_item_theme_text);
            _holder.tvMessage = (TextView)convertView.findViewById(R.id.tv_fragment_item_gv_item_message_text);
            //添加缓存
            convertView.setTag(_holder);
        }else{
            //获得缓存对象
            _holder = (ViewHolder) convertView.getTag();
        }
        //设置显示内容
        _holder.ivIcon.setImageResource(icons[position]);
        _holder.tvTheme.setText(texts[position]);
        if(weather != null){
            String _message = "";
            switch (position){
                case 0://今天是
                    _message = weather.getmTodayWeather().getmTemperature();
                    break;
                case 1://今天天气
                    _message = weather.getmTodayWeather().getmWeather();
                    break;
                case 2://生活指数
                    _message = weather.getmTodayWeather().getmDressingIndex();
                    break;
                case 3://洗车指数
                    _message = weather.getmTodayWeather().getmWashIndex();
                    break;
                case 4://旅游指数
                    _message = weather.getmTodayWeather().getmTravelIndex();
                    break;
                case 5://感冒指数
                    _message = weather.getmTodayWeather().getmComfortIndex();
                    break;
                case 6://运动指数
                    _message = weather.getmTodayWeather().getmExerciseIndex();
                    break;
                case 7://紫外线指数
                    _message = weather.getmTodayWeather().getmUvIndex();
                    break;
            }
            _holder.tvMessage.setText(_message);
        }
        //返回显示控件
        return convertView;
    }

    /**
     * 缓存类
     */
    class ViewHolder{
        //缓存控件
        ImageView ivIcon;
        TextView tvTheme, tvMessage;
    }
}
