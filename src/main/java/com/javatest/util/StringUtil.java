package com.javatest.util;

public class StringUtil {

    public static boolean isEmpty(String str){
        return str == null || str.matches("^\\s+$|^$");
    }
}
