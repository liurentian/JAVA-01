package Week_01.code;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RenTian Liu
 * @version 1.0
 * @date 2021-01-10 11:58
 */
public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) {
        HelloClassLoader CL = new HelloClassLoader();
        Class<?> hello = CL.findClass("Hello");
        try {
            hello.getMethod("hello").invoke(hello.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name){
        try {
            InputStream inputStream = getClass().getResourceAsStream("Hello" + ".xlass");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                bos.write(255 - temp);
            }
            byte[] bytes = bos.toByteArray();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }
}
