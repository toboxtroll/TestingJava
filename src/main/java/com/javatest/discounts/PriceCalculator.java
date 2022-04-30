package com.javatest.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private List<Double> prices = new ArrayList<>();
    private int discount = 0;

    public double getTotal() {
        double result = 0;
        for (Double price : prices) {
            result += price;
        }

        double v = (100 - discount);
        return (result * v) / 100;
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void applyDiscount(int discount) {
        this.discount = discount;
    }

    public double totalDiscount() {
        return 100 - getTotal();
    }
}
