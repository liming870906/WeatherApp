package cn.com.tarena.weatherapp.entity;



/**
 * 天气数据实体类
 * 
 * @author 张科勇
 * 
 */
public class WeatherResult {
	
	private String mReason;// 数据状态
	private int mErrorCode;// 错误码
	private Weather mWeather;// 天气总数据实体类
	private int mResultcode;// 结果码
	public WeatherResult() {
		super();
	}
	public WeatherResult(String mReason, int mErrorCode, Weather mWeather,
			int mResultcode) {
		super();
		this.mReason = mReason;
		this.mErrorCode = mErrorCode;
		this.mWeather = mWeather;
		this.mResultcode = mResultcode;
	}
	public String getmReason() {
		return mReason;
	}
	public void setmReason(String mReason) {
		this.mReason = mReason;
	}
	public int getmErrorCode() {
		return mErrorCode;
	}
	public void setmErrorCode(int mErrorCode) {
		this.mErrorCode = mErrorCode;
	}
	public Weather getmWeather() {
		return mWeather;
	}
	public void setmWeather(Weather mWeather) {
		this.mWeather = mWeather;
	}
	public int getmResultcode() {
		return mResultcode;
	}
	public void setmResultcode(int mResultcode) {
		this.mResultcode = mResultcode;
	}
	@Override
	public String toString() {
		return "WeatherResult [mReason=" + mReason + ", mErrorCode="
				+ mErrorCode + ", mWeather=" + mWeather + ", mResultcode="
				+ mResultcode + "]";
	}
}