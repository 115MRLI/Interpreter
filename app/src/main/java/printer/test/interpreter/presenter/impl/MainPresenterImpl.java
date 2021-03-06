package printer.test.interpreter.presenter.impl;

import android.util.Log;
import android.widget.Toast;


import java.util.List;

import printer.test.interpreter.MainView;
import printer.test.interpreter.ResponseData;
import printer.test.interpreter.Utils;
import printer.test.interpreter.app.App;
import printer.test.interpreter.http.response.BaoGuang;
import printer.test.interpreter.http.response.JuGaoModel;
import printer.test.interpreter.presenter.MainPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl<T extends MainView> implements MainPresenter<T> {
    private T baseView;
    private JuGaoModel model;
    private boolean isStrart = true;
    private BaoGuang baoGuang;

    public MainPresenterImpl() {
        model = new JuGaoModel();
        baoGuang = new BaoGuang();
    }

    @Override
    public void requestAdvertisement(String pkgname, String appname, String ua, String appv, String ip, String brand, String models, String uuid, int pw, int ph) {
        if (isStrart == false) {
            return;
        }
        if (Utils.isNetConnected(App.getmContext())) {
            model.requestAdvertisement(pkgname, appname, ua, appv, ip, brand, models, uuid, pw, ph, new Callback<ResponseData>() {

                @Override
                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                    if (response.code() == 200) {
                        //响应码
                        //200：有广告 204：无广告
                        Log.e("Response", response.toString());
                        Log.e("Response", response.body().toString());
                        if (Integer.parseInt(response.body().getReturncode()) == 200) {
                            Log.e("Response*************", response.toString());
                            if (Integer.parseInt(response.body().getAdnum()) > 0) {
                                ResponseData.AdsBean adsBean = response.body().getAds().get(0);
                                Log.e("Response", adsBean.toString());
                                if (adsBean.getAdmt() == 4) {
                                    if (baseView != null) {
                                        baseView.getShowText(adsBean.getAdm(), false, adsBean.getThclkurl(), adsBean.getImgtracking());
                                    }
                                } else {
                                    if (baseView != null) {
                                        baseView.getShowText(adsBean.getImgurl(), true, adsBean.getThclkurl(), adsBean.getImgtracking());
                                    }
                                }
                                if (baseView != null) {
                                    baseView.addResNumber(1);
                                    baseView.addSuccessNumber(1, adsBean.getImgtracking(), adsBean.getThclkurl());
                                }
                            }

                        } else {
                            Log.e("Response------------", response.toString());
                            if (baseView != null) {
                                baseView.addResNumber(1);
                            }
                        }

                    } else {
                        if (baseView != null) {
                            baseView.addResNumber(1);
                        }
                    }

                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {
                    if (baseView != null) {
                        baseView.addResNumber(1);
                    }
                }
            });

        } else {
            Toast.makeText(App.getmContext(), "请检查网络连接", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void stopOrStart(boolean isStar) {
        this.isStrart = isStar;
    }

    @Override
    public void baoGuang(final String adress, final List<String> thclkurl) {
        Log.e("曝光", "曝光" + adress);
        baoGuang.baoGuang(adress, new BaoGuang.NotificationInterface() {
            @Override
            public void onResponseCode(int code) {
                if (code == 200) {
                    if (baseView != null) {
                        baseView.exposureAppearSuccess(1, thclkurl);
                    }
                } else {
                    baseView.exposureAppearFail(1);
                    BaoGuangAgin(adress, thclkurl);
                }
                if (baseView != null) {
                    baseView.exposureAppearAll(1);
                }
            }
        });
    }

    /**
     * 曝光补发
     *
     * @param adress
     */
    private void BaoGuangAgin(String adress, final List<String> thclkurl) {
        Log.e("曝光", "曝光" + adress);
        baoGuang.baoGuang(adress, new BaoGuang.NotificationInterface() {
            @Override
            public void onResponseCode(int code) {
                if (code == 200) {
                    if (baseView != null) {
                        baseView.exposureAppearSuccess(1, thclkurl);
                    }
                } else {
                    baseView.exposureAppearFail(1);
                }
                if (baseView != null) {
                    baseView.exposureAppearAgin(1);
                }
            }
        });

    }

    @Override
    public void dianJi(String adress) {
        Log.e("曝光", "点击" + adress);
        baoGuang.dianJi(adress, new BaoGuang.NotificationInterface() {
            @Override
            public void onResponseCode(int code) {
                if (code == 200) {
                    if (baseView != null) {
                        baseView.clickRequestFunSuccess(1);
                    }

                }
                if (baseView != null) {
                    baseView.clickRequestFunAll(1);
                }
            }
        });

    }

    @Override
    public void attachView(T baseView) {
        this.baseView = baseView;
    }

    @Override
    public void detachView() {
        baseView = null;
    }
}
