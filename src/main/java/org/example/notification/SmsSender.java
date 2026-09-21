package org.example.notification;

public class SmsSender implements OrderNotificationService {
    @Override
    public void sendNotification() {
        IO.println("Order and invoice sent to customer via SMS!");
    }
}
