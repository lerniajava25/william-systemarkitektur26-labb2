package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.notification.OrderNotificationService;
import org.example.payment.PaymentProcessor;

@ApplicationScoped
public class OrderService {
    private final PaymentProcessor paymentProcessor;
    private final OrderNotificationService notificationService;

    @Inject
    public OrderService(PaymentProcessor paymentProcessor, OrderNotificationService notificationService) {
        this.paymentProcessor = paymentProcessor;
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        paymentProcessor.processPayment();
        notificationService.sendNotification();
    }
}
