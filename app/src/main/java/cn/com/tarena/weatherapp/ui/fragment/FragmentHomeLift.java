package cn.com.tarena.weatherapp.ui.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.com.tarena.weatherapp.R;
import cn.com.tarena.weatherapp.adapter.FragmentLiftAdapter;
import cn.com.tarena.weatherapp.entity.Weather;
import cn.com.tarena.weatherapp.utils.LunarCalendar;

/**
 * 主页中生活界面碎片
 * @author liming
 */
public class FragmentHomeLift extends FragmentBase {

    //控件成员
    private GridView gvLift;
    private TextView tvDate, tvCalendar;
    //适配器成员
    private FragmentLiftAdapter adapter;
    //对话空
    private AlertDialog dialog;
    //获得数据
    private int[] icons;
    private String[] texts;

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //获得布局对象
        View _view = inflater.inflate(R.layout.fragment_lift,container,false);
        //获得控件对象
        gvLift = (GridView) _view.findViewById(R.id.gv_fragment_lift);
        tvDate = (TextView) _view.findViewById(R.id.tv_fragment_lift_date);
        tvCalendar = (TextView) _view.findViewById(R.id.tv_fragment_lift_calendar);
        //返回布局控件
        return _view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获得显示数据
        TypedArray array = mActivity.getResources().obtainTypedArray(R.array.fragment_lift_drawables);
        //声明图片数组
        icons = new int[array.length()];
        //添加数据
        for (int i = 0 ; i < array.length() ; i++){
            icons[i] = array.getResourceId(i,0);
        }
        texts = mActivity.getResources().getStringArray(R.array.fragment_lift_theme_texts);
        //声明适配器对象
        adapter = new FragmentLiftAdapter(mActivity.getApplicationContext(),icons,texts,mApp.getWeather());
        //为GridView控件添加适配器对象
        gvLift.setAdapter(adapter);
        //释放TypedArray
        array.recycle();
        //获得系统时间
        Date date = new Date();
        //获得时间
        tvDate.setText("公历：" + new SimpleDateFormat("yyyy年MM月dd日").format(date));
        //获得农历效果
        LunarCalendar calendar = new LunarCalendar(date.getYear()+1900,date.getMonth()+1,date.getDay());
        //显示农历
        tvCalendar.setText("农历："+calendar.getFullInfo());
        //应用添加监听器方法
        addListener();
    }

    /**
     * 添加监听器方法
     */
    private void addListener(){
        //网格控件添加点击事件效果
        gvLift.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Weather _weather = mApp.getWeather();
                if(_weather != null){

                    String _message = "";
                    switch (position){
                        case 0://今天是
                            _message = _weather.getmTodayWeather().getmTemperature();
                            break;
                        case 1://今天天气
                            _message = _weather.getmTodayWeather().getmWeather();
                            break;
                        case 2://生活指数
                            _message = _weather.getmTodayWeather().getmDressingIndex();
                            break;
                        case 3://洗车指数
                            _message = _weather.getmTodayWeather().getmWashIndex();
                            break;
                        case 4://旅游指数
                            _message = _weather.getmTodayWeather().getmTravelIndex();
                            break;
                        case 5://感冒指数
                            _message = _weather.getmTodayWeather().getmComfortIndex();
                            break;
                        case 6://运动指数
                            _message = _weather.getmTodayWeather().getmExerciseIndex();
                            break;
                        case 7://紫外线指数
                            _message = _weather.getmTodayWeather().getmUvIndex();
                            break;
                    }
                    //显示对话框
                    showDialog(_message);
                }else{
                    Toast.makeText(mActivity,"未获取数据信息，请查看网络是否连接",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * 显示对话框
     * @param pMessage
     */
    private void showDialog(String pMessage){
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("详细信息");
        builder.setMessage(pMessage);
        builder.setCancelable(false);
        builder.setNegativeButton("关闭", new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }
}