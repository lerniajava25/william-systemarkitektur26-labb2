package org.example.notification;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SmsSender implements OrderNotificationService {
    @Override
    public void sendNotification() {
        IO.println("Order and invoice sent to customer via SMS!");
    }
}
