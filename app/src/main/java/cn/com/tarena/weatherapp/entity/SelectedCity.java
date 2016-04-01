package cn.com.tarena.weatherapp.entity;


/**
 * 被选中的城市实体类
 * 
 * @author 张科勇
 */
public class SelectedCity extends City {

	private String mWeather;// 天气情况
	private String mTemperature;// 温度
	private long mSelectedTime;// 被选择的时间

	public SelectedCity() {
		super();
	}

	public SelectedCity(String mWeather, String mTemperature, long mSelectedTime) {
		super();
		this.mWeather = mWeather;
		this.mTemperature = mTemperature;
		this.mSelectedTime = mSelectedTime;
	}

	public String getmWeather() {
		return mWeather;
	}

	public void setmWeather(String mWeather) {
		this.mWeather = mWeather;
	}

	public String getmTemperature() {
		return mTemperature;
	}

	public void setmTemperature(String mTemperature) {
		this.mTemperature = mTemperature;
	}

	public long getmSelectedTime() {
		return mSelectedTime;
	}

	public void setmSelectedTime(long mSelectedTime) {
		this.mSelectedTime = mSelectedTime;
	}

	@Override
	public String toString() {
		return "SelectedCity [mWeather=" + mWeather + ", mTemperature="
				+ mTemperature + ", mSelectedTime=" + mSelectedTime + "]";
	}

}
