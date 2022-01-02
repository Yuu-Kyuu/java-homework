package com.homework.java;

import jvm.Hello;

public class LoadClassMain {
    public static void main(String[] args) {
        try {
            Hello x = (Hello) new HelloXlassLoader().loadClass("jvm.Hello").newInstance();
            x.hello();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
