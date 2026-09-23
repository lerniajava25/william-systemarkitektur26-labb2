package org.example.payment;

import jakarta.enterprise.inject.Alternative;

@Alternative
public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        IO.println("Payment charged to credit card!");
    }
}
