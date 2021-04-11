import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author RenTian Liu
 * @version 1.0
 * @date 2021-04-11 15:56
 */
public class OkHttpUtil {
    // 缓存客户端实例
    public static OkHttpClient client = new OkHttpClient();


    // get
    public static String getAsString(String url){
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static void main(String[] args) {
        String url = "http://localhost:8081/";
        String text = OkHttpUtil.getAsString(url);
        System.out.println("url: " + url + "; response:" + text);
        // 清除缓存
        OkHttpUtil.client = null;
    }
}
