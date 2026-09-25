package org.example.notification;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class EmailSender implements OrderNotificationService {
    @Override
    public void sendNotification() {
        IO.println("Order and invoice sent to customer via email!");
    }
}
