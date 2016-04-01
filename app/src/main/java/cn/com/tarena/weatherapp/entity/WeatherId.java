package cn.com.tarena.weatherapp.entity;


/**
 * 天气ID实体类
 * 
 * @author 张科勇
 * 
 */
public class WeatherId{

	private int mFb;
	private int mFa;
	public WeatherId() {
		super();
	}
	public WeatherId(int mFb, int mFa) {
		super();
		this.mFb = mFb;
		this.mFa = mFa;
	}
	public int getmFb() {
		return mFb;
	}
	public void setmFb(int mFb) {
		this.mFb = mFb;
	}
	public int getmFa() {
		return mFa;
	}
	public void setmFa(int mFa) {
		this.mFa = mFa;
	}
	@Override
	public String toString() {
		return "WeatherId [mFb=" + mFb + ", mFa=" + mFa + "]";
	}


}