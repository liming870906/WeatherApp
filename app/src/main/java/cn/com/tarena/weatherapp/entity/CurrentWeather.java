package cn.com.tarena.weatherapp.entity;


/**
 * 当前实况天气实体类
 * 
 * @author 张科勇
 */
public class CurrentWeather{

	private String mTemperature; // 当前温度
	private String mWindStrength; // 当前风力
	private String mHumidity; // 当前湿度
	private String mTime; // 更新时间
	private String mWindDirection; // 当前风向
	public CurrentWeather() {
		super();
	}
	public CurrentWeather(String mTemperature, String mWindStrength,
			String mHumidity, String mTime, String mWindDirection) {
		super();
		this.mTemperature = mTemperature;
		this.mWindStrength = mWindStrength;
		this.mHumidity = mHumidity;
		this.mTime = mTime;
		this.mWindDirection = mWindDirection;
	}
	public String getmTemperature() {
		return mTemperature;
	}
	public void setmTemperature(String mTemperature) {
		this.mTemperature = mTemperature;
	}
	public String getmWindStrength() {
		return mWindStrength;
	}
	public void setmWindStrength(String mWindStrength) {
		this.mWindStrength = mWindStrength;
	}
	public String getmHumidity() {
		return mHumidity;
	}
	public void setmHumidity(String mHumidity) {
		this.mHumidity = mHumidity;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public String getmWindDirection() {
		return mWindDirection;
	}
	public void setmWindDirection(String mWindDirection) {
		this.mWindDirection = mWindDirection;
	}
	@Override
	public String toString() {
		return "CurrentWeather [mTemperature=" + mTemperature
				+ ", mWindStrength=" + mWindStrength + ", mHumidity="
				+ mHumidity + ", mTime=" + mTime + ", mWindDirection="
				+ mWindDirection + "]";
	}
	

}