package cn.com.tarena.weatherapp.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import cn.com.tarena.weatherapp.R;
import cn.com.tarena.weatherapp.ui.fragment.FragmentFactory;

public class MainAct extends Activity implements View.OnClickListener{

    //底部导航按钮控件
    private Button btnForecast, btnLift, btnCity;
    //标题控件
    private ImageButton ibTitleLeft, ibTitleRight;
    //布局控件
    private DrawerLayout layout;
    private FrameLayout menuLayout;
    //判断是否退出应用程序标记
    private boolean isExit;
    //碎片管理器对象
    private FragmentManager manager;


    /**
     * 初始化控件
     */
    private void initView() {
        btnForecast = (Button) this.findViewById(R.id.btn_navigation_forecast);
        btnLift = (Button) this.findViewById(R.id.btn_navigation_lift);
        btnCity = (Button) this.findViewById(R.id.btn_navigation_city);
        ibTitleLeft = (ImageButton) this.findViewById(R.id.ib_title_left);
        ibTitleRight = (ImageButton) this.findViewById(R.id.ib_title_right);
        layout = (DrawerLayout) this.findViewById(R.id.drawerlayout);
        menuLayout = (FrameLayout)this.findViewById(R.id.activity_menu);
    }

    /**
     * 添加监听器方法
     */
    private void addListener() {
        btnForecast.setOnClickListener(this);
        btnCity.setOnClickListener(this);
        btnLift.setOnClickListener(this);
        ibTitleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //标题左侧图片点击事件监听器
                layout.openDrawer(menuLayout);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        setContentView(R.layout.activity_main);
        //引用初始化方法
        initView();
        //引用添加监听器方法
        addListener();
        //获得碎片管理器对象
        manager = getFragmentManager();
        //初始显示界面
        manager.beginTransaction().add(R.id.fl_home_content, FragmentFactory.createFragement(FragmentFactory.FRAGMENT_TYPE_FORECAST)).commit();
    }

    /**
     * 点击事件方法
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = manager.beginTransaction();
        //判断点击按钮
        switch (v.getId()) {
            case R.id.btn_navigation_forecast:
                //气象预报
                transaction.replace(R.id.fl_home_content, FragmentFactory.createFragement(FragmentFactory.FRAGMENT_TYPE_FORECAST));
                break;
            case R.id.btn_navigation_lift:
                //生活
                transaction.replace(R.id.fl_home_content, FragmentFactory.createFragement(FragmentFactory.FRAGMENT_TYPE_LIFT));
                break;
            case R.id.btn_navigation_city:
                //城市管理
                transaction.replace(R.id.fl_home_content, FragmentFactory.createFragement(FragmentFactory.FRAGMENT_TYPE_CITY));
                break;
        }
        transaction.commit();
    }

    /**
     * 功能键按下方法
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                Toast.makeText(MainAct.this, "再按一次推出应用程序！", Toast.LENGTH_SHORT).show();
                isExit = true;
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
            } else {
                //关闭界面
                finish();
                //推出应用程序
                System.exit(0);
            }
        }
        return false;
    }
}
