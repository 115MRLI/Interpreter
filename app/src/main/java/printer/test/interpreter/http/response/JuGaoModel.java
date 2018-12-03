package printer.test.interpreter.http.response;

import android.util.DisplayMetrics;
import android.view.Display;

import printer.test.interpreter.Utils;
import printer.test.interpreter.app.App;
import printer.test.interpreter.http.api.JuGaoApi;
import printer.test.interpreter.http.api.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * 聚告请求网络控制器
 */
public class JuGaoModel {
    private JuGaoApi juGaoApi;

    public JuGaoModel() {
        ServiceGenerator.changeApiBaseUrl("http://app-test.adinall.com/");//测试环境
//        ServiceGenerator.changeApiBaseUrl("http://app.adinall.com/");//生产环境
        juGaoApi = ServiceGenerator.createServiceFrom(JuGaoApi.class);
    }
    //1dfc8b82ccde162e   banner的测试id
    //    翻译官横幅id：05f71ea09994eca6


    /**
     * 请求广告位 接口
     *
     * @param pkgname  应用程序主包名  对于 Android 是应用的 PackageName，对于 iOS 是 BundleIdentifier
     * @param appname  应用程序名称   app 名称，需要 UrlEncode 处理
     * @param ua       系统webview的user-agent  需要 UrlEncode 处理
     * @param appv     应用版本号  例如：1.1.1
     * @param ip       请求设备的公网出口IPv4 地址  例如：211.136.28.18
     * @param brand    手机设备厂商， 例如：nokia，samsung
     * @param model    手机设备型号  例如：n70，galaxy
     * @param uuid     设备唯一标识  对于 IOS 设备，该值为 idfa, 对于 Android 设备，该值为 imei
     * @param pw       备物理屏幕宽度  例如：720
     * @param ph       设备物理屏幕高度  例如：1280
     * @param callback
     * @param <T>
     */
    public <T> void requestAdvertisement(String pkgname, String appname, String ua, String appv, String ip, String brand, String model, String uuid, int pw, int ph, Callback<T> callback) {
        Call<T> call = (Call<T>) juGaoApi.requestAdvertisement("05f71ea09994eca6", "1", 640, 100, pkgname, appname, ua, 0, Utils.getSDK(), appv, 1, 4, ip, brand, model, uuid, pw, ph);
        call.enqueue(callback);
    }
}
