package printer.test.interpreter;


import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import butterknife.BindView;
import printer.test.interpreter.base.BaseActivity;

public class Main3Activity extends BaseActivity {
    //历史记录，请求总次数
    @BindView(R.id.all_n)
    TextView all_n;

    //历史记录，请求成功次数
    @BindView(R.id.success_n)
    TextView success_n;
    //历史记录，曝光上报总次数
    @BindView(R.id.all_n_e)
    TextView all_n_e;
    //历史记录，曝光上报成功次数
    @BindView(R.id.success_n_exx)
    TextView success_n_e;
    //历史记录，点击上报总次数
    @BindView(R.id.all_n_c)
    TextView all_n_c;
    //历史记录，点击上报成功次数
    @BindView(R.id.success_n_c)
    TextView success_n_c;
    //历史记录，bao guang shi bai
    @BindView(R.id.e_en_c)
    TextView e_en_c;
    //历史记录，bao guang bu fa
    @BindView(R.id.e_n_c)
    TextView e_n_c;

    @Override
    protected int getLayout() {
        return R.layout.activity_main3;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        //历史记录，请求总次数
        all_n.setText(OperationUtils.getPartnerId() + "");
        //历史记录，请求成功次数
        success_n.setText(OperationUtils.getId() + "");
        //历史记录，曝光上报总次数
        all_n_e.setText(OperationUtils.getUserName() + "");
        //历史记录，曝光上报成功次数
        success_n_e.setText(OperationUtils.getLanguage() + "");
        //历史记录，点击上报总次数
        all_n_c.setText(OperationUtils.getPassword() + "");
        //历史记录，点击上报成功次数
        success_n_c.setText(OperationUtils.getRoleId() + "");
        //曝光失败
        e_en_c.setText(OperationUtils.getexposureAppearFail()+"");
        //曝光不发
        e_n_c.setText(OperationUtils.getexposureAppearAgin()+"");
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
        activity.startActivity(new Intent(activity, Main3Activity.class));
    }
}
