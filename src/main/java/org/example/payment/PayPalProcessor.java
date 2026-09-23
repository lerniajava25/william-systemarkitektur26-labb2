package org.example.payment;

public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        IO.println("Payment charged to PayPal account!");
    }
}
