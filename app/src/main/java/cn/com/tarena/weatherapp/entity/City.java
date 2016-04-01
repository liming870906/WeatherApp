package cn.com.tarena.weatherapp.entity;

import java.io.Serializable;


/**
 * 城市实体类
 * 
 * @author 张科勇
 * 
 */
public class City implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mId;// 城市ID
	private String mCity;// 城市名
	private String mDistrict;// 市区
	private String mProvince;// 省
	private String mPinYin;// 城市名拼音
	private String mPy;
	private double mLatitude;// 纬度
	private double mLongitude;// 经度

	/**
	 * 构造方法
	 */
	public City() {
	}

	public City(String id, String city, String district, String province,
			String pinYin, String py, double latitude, double longitude) {
		this.mId = id;
		this.mCity = city;
		this.mDistrict = district;
		this.mProvince = province;
		this.mPinYin = pinYin;
		this.mPy = py;
		this.mLatitude = latitude;
		this.mLongitude = longitude;
	}

	/**
	 * getter,setter方法
	 * 
	 * @return
	 */
	public String getId() {
		return mId;
	}

	public void setId(String id) {
		this.mId = id;
	}

	public String getCity() {
		return mCity;
	}

	public void setCity(String city) {
		this.mCity = city;
	}

	public String getDistrict() {
		return mDistrict;
	}

	public void setDistrict(String district) {
		this.mDistrict = district;
	}

	public String getProvince() {
		return mProvince;
	}

	public void setProvince(String province) {
		this.mProvince = province;
	}

	public String getPinYin() {
		return mPinYin;
	}

	public void setPinYin(String pinYin) {
		this.mPinYin = pinYin;
	}

	public String getPy() {
		return mPy;
	}

	public void setPy(String py) {
		this.mPy = py;
	}

	public double getLatitude() {
		return mLatitude;
	}

	public void setLatitude(double latitude) {
		this.mLatitude = latitude;
	}

	public double getLongitude() {
		return mLongitude;
	}

	public void setLongitude(double longitude) {
		this.mLongitude = longitude;
	}
	@Override
	public String toString() {
		return "City [mId=" + mId + ", mCity=" + mCity + ", mDistrict="
				+ mDistrict + ", mProvince=" + mProvince + ", mPinYin="
				+ mPinYin + ", mPy=" + mPy + ", mLatitude=" + mLatitude
				+ ", mLongitude=" + mLongitude + "]";
	}

}