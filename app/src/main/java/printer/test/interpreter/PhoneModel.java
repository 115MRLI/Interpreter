package printer.test.interpreter;

/**
 * 手机信息存储类
 */
public class PhoneModel {
    //手机型号
    private String phoneModel;
    //手机厂商
    private String phoneFirim;
    //设备唯一标识  对于 IOS 设备，该值为 idfa, 对于 Android 设备，该值为 imei
    private String uuid;

    public PhoneModel(String phoneModel, String phoneFirim, String uuid) {
        this.phoneModel = phoneModel;
        this.phoneFirim = phoneFirim;
        this.uuid = uuid;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getPhoneFirim() {
        return phoneFirim;
    }

    public void setPhoneFirim(String phoneFirim) {
        this.phoneFirim = phoneFirim;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "PhoneModel{" +
                "phoneModel='" + phoneModel + '\'' +
                ", phoneFirim='" + phoneFirim + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
