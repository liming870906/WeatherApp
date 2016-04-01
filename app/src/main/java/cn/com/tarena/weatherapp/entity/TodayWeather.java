package cn.com.tarena.weatherapp.entity;


/**
 * 今日天气实体类
 * 
 * @author 张科勇
 * 
 */
public class TodayWeather {
	private String mDressingAdvice;
	private String mWind;
	private String mDateY;
	private String mDryingIndex;
	private String mTravelIndex;
	private String mUvIndex;
	private String mCity;
	private String mWeek;
	private String mDressingIndex;
	private String mComfortIndex;
	private String mWashIndex;
	private String mTemperature;
	private WeatherId mWeatherId;
	private String mExerciseIndex;
	private String mWeather;

	public TodayWeather() {
		super();
	}

	public TodayWeather(String mDressingAdvice, String mWind, String mDateY,
			String mDryingIndex, String mTravelIndex, String mUvIndex,
			String mCity, String mWeek, String mDressingIndex,
			String mComfortIndex, String mWashIndex, String mTemperature,
			WeatherId mWeatherId, String mExerciseIndex, String mWeather) {
		super();
		this.mDressingAdvice = mDressingAdvice;
		this.mWind = mWind;
		this.mDateY = mDateY;
		this.mDryingIndex = mDryingIndex;
		this.mTravelIndex = mTravelIndex;
		this.mUvIndex = mUvIndex;
		this.mCity = mCity;
		this.mWeek = mWeek;
		this.mDressingIndex = mDressingIndex;
		this.mComfortIndex = mComfortIndex;
		this.mWashIndex = mWashIndex;
		this.mTemperature = mTemperature;
		this.mWeatherId = mWeatherId;
		this.mExerciseIndex = mExerciseIndex;
		this.mWeather = mWeather;
	}

	public String getmDressingAdvice() {
		return mDressingAdvice;
	}

	public void setmDressingAdvice(String mDressingAdvice) {
		this.mDressingAdvice = mDressingAdvice;
	}

	public String getmWind() {
		return mWind;
	}

	public void setmWind(String mWind) {
		this.mWind = mWind;
	}

	public String getmDateY() {
		return mDateY;
	}

	public void setmDateY(String mDateY) {
		this.mDateY = mDateY;
	}

	public String getmDryingIndex() {
		return mDryingIndex;
	}

	public void setmDryingIndex(String mDryingIndex) {
		this.mDryingIndex = mDryingIndex;
	}

	public String getmTravelIndex() {
		return mTravelIndex;
	}

	public void setmTravelIndex(String mTravelIndex) {
		this.mTravelIndex = mTravelIndex;
	}

	public String getmUvIndex() {
		return mUvIndex;
	}

	public void setmUvIndex(String mUvIndex) {
		this.mUvIndex = mUvIndex;
	}

	public String getmCity() {
		return mCity;
	}

	public void setmCity(String mCity) {
		this.mCity = mCity;
	}

	public String getmWeek() {
		return mWeek;
	}

	public void setmWeek(String mWeek) {
		this.mWeek = mWeek;
	}

	public String getmDressingIndex() {
		return mDressingIndex;
	}

	public void setmDressingIndex(String mDressingIndex) {
		this.mDressingIndex = mDressingIndex;
	}

	public String getmComfortIndex() {
		return mComfortIndex;
	}

	public void setmComfortIndex(String mComfortIndex) {
		this.mComfortIndex = mComfortIndex;
	}

	public String getmWashIndex() {
		return mWashIndex;
	}

	public void setmWashIndex(String mWashIndex) {
		this.mWashIndex = mWashIndex;
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

	public String getmExerciseIndex() {
		return mExerciseIndex;
	}

	public void setmExerciseIndex(String mExerciseIndex) {
		this.mExerciseIndex = mExerciseIndex;
	}

	public String getmWeather() {
		return mWeather;
	}

	public void setmWeather(String mWeather) {
		this.mWeather = mWeather;
	}

	@Override
	public String toString() {
		return "TodayWeather [mDressingAdvice=" + mDressingAdvice + ", mWind="
				+ mWind + ", mDateY=" + mDateY + ", mDryingIndex="
				+ mDryingIndex + ", mTravelIndex=" + mTravelIndex
				+ ", mUvIndex=" + mUvIndex + ", mCity=" + mCity + ", mWeek="
				+ mWeek + ", mDressingIndex=" + mDressingIndex
				+ ", mComfortIndex=" + mComfortIndex + ", mWashIndex="
				+ mWashIndex + ", mTemperature=" + mTemperature
				+ ", mWeatherId=" + mWeatherId + ", mExerciseIndex="
				+ mExerciseIndex + ", mWeather=" + mWeather + "]";
	}

}