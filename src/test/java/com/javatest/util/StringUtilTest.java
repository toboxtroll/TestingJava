package com.javatest.util;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void string_is_not_empty() {
        assertFalse(StringUtil.isEmpty("Tobias"));
    }
    @Test
    public void string_is_empty_with_space() {
        assertTrue(StringUtil.isEmpty(" "));
    }

    @Test
    public void string_is_null() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void string_is_empty_without_spaces() {
        assertTrue(StringUtil.isEmpty(""));
    }
}