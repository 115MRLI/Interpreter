package printer.test.interpreter.http.response;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import printer.test.interpreter.http.api.JuGaoApi;
import printer.test.interpreter.http.api.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;

import static android.support.constraint.Constraints.TAG;

public class BaoGuang {
    JuGaoApi juGaoApi;

    /**
     * 曝光
     *
     * @param adress
     */
    public void baoGuang(final String adress, final NotificationInterface notificationInterface) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    URL url = new URL(adress);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000); //设置连接的超时事件是5秒
                    int code = conn.getResponseCode();  //获取返回的成功代码

                    Log.i(TAG, "code:---" + code);

                    if (code == 200) {
                        //表示连接服务器成功返回信息

                    }
                    notificationInterface.onResponseCode(code);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    /**
     * 点击
     *
     * @param adress
     */
    public void dianJi(final String adress, final NotificationInterface notificationInterface) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    URL url = new URL(adress);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000); //设置连接的超时事件是5秒
                    int code = conn.getResponseCode();  //获取返回的成功代码

                    Log.i(TAG, "code:---" + code);

                    if (code == 200) {
                        //表示连接服务器成功返回信息

                    }
                    notificationInterface.onResponseCode(code);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public interface NotificationInterface {
        /**
         * 请求返回code
         *
         * @param code
         */
        void onResponseCode(int code);
    }
}
