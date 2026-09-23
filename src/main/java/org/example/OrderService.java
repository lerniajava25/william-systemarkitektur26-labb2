package org.example;

import org.example.notification.OrderNotificationService;
import org.example.payment.PaymentProcessor;

public class OrderService {
    private final PaymentProcessor paymentProcessor;
    private final OrderNotificationService notificationService;

    public OrderService(PaymentProcessor paymentProcessor, OrderNotificationService notificationService) {
        this.paymentProcessor = paymentProcessor;
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        paymentProcessor.processPayment();
        notificationService.sendNotification();
    }
}
