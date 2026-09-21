package org.example;

import org.example.payment.CreditCardProcessor;
import org.example.payment.PayPalProcessor;
import org.example.payment.PaymentProcessor;

public class Main {
    static void main() {
        PaymentProcessor creditCardProcessor = new CreditCardProcessor();
        PaymentProcessor paypalProcessor = new PayPalProcessor();

        OrderService orderService = new OrderService(creditCardProcessor);
        orderService.placeOrder();

        orderService = new OrderService(paypalProcessor);
        orderService.placeOrder();
    }
}
