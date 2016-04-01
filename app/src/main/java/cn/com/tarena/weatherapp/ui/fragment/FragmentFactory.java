package cn.com.tarena.weatherapp.ui.fragment;

import java.util.HashMap;

/**
 * 创建碎片工厂
 * 单例模式
 */
public class FragmentFactory {

    public static final int FRAGMENT_TYPE_LIFT = 0X0001;
    public static final int FRAGMENT_TYPE_FORECAST = 0X0002;
    public static final int FRAGMENT_TYPE_CITY = 0X0003;

    private static HashMap<Integer, FragmentBase> mFragments = new HashMap<Integer, FragmentBase>();

    /**
     * 定义私有构造方法。
     */
    private FragmentFactory() {}

    /**
     * 创建碎片
     * @param pFragmentType
     * @return
     */
    public static FragmentBase createFragement(int pFragmentType){
        //获得缓存中的碎片
        FragmentBase _FragmentBase = mFragments.get(pFragmentType);
        //判断缓存中是否有该类型的碎片
        if(_FragmentBase == null){
            //创建对象并且添加到HashMap缓存中
            switch (pFragmentType){
                //判断是否为生活碎片
                case FRAGMENT_TYPE_LIFT:
                    //创建碎片对象
                    _FragmentBase = new FragmentHomeLift();
                    break;
                case FRAGMENT_TYPE_FORECAST:
                    //创建碎片对象
                    _FragmentBase = new FragmentHomeForecast();
                    break;
                case FRAGMENT_TYPE_CITY:
                    //创建碎片对象
                    _FragmentBase = new FragmentHomeCity();
                    break;
            }
            //碎片添加到缓存中
            mFragments.put(pFragmentType,_FragmentBase);
        }
        //返回获得的碎片对象
        return _FragmentBase;
    }
}
