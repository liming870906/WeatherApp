package cn.com.tarena.weatherapp.entity;

import java.util.List;

/**
 * 城市总信息实体类
 * 
 * @author 张科勇
 * 
 */
public class CityResult {

	private String mReason;// 返回状态
	private int mErrorCode;// 错误码
	private List<City> mCityInfos;// 城市信息集合
	private int mResultcode;// 返回码

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

	public List<City> getmCityInfos() {
		return mCityInfos;
	}

	public void setmCityInfos(List<City> mCityInfos) {
		this.mCityInfos = mCityInfos;
	}

	public int getmResultcode() {
		return mResultcode;
	}

	public void setmResultcode(int mResultcode) {
		this.mResultcode = mResultcode;
	}

	public CityResult(String mReason, int mErrorCode, List<City> mCityInfos,
			int mResultcode) {
		super();
		this.mReason = mReason;
		this.mErrorCode = mErrorCode;
		this.mCityInfos = mCityInfos;
		this.mResultcode = mResultcode;
	}

	public CityResult() {
		super();
	}

	@Override
	public String toString() {
		return "CityResult [mReason=" + mReason + ", mErrorCode=" + mErrorCode
				+ ", mCityInfos=" + mCityInfos + ", mResultcode=" + mResultcode
				+ "]";
	}

}