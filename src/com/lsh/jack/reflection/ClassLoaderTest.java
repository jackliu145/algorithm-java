package com.lsh.jack.reflection;


import java.io.FileInputStream;
import java.io.IOException;

public class ClassLoaderTest {

    private static final  String base = "out/production/algorithm-java/com/lsh/jack/reflection/";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                if (name.equals("com.lsh.jack.reflection.ClassLoaderTest")) {
                    String s =  base + name.substring(name.lastIndexOf(".") + 1) + ".class";
                    try {
                        System.out.println(s);
                        FileInputStream fileInputStream = new FileInputStream(s);
                        if (fileInputStream == null) {
                            return super.loadClass(name);
                        }
                        byte[] bs = new byte[fileInputStream.available()];
                        fileInputStream.read(bs);
                        return defineClass(name, bs, 0, bs.length);
                    } catch (IOException e) {
                    throw  new ClassNotFoundException(name);
                    }
//                }
//                return super.loadClass(name);
            }
        };
        Object o = classLoader.loadClass("com.lsh.jack.reflection.ClassLoaderTest").newInstance();

        System.out.println(o.getClass() == classLoaderTest.getClass());

    }
}
