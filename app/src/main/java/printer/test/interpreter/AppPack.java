package printer.test.interpreter;

/**
 * app包名加app名字
 */
public class AppPack {
    private String appName;
    private String appPack;

    public AppPack(String appName, String appPack) {
        this.appName = appName;
        this.appPack = appPack;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPack() {
        return appPack;
    }

    public void setAppPack(String appPack) {
        this.appPack = appPack;
    }

    @Override
    public String toString() {
        return "AppPack{" +
                "appName='" + appName + '\'' +
                ", appPack='" + appPack + '\'' +
                '}';
    }
}
