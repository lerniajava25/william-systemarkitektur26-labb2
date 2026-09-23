package org.example.notification;

import jakarta.enterprise.inject.Alternative;

@Alternative
public class EmailSender implements OrderNotificationService {
    @Override
    public void sendNotification() {
        IO.println("Order and invoice sent to customer via email!");
    }
}
