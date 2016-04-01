package cn.com.tarena.weatherapp.entity;


/**
 * 地图模块天气数据实体类
 * 
 * @author 张科勇
 * 
 */
public class MapWeahter{
	private String mDistrict; // 市区
	private String mTemperature;// 温度
	private String mWeather;// 天气情况
	private int mWeatherIconID;// 天气图标ID
	private double mLatitude;// 纬度
	private double mLongitude;// 经度
	public MapWeahter() {
		super();
	}
	public MapWeahter(String mDistrict, String mTemperature, String mWeather,
			int mWeatherIconID, double mLatitude, double mLongitude) {
		super();
		this.mDistrict = mDistrict;
		this.mTemperature = mTemperature;
		this.mWeather = mWeather;
		this.mWeatherIconID = mWeatherIconID;
		this.mLatitude = mLatitude;
		this.mLongitude = mLongitude;
	}
	public String getmDistrict() {
		return mDistrict;
	}
	public void setmDistrict(String mDistrict) {
		this.mDistrict = mDistrict;
	}
	public String getmTemperature() {
		return mTemperature;
	}
	public void setmTemperature(String mTemperature) {
		this.mTemperature = mTemperature;
	}
	public String getmWeather() {
		return mWeather;
	}
	public void setmWeather(String mWeather) {
		this.mWeather = mWeather;
	}
	public int getmWeatherIconID() {
		return mWeatherIconID;
	}
	public void setmWeatherIconID(int mWeatherIconID) {
		this.mWeatherIconID = mWeatherIconID;
	}
	public double getmLatitude() {
		return mLatitude;
	}
	public void setmLatitude(double mLatitude) {
		this.mLatitude = mLatitude;
	}
	public double getmLongitude() {
		return mLongitude;
	}
	public void setmLongitude(double mLongitude) {
		this.mLongitude = mLongitude;
	}
	@Override
	public String toString() {
		return "MapWeahter [mDistrict=" + mDistrict + ", mTemperature="
				+ mTemperature + ", mWeather=" + mWeather + ", mWeatherIconID="
				+ mWeatherIconID + ", mLatitude=" + mLatitude + ", mLongitude="
				+ mLongitude + "]";
	}


}
