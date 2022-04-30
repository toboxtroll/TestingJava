package com.javatest.util;

public class StringRepeat {

    public static String repeat(String str, int times){
        StringBuilder result = new StringBuilder();
        if (times < 0){
            throw new IllegalArgumentException("negative is not allowed");
        }
        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return result.toString();
    }
}
