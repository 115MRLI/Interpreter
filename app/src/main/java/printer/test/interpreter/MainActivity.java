package printer.test.interpreter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import printer.test.interpreter.app.App;
import printer.test.interpreter.base.BaseActivity;
import printer.test.interpreter.popupwindow.CommonPopupWindow;
import printer.test.interpreter.presenter.MainPresenter;
import printer.test.interpreter.presenter.impl.MainPresenterImpl;

public class MainActivity extends BaseActivity implements CommonPopupWindow.ViewInterface, MainView {
    private CommonPopupWindow popupWindow;
    private LinearLayout mubiao, star_lang;
    private List<Language> languages = new ArrayList<>();
    private boolean isstar_lang = true;
    @BindView(R.id.star_lan_iv)
    ImageView star_lan_iv;
    @BindView(R.id.star_lan_tv)
    TextView star_lan_tv;
    @BindView(R.id.mubiao_iv)
    ImageView mubiao_iv;
    @BindView(R.id.mubiao_tv)
    TextView mubiao_tv;

    @BindView(R.id.jiaohuan)
    TextView jiaohuan;
    @BindView(R.id.top)
    View top;

    @BindView(R.id.jump)
    Button jump;
    //展示内容
    private String contexturl;
    private MainPresenter presenter;

    private List<String> thclkurl;
    private List<String> imgtracking;

    private boolean ispp = true;

    private boolean iscaozuo = false;
    private Handler handler = new Handler();

    @Override
    protected int getLayout() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent() {

        super.initEvent();
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.jumpHere(MainActivity.this);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
//        reqData();
    }

    /**
     * 请求网络数据
     */
    private void reqData() {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }

        iscaozuo = false;
        String ua = "";
        Display display = getWindowManager().getDefaultDisplay();
        final int heigth = display.getHeight();
        final int width = display.getWidth();
        Log.e("jugao", "heigth：" + heigth + "   width  " + width + "  osv :" + Utils.getSDK());
        try {
            ua = Utils.changeURLEncoding(Utils.getUserAgent(MainActivity.this));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final String finalUa = ua;
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    presenter.requestAdvertisement("com.fanyiguan", Utils.changeURLEncoding("翻译官"), finalUa, "1.1.0", Utils.getIP(MainActivity.this), android.os.Build.MANUFACTURER + "", android.os.Build.MODEL, Utils.getIMEI(MainActivity.this), width, heigth);

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (popupWindow != null) {
            popupWindow.dismiss();
            handler.removeCallbacks(runnable);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    protected void initView() {
        presenter = new MainPresenterImpl();
        presenter.attachView(this);
        mubiao = findViewById(R.id.mubiao);
        star_lang = findViewById(R.id.star_lang);
        languages.add(new Language(R.mipmap.bg, "Bulgarian"));
        languages.add(new Language(R.mipmap.um, "English"));
        languages.add(new Language(R.mipmap.cn, "Chinese"));
        languages.add(new Language(R.mipmap.tw, "Chinese traditional"));
        languages.add(new Language(R.mipmap.fi, "Finnish"));
        languages.add(new Language(R.mipmap.fr, "French"));
        languages.add(new Language(R.mipmap.dk, "Danish"));
        languages.add(new Language(R.mipmap.jp, "Japanese"));
        languages.add(new Language(R.mipmap.kr, "Korean"));
        languages.add(new Language(R.mipmap.no, "Norwegian"));
        languages.add(new Language(R.mipmap.ph, "Filipino"));
        languages.add(new Language(R.mipmap.pe, "Peru"));
        languages.add(new Language(R.mipmap.cz, "Czech"));
        languages.add(new Language(R.mipmap.va, "Vaticano"));
        languages.add(new Language(R.mipmap.sl, "Slovenian"));
        star_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isstar_lang = true;
                showAll();
            }
        });
        mubiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isstar_lang = false;
                showAll();
            }
        });
        jiaohuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = mubiao_iv.getBackground();
                Drawable drawable2 = star_lan_iv.getBackground();
                String str1 = mubiao_tv.getText().toString();
                String str2 = star_lan_tv.getText().toString();
                star_lan_iv.setBackground(drawable);
                mubiao_iv.setBackground(drawable2);
                star_lan_tv.setText(str1);
                mubiao_tv.setText(str2);
            }
        });
    }

    //向上弹出
    public void showUpPop(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(this).setView(R.layout.web_layout).setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).setViewOnclickListener(this).create();
        popupWindow.showAsDropDown(view, 0, -(popupWindow.getHeight() + view.getMeasuredHeight()));

    }

    //向上弹出
    public void showUpPop2(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(this).setView(R.layout.web_layout).setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT).setViewOnclickListener(this).create();
        popupWindow.showAsDropDown(view, 0, -(popupWindow.getHeight() + view.getMeasuredHeight()));

    }

    //向上弹出
    public void showUpPopPic(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(this).setView(R.layout.pic_layout).setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).setViewOnclickListener(this).create();
        popupWindow.showAsDropDown(view, 0, -(popupWindow.getHeight() + view.getMeasuredHeight()));

    }

    //全屏弹出
    public void showAll() {
        if (popupWindow != null && popupWindow.isShowing()) return;
        View upView = LayoutInflater.from(this).inflate(R.layout.popup_up, null);
        //测量View的宽高
        Utils.measureWidthAndHeight(upView);
        popupWindow = new CommonPopupWindow.Builder(this).setView(R.layout.popup_up)
//                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, upView.getMeasuredHeight())
                .setBackGroundLevel(0.5f)//取值范围0.0f-1.0f 值越小越暗
                .setAnimationStyle(R.style.AnimUp).setViewOnclickListener(this).create();
        popupWindow.showAtLocation(findViewById(android.R.id.content), Gravity.CENTER, 0, 0);
    }

    @Override
    public void getChildView(View view, int layoutResId) {
        switch (layoutResId) {
            case R.layout.popup_up:
                TextView title = view.findViewById(R.id.title);
                RecyclerView lan_list = view.findViewById(R.id.lan_list);
                lan_list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                LanguageAdapter languageAdapter = new LanguageAdapter(languages);
                lan_list.setAdapter(languageAdapter);
                if (isstar_lang == true) {
                    title.setText("始源语言:  ");
                } else {
                    title.setText("目标语言:  ");
                }
                languageAdapter.setOnClickListenerItime(new LanguageAdapter.OnClickListenerItime() {
                    @Override
                    public void onItime(Language language) {
                        if (isstar_lang == true) {
                            star_lan_iv.setBackgroundResource(language.getPic());
                            star_lan_tv.setText(language.getLanguage());
                        } else {
                            mubiao_iv.setBackgroundResource(language.getPic());
                            mubiao_tv.setText(language.getLanguage());
                        }

                        popupWindow.dismiss();
                    }
                });
                break;
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
                        if (thclkurl != null) {
                            for (int i = 0; i < thclkurl.size(); i++) {
                                presenter.dianJi(thclkurl.get(i));
                                Log.e("adress", "web   " + thclkurl.get(i));
                            }
                        }
                        iscaozuo = true;
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        startActivity(intent);
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

    @Override
    public void getShowText(String context, boolean isPic, List<String> thclkurl, List<String> imgtracking) {

        contexturl = context;
        Log.e("contexturl", "contexturl :" + contexturl + "isPic  :" + isPic);
        if (isPic == true) {

            showUpPopPic(top);
        } else {
            showUpPop(top);
        }

    }


    @Override
    public void addResNumber(int number) {
        handler.postDelayed(runnable, 120000);
    }

    @Override
    public void addSuccessNumber(int number, List<String> imgtracking, List<String> thclkurl) {
        ispp = false;
        if (imgtracking != null) {
            this.imgtracking = imgtracking;
            for (int i = 0; i < imgtracking.size(); i++) {
                presenter.baoGuang(imgtracking.get(i));
            }
        }
        this.thclkurl = thclkurl;


    }

    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            //要做的事情，这里再次调用此Runnable对象，以实现每两秒实现一次的定时器操作
            reqData();
        }
    };
}
