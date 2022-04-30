package com.javatest.util;

public class PasswordUtil {

    public enum SecurityLevel{
        WEAK, MEDIUM, STR0NG
    }

    public static SecurityLevel assessPassword(String password){
        if (password.length() < 8) {
            return SecurityLevel.WEAK;
        }

        if (password.matches("[a-zA-Z]+")){
            return  SecurityLevel.WEAK;
        }

        if (password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STR0NG;
    }
}
