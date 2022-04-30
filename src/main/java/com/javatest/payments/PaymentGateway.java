package com.javatest.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymenRequest request);
}
