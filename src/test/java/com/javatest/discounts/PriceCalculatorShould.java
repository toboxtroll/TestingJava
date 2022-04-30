package com.javatest.discounts;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceCalculatorShould {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void total_zero_when_there_are_not_prices() {
        PriceCalculator priceCalculator = new PriceCalculator();
        assertThat(priceCalculator.getTotal(), is(0.0));
    }


    @Test
    public void total_is_the_sum_of_prices(){
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(12.2);
        priceCalculator.addPrice(20.7);
        assertEquals(32.9, priceCalculator.getTotal(), 0);
    }

    @Test
    public void apply_discount_to_price() {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(2.2);
        priceCalculator.addPrice(97.8);

        priceCalculator.applyDiscount(25);

        assertThat(priceCalculator.getTotal(), is(75.0));
        assertThat(priceCalculator.totalDiscount(), is(25.3));
//        discount_total_of_price(priceCalculator);
    }

//    @Test
//    public void discount_total_of_price(PriceCalculator priceCalculator) {
//
//        priceCalculator.totalDiscount();
//
//        assertThat(priceCalculator.getTotal(), is(15.0));
//    }
}