package printer.test.interpreter.presenter;


import java.util.List;

import printer.test.interpreter.base.BasePresenter;
import printer.test.interpreter.base.BaseView;

public interface MainPresenter<T extends BaseView> extends BasePresenter<T> {
    /**
     * 请求广告位 接口
     *
     * @param pkgname 应用程序主包名  对于 Android 是应用的 PackageName，对于 iOS 是 BundleIdentifier
     * @param appname 应用程序名称   app 名称，需要 UrlEncode 处理
     * @param ua      系统webview的user-agent  需要 UrlEncode 处理
     * @param appv    应用版本号  例如：1.1.1
     * @param ip      请求设备的公网出口IPv4 地址  例如：211.136.28.18
     * @param brand   ， 例如：nokia，samsung
     * @param model   手机设备型号  例如：n70，galaxy
     * @param uuid    设备唯一标识  对于 IOS 设备，该值为 idfa, 对于 Android 设备，该值为 imei
     * @param pw      备物理屏幕宽度  例如：720
     * @param ph      设备物理屏幕高度  例如：1280
     */
    void requestAdvertisement(String pkgname, String appname, String ua, String appv, String ip, String brand, String model, String uuid, int pw, int ph);

    /**
     * 是否停止请求
     *
     * @param isStar
     */
    void stopOrStart(boolean isStar);

    /**
     * 曝光
     *
     * @param adress
     */
    void baoGuang(String adress, List<String> thclkurl);

    /**
     * 点击
     *
     * @param adress
     */
    void dianJi(String adress);
}
