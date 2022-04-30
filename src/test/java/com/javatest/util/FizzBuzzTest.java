package com.javatest.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    /*Usando TDD (empieza por los tests), implementa una función que dado un número:
    Si el número es divisible por 3, retorna “Fizz”
    Si el número es divisible por 5, retorna “Buzz”
    Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
    En otro caso, retorna el mismo número*/

    @Test
    public void return_fizz_when_is_divisible_by_3() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Fizz", fizzBuzz.getFizzBuzz(3));
        assertEquals("Fizz", fizzBuzz.getFizzBuzz(6));
    }

    @Test
    public void return_buzz_when_is_divisible_by_5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(50));
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(5));
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(10));
    }

    @Test
    public void return_fizzbuzz_when_is_divisible_by_3_and_5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("FizzBuzz", fizzBuzz.getFizzBuzz(30));
        assertEquals("FizzBuzz", fizzBuzz.getFizzBuzz(15));
    }

    @Test
    public void return_number_when_is_not_divisible_for_3_and_5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.getFizzBuzz(67), is("67"));
        assertThat(fizzBuzz.getFizzBuzz(2), is("2"));
        assertThat(fizzBuzz.getFizzBuzz(16), is("16"));
    }
}