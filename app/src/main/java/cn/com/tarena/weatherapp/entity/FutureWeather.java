package cn.com.tarena.weatherapp.entity;


/**
 * 未来天气实体类
 * 
 * @author 张科勇
 * 
 */
public class FutureWeather {

	private String mWind;// 风力
	private String mWeek;// 星期
	private String mTemperature;// 温度
	private WeatherId mWeatherId;// 天气ID
	private String mDate;// 日期
	private String mWeather;// 天气情况
	public FutureWeather() {
		super();
	}
	public FutureWeather(String mWind, String mWeek, String mTemperature,
			WeatherId mWeatherId, String mDate, String mWeather) {
		super();
		this.mWind = mWind;
		this.mWeek = mWeek;
		this.mTemperature = mTemperature;
		this.mWeatherId = mWeatherId;
		this.mDate = mDate;
		this.mWeather = mWeather;
	}
	public String getmWind() {
		return mWind;
	}
	public void setmWind(String mWind) {
		this.mWind = mWind;
	}
	public String getmWeek() {
		return mWeek;
	}
	public void setmWeek(String mWeek) {
		this.mWeek = mWeek;
	}
	public String getmTemperature() {
		return mTemperature;
	}
	public void setmTemperature(String mTemperature) {
		this.mTemperature = mTemperature;
	}
	public WeatherId getmWeatherId() {
		return mWeatherId;
	}
	public void setmWeatherId(WeatherId mWeatherId) {
		this.mWeatherId = mWeatherId;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public String getmWeather() {
		return mWeather;
	}
	public void setmWeather(String mWeather) {
		this.mWeather = mWeather;
	}
	@Override
	public String toString() {
		return "FutureWeather [mWind=" + mWind + ", mWeek=" + mWeek
				+ ", mTemperature=" + mTemperature + ", mWeatherId="
				+ mWeatherId + ", mDate=" + mDate + ", mWeather=" + mWeather
				+ "]";
	}


}