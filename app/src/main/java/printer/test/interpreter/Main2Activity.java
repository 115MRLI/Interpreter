package printer.test.interpreter;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import printer.test.interpreter.app.App;
import printer.test.interpreter.base.BaseActivity;
import printer.test.interpreter.popupwindow.CommonPopupWindow;
import printer.test.interpreter.presenter.MainPresenter;
import printer.test.interpreter.presenter.impl.MainPresenterImpl;

public class Main2Activity extends BaseActivity implements CommonPopupWindow.ViewInterface, MainView {
    //IP地址展示
    @BindView(R.id.ip_address)
    TextView ipaddress;
    //曝光次数限制
    @BindView(R.id.number)
    EditText number;
    //请求的总次数
    @BindView(R.id.all)
    TextView all;
    //请求成功的次数
    @BindView(R.id.success_number)
    TextView successNumber;
    //一次运行多少次
    @BindView(R.id.once_number)
    EditText onceNumber;
    //间隔时间
    @BindView(R.id.once_time)
    EditText onceTime;
    //点击上报次数控制
    @BindView(R.id.exposure_number)
    EditText exposureNumber;
    //曝光上报的次数
    @BindView(R.id.exposure_appear)
    TextView exposureAppear;
    //曝光上报成功次数
    @BindView(R.id.success_exposure_appear)
    TextView successExposureAppear;
    //点击上报次数
    @BindView(R.id.click_request)
    TextView clickRequest;
    //点击上报成功次数
    @BindView(R.id.success_click_request)
    TextView successClickRequest;
    //手机型号
    @BindView(R.id.phone_model)
    TextView phoneModel;
    //手机厂商
    @BindView(R.id.phone_firim)
    TextView phoneFirim;
    //确定请求按钮
    @BindView(R.id.star_btn)
    Button starBtn;
    //广告位
    @BindView(R.id.top)
    View top;
    //跳转
    @BindView(R.id.jump)
    TextView jump;
    //广告弹出时间
    @BindView(R.id.web_showe)
    EditText webShowe;

    private Main2Activity contetxt;

    private MainPresenter presenter;

    private List<String> thclkurl;
    private List<String> imgtracking;
    private Handler handler = new Handler();
    private Handler Timehandler = new Handler();

    private CommonPopupWindow popupWindow;
    //展示内容
    private String contexturl;

    private boolean iscaozuo = false, isPic;

    private boolean isClick = false;
    private int exposureNumber_o, onceNumber_o, onceTime_o;
    private int allnumber, allnumber2, allnumber3, allnumber4, allnumber5, allnumber6;

    //手机信息集合
    List<PhoneModel> phoneModels = new ArrayList<>();

    private int phonenumber = 0;

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        super.initView();
        contetxt = this;

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        presenter = new MainPresenterImpl();
        presenter.attachView(this);
        ipaddress.setText(Utils.getIP(contetxt));
        phoneModel.setText(android.os.Build.MODEL + "");
        phoneFirim.setText(android.os.Build.MANUFACTURER + "");
        exposureNumber.setText(10 + "");
        onceNumber.setText(40 + "");
        onceTime.setText(2 + "");
        webShowe.setText(4 + "");
        //跳转
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main3Activity.jumpHere(contetxt);
            }
        });
        //开始请求
        starBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClick == true) {
                    starBtn.setText("开始");
                    if (popupWindow != null) {
                        popupWindow.dismiss();

                    }
                    OperationUtils.saveId(OperationUtils.getId() + Integer.parseInt(successNumber.getText().toString()));
                    OperationUtils.savePartnerId(OperationUtils.getPartnerId() + Integer.parseInt(all.getText().toString()));
                    OperationUtils.savePassword(OperationUtils.getPassword() + Integer.parseInt(clickRequest.getText().toString()));
                    OperationUtils.saveRoleId(OperationUtils.getRoleId() + Integer.parseInt(successClickRequest.getText().toString()));
                    OperationUtils.saveUserName(OperationUtils.getUserName() + Integer.parseInt(exposureAppear.getText().toString()));
                    OperationUtils.saveLanguage(OperationUtils.getLanguage() + Integer.parseInt(successExposureAppear.getText().toString()));
                    Timehandler.removeCallbacks(Timerunnable);
                    handler.removeCallbacks(runnable);
                } else {
                    starBtn.setText("停止");
                    exposureNumber_o = Integer.parseInt(exposureNumber.getText().toString());
                    onceNumber_o = Integer.parseInt(onceNumber.getText().toString());
                    onceTime_o = Integer.parseInt(onceTime.getText().toString());
                    handler.postDelayed(runnable, 500);
                    Timehandler.postDelayed(Timerunnable, onceTime_o * 1000);
                }
                isClick = !isClick;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        Timehandler.removeCallbacks(Timerunnable);
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void getIntentData() {
        super.getIntentData();
        phoneModels.add(new PhoneModel("vivo y31", "vivo", "865166025714091"));
        phoneModels.add(new PhoneModel("a37f", "oppo", "865166021309441"));
        phoneModels.add(new PhoneModel("r8207", "oppo", "865166028813817"));
        phoneModels.add(new PhoneModel("hm 2a", "xiaomi", "865166029185694"));
        phoneModels.add(new PhoneModel("sm-g610f", "samsung", "865166021908101"));
        phoneModels.add(new PhoneModel("vivo y35", "vivo", "865166022382314"));
        phoneModels.add(new PhoneModel("f100", "gionee", "865166029381095"));
        phoneModels.add(new PhoneModel("huawei tag-tl00", "huawei", "865166026920911"));
        phoneModels.add(new PhoneModel("h60-l01", "huawei", "865166028324484"));
        phoneModels.add(new PhoneModel("r7plus", "oppo", "865166026501265"));
        phoneModels.add(new PhoneModel("oppo r9s", "oppo", "865166022364965"));
        phoneModels.add(new PhoneModel("vivo x5m", "vivo", "865166026208671"));
        phoneModels.add(new PhoneModel("oppo r9 plustm a", "oppo", "865166027941478"));
        phoneModels.add(new PhoneModel("vivo x6plus d", "vivo", "865166020623693"));
        phoneModels.add(new PhoneModel("vivo y55a", "vivo", "865166029921064"));
        phoneModels.add(new PhoneModel("vivo y27", "vivo", "865166028094988"));
        phoneModels.add(new PhoneModel("gt-n7100", "samsung", "865166023859666"));
        phoneModels.add(new PhoneModel("a37f", "oppo", "865166021006278"));
        phoneModels.add(new PhoneModel("eva-al10", "huawei", "865166028306838"));
        phoneModels.add(new PhoneModel("mi pad", "xiaomi", "865166024148341"));
        phoneModels.add(new PhoneModel("sm-g530h", "samsung", "865166022452802"));
        phoneModels.add(new PhoneModel("m2", "meizu", "865166026714843"));
        phoneModels.add(new PhoneModel("h60-l01", "huawei", "865166028890989"));
        phoneModels.add(new PhoneModel("m1 note", "meizu", "865166026180524"));
        phoneModels.add(new PhoneModel("oppo r9s", "oppo", "865166021740835"));
        phoneModels.add(new PhoneModel("vivo x7plus", "vivo", "865166026258544"));
        phoneModels.add(new PhoneModel("oppo a37m", "oppo", "865166029003343"));
        phoneModels.add(new PhoneModel("mi 4lte", "xiaomi", "865166028012634"));
    }

    @Override
    public void getShowText(String context, boolean isPic, List<String> thclkurl, List<String> imgtracking) {
        contexturl = context;
        this.isPic = isPic;
        Log.e("contexturl", "contexturl :" + contexturl + "isPic  :" + isPic);

    }

    @Override
    public void addResNumber(int number) {
        allnumber6 = Integer.parseInt(all.getText().toString()) + number;
        viewHandler.sendEmptyMessage(6);
        if (phonenumber == phoneModels.size()-1) {
            phonenumber = 0;
        } else {
            phonenumber = phonenumber + 1;
        }

        if (onceNumber_o == 1) {
            if (popupWindow != null) {
                popupWindow.dismiss();
                handler.removeCallbacks(runnable);
                OperationUtils.saveId(OperationUtils.getId() + Integer.parseInt(successNumber.getText().toString()));
                OperationUtils.savePartnerId(OperationUtils.getPartnerId() + Integer.parseInt(all.getText().toString()));
                OperationUtils.savePassword(OperationUtils.getPassword() + Integer.parseInt(clickRequest.getText().toString()));
                OperationUtils.saveRoleId(OperationUtils.getRoleId() + Integer.parseInt(successClickRequest.getText().toString()));
                OperationUtils.saveUserName(OperationUtils.getUserName() + Integer.parseInt(exposureAppear.getText().toString()));
                OperationUtils.saveLanguage(OperationUtils.getLanguage() + Integer.parseInt(successExposureAppear.getText().toString()));

            }
            return;
        }
        handler.postDelayed(runnable, 500);
        onceNumber_o = onceNumber_o - 1;
    }

    @Override
    public void addSuccessNumber(int number, List<String> imgtracking, List<String> thclkurl) {
        allnumber = Integer.parseInt(successNumber.getText().toString()) + number;

        viewHandler.sendEmptyMessage(1);
        if (imgtracking != null) {
            this.imgtracking = imgtracking;
            for (int i = 0; i < imgtracking.size(); i++) {
                presenter.baoGuang(imgtracking.get(i), thclkurl);
            }
        }


    }

    @Override
    public void clickRequestFunAll(int number) {
        allnumber2 = Integer.parseInt(clickRequest.getText().toString()) + number;
        viewHandler.sendEmptyMessage(2);

    }

    @Override
    public void clickRequestFunSuccess(int number) {
        allnumber3 = Integer.parseInt(successClickRequest.getText().toString()) + number;
        viewHandler.sendEmptyMessage(3);


    }

    @Override
    public void exposureAppearAll(int number) {
        allnumber4 = Integer.parseInt(exposureAppear.getText().toString()) + number;
        viewHandler.sendEmptyMessage(4);
    }

    @Override
    public void exposureAppearFail(int number) {

    }

    @Override
    public void exposureAppearAgin(int bunber) {

    }

    @Override
    public void exposureAppearSuccess(int number, List<String> thclkurl) {
        allnumber5 = Integer.parseInt(successExposureAppear.getText().toString()) + number;
        viewHandler.sendEmptyMessage(5);
        if (allnumber5 % exposureNumber_o == 0) {
            if (thclkurl != null) {
                for (int i = 0; i < thclkurl.size(); i++) {
                    presenter.dianJi(thclkurl.get(i));
                }
            }
        }
    }

    @Override
    public void getChildView(View view, int layoutResId) {
        switch (layoutResId) {
            case R.layout.pic_layout:
                ImageView pic = view.findViewById(R.id.pic_show);
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.error(R.mipmap.jugao);//异常时候显示的图片
                requestOptions.placeholder(R.mipmap.jugao);//加载成功前显示的图片
                requestOptions.fallback(R.mipmap.jugao); //url为空的时候,显示的图片
                requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE); //不缓存
                Glide.with(App.mContext).load(contexturl).apply(requestOptions).into(pic);
                view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                view.findViewById(R.id.pic_line).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i = 0; i < thclkurl.size(); i++) {
                            presenter.dianJi(thclkurl.get(i));
                            Log.e("adress", "pic   " + thclkurl.get(i));
                        }
                    }
                });
                break;
            case R.layout.web_layout:
                WebView webView = view.findViewById(R.id.show_context);
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setAppCacheEnabled(false);
                settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                        if (thclkurl != null) {
//                            for (int i = 0; i < thclkurl.size(); i++) {
//                                presenter.dianJi(thclkurl.get(i));
//                                Log.e("adress", "web   " + thclkurl.get(i));
//                            }
//                        }
//                        iscaozuo = true;
//                        Intent intent = new Intent();
//                        intent.setAction("android.intent.action.VIEW");
//                        Uri content_url = Uri.parse(url);
//                        intent.setData(content_url);
//                        startActivity(intent);
                        return true;
                    }
                });
                webView.loadDataWithBaseURL(null, contexturl, "text/html;charset=utf-8", "utf-8", null);
                view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();

                    }
                });

                break;
        }
    }

    /**
     * 跳转到本页面
     *
     * @param activity
     */
    public static void jumpHere(Activity activity) {
        activity.startActivity(new Intent(activity, Main2Activity.class));
    }

    /**
     * 请求网络数据
     */
    private void reqData() {
        ipaddress.setText(Utils.getIP(contetxt));
        final PhoneModel phone = phoneModels.get(phonenumber);

        phoneModel.setText(phone.getPhoneModel());
        phoneFirim.setText(phone.getPhoneFirim());
        String ua = "";
        Display display = getWindowManager().getDefaultDisplay();
        final int heigth = display.getHeight();
        final int width = display.getWidth();
        try {
            ua = Utils.changeURLEncoding(Utils.getUserAgent(contetxt));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final String finalUa = ua;
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    presenter.requestAdvertisement("com.fanyiguan", Utils.changeURLEncoding("翻译官"), finalUa, "1.1.0", Utils.getIP(contetxt), phone.getPhoneFirim(), phone.getPhoneModel(), phone.getUuid(), width, heigth);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    //向上弹出
    public void showUpPop(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(this).setView(R.layout.web_layout).setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).setViewOnclickListener(this).setOutsideTouchable(true).create();
        popupWindow.showAsDropDown(view);

    }

    //向上弹出
    public void showUpPopPic(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(this).setView(R.layout.pic_layout).setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).setViewOnclickListener(this).create();
        popupWindow.showAsDropDown(view, 0, -(popupWindow.getHeight() + view.getMeasuredHeight()));

    }

    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            //要做的事情，这里再次调用此Runnable对象，以实现每两秒实现一次的定时器操作
            reqData();
        }
    };

    Runnable Timerunnable = new Runnable() {


        @Override
        public void run() {
            //要做的事情，这里再次调用此Runnable对象，以实现每两秒实现一次的定时器操作
            startReqDta();
        }
    };


    private void startReqDta() {
        exposureNumber_o = Integer.parseInt(exposureNumber.getText().toString());
        onceNumber_o = Integer.parseInt(onceNumber.getText().toString());
        onceTime_o = Integer.parseInt(onceTime.getText().toString());
        handler.postDelayed(runnable, 500);
        Timehandler.postDelayed(Timerunnable, onceTime_o * 1000);
    }

    private Handler viewHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    successNumber.setText(allnumber + "");
                    break;
                case 2:
                    clickRequest.setText(allnumber2 + "");
                    break;
                case 3:
                    successClickRequest.setText(allnumber3 + "");
                    if (isPic == true) {

                        showUpPopPic(top);
                    } else {
                        showUpPop(top);
                    }
                    CountDownTimer countDownTimer = new CountDownTimer(Integer.parseInt(webShowe.getText().toString()) * 1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            viewHandler.sendEmptyMessage(10);
                        }
                    }.start();
                    break;
                case 4:
                    exposureAppear.setText(allnumber4 + "");
                    break;
                case 5:
                    successExposureAppear.setText(allnumber5 + "");
                    break;
                case 6:
                    all.setText(allnumber6 + "");
                    break;
                case 10:
                    if (popupWindow != null && popupWindow.isShowing())
                        popupWindow.dismiss();
                    break;
            }
        }
    };
}
