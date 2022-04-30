package com.javatest.util;

import com.javatest.util.PasswordUtil;
import org.junit.Test;

import static com.javatest.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("adsfasdfasd"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("12345sdfa67"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols() {
        assertEquals(STR0NG, PasswordUtil.assessPassword("12345sdfa67**"));
    }
}