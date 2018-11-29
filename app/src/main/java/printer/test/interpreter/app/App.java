package printer.test.interpreter.app;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.SupportActivity;


import java.util.HashSet;
import java.util.Set;


/**
 * 程序初始化
 */
public class App extends Application {
    private static App instance;
    private Set<FragmentActivity> allActivities;
    public static Context mContext;

    /**
     * 获取自定义Application
     *
     * @return
     */
    public static App getInstance() {
        return instance;

    }

    public static Context getmContext() {
        if (instance != null) {
            return instance;
        } else {
            return instance.getApplicationContext();
        }
    }
    /**
     * 注册当前Activity到集合
     *
     * @param act 当前的activity
     */
    public void registerActivity(FragmentActivity act) {
        if (allActivities == null) {
            allActivities = new HashSet<FragmentActivity>();
        }
        allActivities.add(act);
    }

    /**
     * 从集合中清除当前 activity
     *
     * @param act
     */
    public void unregisterActivity(SupportActivity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 退出程序
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (FragmentActivity act : allActivities) {
                    if (act != null && !act.isFinishing()) act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mContext = getApplicationContext();
    }
}
