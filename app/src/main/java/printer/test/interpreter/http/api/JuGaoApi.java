package printer.test.interpreter.http.api;


import printer.test.interpreter.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 聚告api请求接口
 */
public interface JuGaoApi {
    /**
     * 请求广告接口
     *
     * @param adid    广告位唯一ID 例如：8830e74ad3cc4450 ， 由聚告媒介人员提供
     * @param adtype  广告类型   1：横幅广告2：开屏广告3：原生信息流广告4：插屏广告5：原生视频广告6：视频广告
     * @param width   广告位宽度  例如：640
     * @param height  广告位高度  例如：100
     * @param pkgname 应用程序主包名  对于 Android 是应用的 PackageName，对于 iOS 是 BundleIdentifier
     * @param appname 应用程序名称   app 名称，需要 UrlEncode 处理
     * @param ua      系统webview的user-agent  需要 UrlEncode 处理
     * @param os      设备系统类型  0：Android1：Ios2：Windows Phone3：Others
     * @param osv     操作系统版本号 例如：6.0
     * @param appv    应用版本号  例如：1.1.1
     * @param carrier 网络运营商类型 1：中国移动2：中国联通3：中国电信4：其他
     * @param conn    网络连接类型1：2g 2：3g 3：4g 4：wifi  5：other
     * @param ip      请求设备的公网出口IPv4 地址  例如：211.136.28.18
     * @param brand   手机设备厂商， 例如：nokia，samsung
     * @param model   手机设备型号  例如：n70，galaxy
     * @param uuid    设备唯一标识  对于 IOS 设备，该值为 idfa, 对于 Android 设备，该值为 imei
     * @param pw      设备物理屏幕宽度  例如：720
     * @param ph      设备物理屏幕高度  例如：1280
     */
    @GET("api.m")
    Call<ResponseData> requestAdvertisement(@Query("adid") String adid, @Query("adtype") String adtype, @Query("width") int width, @Query("height") int height, @Query("pkgname") String pkgname, @Query("appname") String appname,
                                            @Query("ua") String ua, @Query("os") int os, @Query("osv") String osv, @Query("appv") String appv, @Query("carrier") int carrier, @Query("conn") int conn, @Query("ip") String ip,
                                            @Query("brand") String brand, @Query("model") String model, @Query("uuid") String uuid, @Query("pw") int pw, @Query("ph") int ph);
}
