package com.homework.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloXlassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("src/com/homework/java/Hello.xlass");
//        File f = new File("/Users/qiuch/Documents/gitRepository/java-homework/week01-jvm/homework-02/Hello.class");

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(f);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            return null;
        }


    }

}
