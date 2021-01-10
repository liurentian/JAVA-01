package Week_01.code;

import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * @author RenTian Liu
 * @version 1.0
 * @date 2021-01-10 12:19
 */
public class JvmClassPathPrint {
    public static void main(String[] args) {
        //启动类加载器
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL url : urLs) {
            System.out.println(" ==> " +url.toExternalForm());
        }

        //拓展类加载器
        printClassLoader("拓展类加载器",JvmClassPathPrint.class.getClassLoader().getParent());
        //应用类加载器
        printClassLoader("应用类加载器",JvmClassPathPrint.class.getClassLoader());
    }

    private static void printClassLoader(String name, ClassLoader CL) {
        if (CL != null) {
            System.out.println(name + "ClassLoader" + CL.toString());
            printURLForClassLoader(CL);
        }else{
            System.out.println(name + "ClassLoader -- > null");
        }
    }

    private static void printURLForClassLoader(ClassLoader cl) {
        Object ucp = insightField(cl,"ucp");
        Object path = insightField(ucp,"path");
        ArrayList ps = (ArrayList) path;
        for (Object o : ps) {
            System.out.println(" ==> " + o.toString());
        }
    }

    private static Object insightField(Object obj, String fName) {
        try {
            Field f = null;
            if (obj instanceof URLClassLoader) {
                f = URLClassLoader.class.getDeclaredField(fName);
            } else {
                f = obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
