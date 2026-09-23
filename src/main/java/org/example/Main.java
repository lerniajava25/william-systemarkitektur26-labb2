package org.example;

import org.example.notification.EmailSender;
import org.example.notification.OrderNotificationService;
import org.example.notification.SmsSender;
import org.example.payment.CreditCardProcessor;
import org.example.payment.PayPalProcessor;
import org.example.payment.PaymentProcessor;

public class Main {
    static void main() {
        PaymentProcessor creditCardProcessor = new CreditCardProcessor();
        PaymentProcessor paypalProcessor = new PayPalProcessor();

        OrderNotificationService emailService = new EmailSender();
        OrderNotificationService smsService = new SmsSender();

        OrderService orderService1 = new OrderService(creditCardProcessor, emailService);
        orderService1.placeOrder();

        OrderService orderService2 = new OrderService(paypalProcessor, smsService);
        orderService2.placeOrder();
    }
}
