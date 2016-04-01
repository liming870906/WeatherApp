package cn.com.tarena.weatherapp.entity;

import java.util.List;

/**
 * 天气总实体类（当前实况天气，未来几天天气，今天天气）
 * 
 * @author 张科勇
 * 
 */
public class Weather {

	private CurrentWeather mCurrentWeather; // 当前实况天气
	private List<FutureWeather> mFutureWeathers; // 未来几天天气
	private TodayWeather mTodayWeather; // 今天天气
	public Weather() {
		super();
	}
	public Weather(CurrentWeather mCurrentWeather,
			List<FutureWeather> mFutureWeathers, TodayWeather mTodayWeather) {
		super();
		this.mCurrentWeather = mCurrentWeather;
		this.mFutureWeathers = mFutureWeathers;
		this.mTodayWeather = mTodayWeather;
	}
	public CurrentWeather getmCurrentWeather() {
		return mCurrentWeather;
	}
	public void setmCurrentWeather(CurrentWeather mCurrentWeather) {
		this.mCurrentWeather = mCurrentWeather;
	}
	public List<FutureWeather> getmFutureWeathers() {
		return mFutureWeathers;
	}
	public void setmFutureWeathers(List<FutureWeather> mFutureWeathers) {
		this.mFutureWeathers = mFutureWeathers;
	}
	public TodayWeather getmTodayWeather() {
		return mTodayWeather;
	}
	public void setmTodayWeather(TodayWeather mTodayWeather) {
		this.mTodayWeather = mTodayWeather;
	}
	@Override
	public String toString() {
		return "Weather [mCurrentWeather=" + mCurrentWeather
				+ ", mFutureWeathers=" + mFutureWeathers + ", mTodayWeather="
				+ mTodayWeather + "]";
	}

}