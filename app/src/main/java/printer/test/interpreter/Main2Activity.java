package printer.test.interpreter;


import android.app.Activity;
import android.content.Intent;

import printer.test.interpreter.base.BaseActivity;

public class Main2Activity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
    }

    @Override
    protected void getIntentData() {
        super.getIntentData();
    }

    /**
     * 跳转到本页面
     *
     * @param activity
     */
    public static void jumpHere(Activity activity) {
        activity.startActivity(new Intent(activity, Main2Activity.class));
    }
}
