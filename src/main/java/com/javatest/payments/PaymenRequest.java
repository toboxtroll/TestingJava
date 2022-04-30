package com.javatest.payments;

public class PaymenRequest {
    private double amount;

    public PaymenRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
