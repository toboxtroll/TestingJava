package com.javatest.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @Test
    public void return_I_when_is_1() {
        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
    }

    @Test
    public void return_II_when_is_2() {
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
    }

    @Test
    public void return_III_when_is_3() {
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));
    }

    @Test
    public void return_IV_when_is_4() {
        assertThat(RomanNumerals.arabicToRoman(4), is("IV"));
    }

    @Test
    public void return_V_when_is_5() {
        assertThat(RomanNumerals.arabicToRoman(5), is("V"));
    }

    @Test
    public void return_VI_when_is_6() {
        assertThat(RomanNumerals.arabicToRoman(6), is("VI"));
    }

    @Test
    public void return_VII_when_is_7() {
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));
    }

    @Test
    public void return_VIII_when_is_8() {
        assertThat(RomanNumerals.arabicToRoman(8), is("VIII"));
    }

    @Test
    public void return_IX_when_is_9() {
        assertThat(RomanNumerals.arabicToRoman(9), is("IX"));
    }
    @Test
    public void return_X_when_is_10() {
        assertThat(RomanNumerals.arabicToRoman(10), is("X"));
    }

    @Test
    public void return_XI_when_is_11() {
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
    }

    @Test
    public void return_XIV_when_is_14() {
        assertThat(RomanNumerals.arabicToRoman(14), is("XIV"));
    }

    @Test
    public void return_XVIII_when_is_18() {
        assertThat(RomanNumerals.arabicToRoman(18), is("XVIII"));
    }

    @Test
    public void return_XIX() {
        assertThat(RomanNumerals.arabicToRoman(19), is("XIX"));
    }

    @Test
    public void return_XX_when_is_20() {
        assertThat(RomanNumerals.arabicToRoman(20), is("XX"));
    }

    @Test
    public void return_XXXIX_when_is_39() {
        assertThat(RomanNumerals.arabicToRoman(39), is("XXXIX"));
    }

    @Test
    public void return_XLII_when_is_42() {
        assertThat(RomanNumerals.arabicToRoman(42), is("XLII"));
    }

    @Test
    public void return_L_when_is_50() {
        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
    }

    @Test
    public void return_LXXXV_when_is_85() {
        assertThat(RomanNumerals.arabicToRoman(85), is("LXXXV"));
    }

}