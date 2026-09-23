package org.example.notification;

public class EmailSender implements OrderNotificationService {
    @Override
    public void sendNotification() {
        IO.println("Order and invoice sent to customer via email!");
    }
}
