package com.javatest.util;

import com.javatest.util.StringRepeat;
import org.junit.Assert;
import org.junit.Test;
//147620
public class StringRepeatTest {
    @Test
    public void string_repeat_multiple_times() {
        Assert.assertEquals("holaholahola", StringRepeat.repeat("hola", 3));
    }

    @Test
    public void string_repeat_once() {
        Assert.assertEquals("hola", StringRepeat.repeat("hola", 1));
    }

    @Test
    public void string_repeat_zero_times() {
        Assert.assertEquals("", StringRepeat.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void string_repeat_negative() {
        StringRepeat.repeat("hola", -1);
    }
}