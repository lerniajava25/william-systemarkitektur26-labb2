package org.example;

import org.example.payment.PaymentProcessor;

public class OrderService {
    private final PaymentProcessor paymentProcessor;

    public OrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void placeOrder() {
        paymentProcessor.processPayment();
    }
}
