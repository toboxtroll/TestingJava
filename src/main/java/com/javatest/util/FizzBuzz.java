package com.javatest.util;

public class FizzBuzz {

    public String getFizzBuzz(int number) {
        String result = "";

        if(number % 3 == 0) result = "Fizz";
        if(number % 5 == 0) result += "Buzz";

        return result.isEmpty() ? String.valueOf(number) : result;

    }
}
