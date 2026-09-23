package org.example.payment;

public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        IO.println("Payment charged to credit card!");
    }
}
