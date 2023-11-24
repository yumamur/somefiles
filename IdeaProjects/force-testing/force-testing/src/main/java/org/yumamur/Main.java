package org.yumamur;

import java.lang.reflect.Field;

public class Main {
    static Test var = new Test("qwe", "asd");
    public static void main(String[] args) {
        System.out.println(test());
    }
    public static String test() {
        try {
            Field field = var.getClass().getDeclaredField("var1");
            field.setAccessible(true);
            return (String) field.get(var);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}