package org.example.payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        IO.println("Payment charged to PayPal account!");
    }
}
