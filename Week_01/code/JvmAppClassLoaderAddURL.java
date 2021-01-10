package Week_01.code;

import javax.swing.event.MouseInputAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 运行期加载额外的jar包或者class
 * @author RenTian Liu
 * @version 1.0
 * @date 2021-01-10 12:57
 */
public class JvmAppClassLoaderAddURL {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, MalformedURLException {
        HelloClassLoader helloClassLoader = new HelloClassLoader();
        String addPath = "file:/f:/app/";
        Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        addURL.setAccessible(true);
        URL url = new URL(addPath);
        addURL.invoke(helloClassLoader,url);
        Class.forName("jvm.Hello");

    }
}
