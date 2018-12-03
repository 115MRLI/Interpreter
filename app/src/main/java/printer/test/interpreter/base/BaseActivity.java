package printer.test.interpreter.base;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;



import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import printer.test.interpreter.CrashHandler;

/**
 * @name 海獭
 */
public abstract class BaseActivity extends FragmentActivity {
    protected Activity mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(this.getClass() + "", this.getClass().getName() + "------>onCreate");
        setContentView(getLayout());
        CrashHandler.getInstance().init(this);//初始化全局异常管理
        mContext = this;
        mUnBinder = ButterKnife.bind(this);
        initView();
        initEvent();
        getIntentData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(this.getClass() + "", this.getClass().getName() + "------>onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(this.getClass() + "", this.getClass().getName() + "------>onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(this.getClass() + "", this.getClass().getName() + "------>onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(this.getClass() + "", this.getClass().getName() + "------>onDestroy");
        if (mUnBinder != null) mUnBinder.unbind();
//        ta.hai.app.App.getInstance().unregisterActivity(this);
    }

    /**
     * 设置沉浸式
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

    protected void setWindowFullScreen() {
        //设置全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= 19) {
            // 虚拟导航栏透明
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 切换英文
     */
    public void en() {
        Resources resources = getResources();// 获得res资源对象
        Configuration config = resources.getConfiguration();// 获得设置对象
        DisplayMetrics dm = resources.getDisplayMetrics();// 获得屏幕参数：主要是分辨率，像素等。
        config.locale = Locale.ENGLISH; // 英文
        resources.updateConfiguration(config, dm);
    }

    /**
     * 将string文件的值转成string类型
     *
     * @param strings
     * @return
     */
    public String changeString(int strings) {
        return getResources().getString(strings);
    }
    protected abstract int getLayout();

    /**
     * 初始化页面
     */
    protected void initView() {
    }

    /**
     * 设置监听
     */
    protected void initEvent() {
    }

    /**
     * 设置数据
     */
    protected void getIntentData() {
    }
}
