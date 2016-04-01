package cn.com.tarena.weatherapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import cn.com.tarena.weatherapp.R;

/**
 * WeatherApp_欢迎界面
 */
public class WelcomeAct extends Activity {
    //声明视图控件——欢迎界面背景
    private ImageView ivWelcome;
    //声明动画对象
    private Animation animation;
    //动画显示时间
    private static final int TIME = 3000;
    //声明动画监听器对象
    private WelcomeAnimationListener listener;

    /**
     * 初始化方法。
     */
    private void initView() {
        //通过数据字典获得对象引用
        ivWelcome = (ImageView) this.findViewById(R.id.iv_act_welcome_background);
    }

    /**
     * 初始化动画对象.
     */
    private void initAnimaiton() {
        //声明动画对象
        animation = new AlphaAnimation(0.0f, 1.0f);
        //设置动画时间
        animation.setDuration(TIME);
        //设置动画监听器方法
        animation.setAnimationListener(listener);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置欢迎界面布局资源
        setContentView(R.layout.activity_welcome);
        //引用初始化控件方法
        initView();
        //声明动画监听器
        listener = new WelcomeAnimationListener();
        //引用初始化动画方法；
        initAnimaiton();
        //开启动画
        ivWelcome.startAnimation(animation);
    }

    /**
     * 自定义动画监听器类
     */
    class WelcomeAnimationListener implements Animation.AnimationListener {

        /**
         * 动画开始方法
         *
         * @param animation
         */
        @Override
        public void onAnimationStart(Animation animation) {
            //监听动画开始
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //监听动画结束
//            Toast.makeText(WelcomeAct.this, "动画结束", Toast.LENGTH_LONG).show();
            //声明意图对象
            Intent intent = new Intent(WelcomeAct.this,MainAct.class);
            //开启动画
            startActivity(intent);
            //关闭界面
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
