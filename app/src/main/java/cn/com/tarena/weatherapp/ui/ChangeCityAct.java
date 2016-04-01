package cn.com.tarena.weatherapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import cn.com.tarena.weatherapp.R;
import cn.com.tarena.weatherapp.adapter.HotCityAdapter;

public class ChangeCityAct extends Activity {

    private GridView gvHotCity;
    private TextView tvLocationCity;
    private String[] mHotCities;
    private HotCityAdapter adapter;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    private String mNowCity;
    private static final int STOP_LOCATION = 1;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case STOP_LOCATION:
                    mLocationClient.stop();
                    mLocationClient.unRegisterLocationListener(myListener);
                break;
            }
        }
    };

    /**
     * 初始化数据方法
     */
    private void init(){
        mHotCities = getResources().getStringArray(R.array.change_host_city);
    }

    /**
     * 初始化定位
     */
    private void initLocation(){
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener( myListener );    //注册监听函数
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    /**
     * 初始化控件方法
     */
    private void setupView(){
        gvHotCity = (GridView) this.findViewById(R.id.gv_change_host_city);
        tvLocationCity = (TextView) this.findViewById(R.id.tv_change_city_location);
    }

    /**
     * 添加控件监听事件
     */
    private void addListener(){
        //GridView点击
        gvHotCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击热门城市
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_city);
        //引用初始化数据方法
        init();
        //引用定位初始化方法
        initLocation();
        //引用初始化控件方法
        setupView();
        //初始化适配器
        adapter = new HotCityAdapter(mHotCities,this);
        //GridView中设置适配器对象
        gvHotCity.setAdapter(adapter);
        //引用添加事件监听器方法
        addListener();
        //开启定位
        mLocationClient.start();
    }
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
//            mLocationClient.stop();
//            mLocationClient.unRegisterLocationListener(myListener);
            switch (location.getLocType()) {
                case BDLocation.TypeGpsLocation: // GPS定位结果
                case BDLocation.TypeNetWorkLocation: // 网络定位结果
                case BDLocation.TypeOffLineLocation: // 离线定位结果
                    mNowCity = location.getCity();
                    //设置城市名称
                    tvLocationCity.setText(mNowCity);
                    //发送消息
                    handler.sendEmptyMessage(STOP_LOCATION);
                    //设置城市省份
//                    location.getProvince();
                    //设置城市区域
//                    location.getDistrict();


                    break;
                case BDLocation.TypeServerError:
//                    msg = "服务端网络定位失败";

                    break;
                case BDLocation.TypeNetWorkException:
//                    msg = "网络不同导致定位失败，请检查网络是否通畅";

                    break;
                case BDLocation.TypeCriteriaException:
//                    msg = "无法获取有效定位依据导致定位失败，\n" +
//                            " 一般是由于手机的原因，处于飞行模式下一般会造成这种结果，\n" +
//                            " 可以试着重启手机";
                    break;
            }
        }
    }
}
