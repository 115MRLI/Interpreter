package printer.test.interpreter;


import printer.test.interpreter.app.App;

/**
 * 用户信息业务类
 */
public class OperationUtils {
    //id=2, account='mofang', password='123',
    // partner_id=668, role_id=1, name=王小二,
    // token='cfd973226d566d5efbb0626cf8b1ccb4251071f3', login_time=null

    /**
     * 存储用户名
     *
     * @param username 用户名
     */
    public static void saveUserName(int username) {
        SPUtils.put(App.mContext, "username", username);
    }

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    public static int getUserName() {
        return (int) SPUtils.get(App.mContext, "username", 0);
    }

    /**
     * 移除存储的用户名
     */
    public static void removeUserName() {
        SPUtils.remove(App.mContext, "username");
    }

    /**
     * 存储用户密码
     *
     * @param password 用户密码
     */
    public static void savePassword(int password) {
        SPUtils.put(App.mContext, "password", password);
    }

    /**
     * 获取用户密码
     *
     * @return 用户密码
     */
    public static int getPassword() {
        return (int) SPUtils.get(App.mContext, "password", 0);
    }

    /**
     * 移除存储的用户密码
     */
    public static void removePassword() {
        SPUtils.remove(App.mContext, "password");
    }

    /**
     * 存储商户ID
     *
     * @param partner_id 商户ID
     */
    public static void savePartnerId(int partner_id) {
        SPUtils.put(App.mContext, "partner_id", partner_id);
    }

    /**
     * 获取商户ID
     *
     * @return 商户ID
     */
    public static int getPartnerId() {
        return (int) SPUtils.get(App.mContext, "partner_id", 0);
    }

    /**
     * 存储用户ID
     *
     * @param role_id 用户ID
     */
    public static void saveRoleId(int role_id) {
        SPUtils.put(App.mContext, "role_id", role_id);
    }

    /**
     * 获取用户ID
     *
     * @return 用户ID
     */
    public static int getRoleId() {
        return (int) SPUtils.get(App.mContext, "role_id", 0);
    }

    /**
     * 存储数据ID
     *
     * @param id 数据ID
     */
    public static void saveId(int id) {
        SPUtils.put(App.mContext, "id", id);
    }

    /**
     * 回去数据ID
     *
     * @return 数据ID
     */
    public static int getId() {
        return (int) SPUtils.get(App.mContext, "id", 0);
    }

    /**
     * 存储用户名称
     *
     * @param name 用户名称
     */
    public static void saveName(String name) {
        SPUtils.put(App.mContext, "name", name);
    }

    /**
     * 获取用户名称
     *
     * @return 用户名称
     */
    public static String getName() {
        return (String) SPUtils.get(App.mContext, "name", "");
    }

    /**
     * 存储token
     *
     * @param token 秘钥
     */
    public static void saveToken(String token) {
        SPUtils.put(App.mContext, "token", token);
    }

    /**
     * 获取 token
     *
     * @return token
     */
    public static String getToken() {
        return (String) SPUtils.get(App.mContext, "token", "");
    }

    /**
     * 存储获取的系统语言
     *
     * @param language 中文CN,英文US，泰文TH
     */
    public static void saveLanguage(int language) {
        SPUtils.put(App.mContext, "language", language);
    }

    /**
     * 获取存储的系统语言类型
     *
     * @return
     */
    public static int getLanguage() {
        return (int) SPUtils.get(App.mContext, "language", 0);
    }

    /**
     * 存储图片广告
     *
     * @param images
     */
    public static void saveImages(String images) {
        SPUtils.put(App.mContext, "images", images);
    }

    /**
     * 获取图片广告
     *
     * @return
     */
    public static String getImages() {
        return (String) SPUtils.get(App.mContext, "images", "");
    }

    /**
     * 存储图片广告
     *
     * @param images
     */
    public static void saveexposureAppearFail(int images) {
        SPUtils.put(App.mContext, "images", images);
    }

    /**
     * 获取图片广告
     *
     * @return
     */
    public static int getexposureAppearFail() {
        return (int) SPUtils.get(App.mContext, "images", 0);
    }

    /**
     * 存储图片广告
     *
     * @param images
     */
    public static void saveexposureAppearAgin(int images) {
        SPUtils.put(App.mContext, "images", images);
    }

    /**
     * 获取图片广告
     *
     * @return
     */
    public static int getexposureAppearAgin() {
        return (int) SPUtils.get(App.mContext, "images", 0);
    }
}
