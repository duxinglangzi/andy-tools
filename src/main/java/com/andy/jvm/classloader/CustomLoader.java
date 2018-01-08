package com.andy.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * <p>ClassName: 自定义类的加载器 </p>
 * <p>@author wuqiong  2018/1/8 15:29 </p>
 */
public class CustomLoader extends ClassLoader {
    //需要继承 ClassLoader 类

    private String clazzDir;

    public CustomLoader(String clazzDir){
        this.clazzDir=clazzDir;
    }

    //自定义 类查找
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name;
        if (fileName.indexOf('.') != -1) {
            fileName = fileName.replaceAll("\\.", "\\\\");
        }
        fileName = fileName + ".class";
        try {
            try (FileInputStream in = new FileInputStream(clazzDir + fileName)) {
                try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer,0,len);
                    }
                    byte[] data = out.toByteArray();
                    return defineClass(name, data, 0, data.length);
                }
            }
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    /**
     * 方法描述: 尝试去加载 一个类，并执行内容
     * @author wuqiong  2018/1/8 15:37
     */
    public static void main(String[] args) throws ReflectiveOperationException{
        //1. 将LoaderTestClass.java 编译为LoaderTestClass.class 后复制到 D:\\ 下，当然也可以选择其他目录作为类加载器的classpath。
        //2. 加载
        ClassLoader classLoader = new CustomLoader("D:\\");
        //如果你的LoaderTestClass在一个包内，需要加上包名，如x.y.z.LoaderTestClass
        Class<?> clazz = classLoader.loadClass("com.andy.jvm.classloader.LoaderTestClass");
        //3. 通过反射调用hello()方法
        Object instance = clazz.newInstance();
        Method method = clazz.getMethod("hello", null);
        method.invoke(instance);//Hello
    }


}
