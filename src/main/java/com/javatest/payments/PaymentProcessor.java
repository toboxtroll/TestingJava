package com.javatest.payments;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){
        PaymentResponse response = paymentGateway.requestPayment(new PaymenRequest(amount));
        return PaymentResponse.PaymentStatus.OK == response.getStatus();

    }
}

