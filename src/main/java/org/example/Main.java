package org.example;

import org.example.container.A;
import org.example.container.DIContainer;
import org.example.notification.EmailSender;
import org.example.notification.OrderNotificationService;
import org.example.notification.SmsSender;
import org.example.payment.CreditCardProcessor;
import org.example.payment.PayPalProcessor;
import org.example.payment.PaymentProcessor;

import java.lang.reflect.InvocationTargetException;

public class Main {
    static void main() {
        // Dependency injection via constructors
        PaymentProcessor creditCardProcessor = new CreditCardProcessor();
        PaymentProcessor paypalProcessor = new PayPalProcessor();

        OrderNotificationService emailService = new EmailSender();
        OrderNotificationService smsService = new SmsSender();

        OrderService orderService1 = new OrderService(creditCardProcessor, emailService);
        orderService1.placeOrder();

        OrderService orderService2 = new OrderService(paypalProcessor, smsService);
        orderService2.placeOrder();

        // Custom dependency injection container
        DIContainer container = new DIContainer();
        try {
            container.getInstanceOfClass(A.class);
        } catch(NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            IO.println(e.getMessage());
        }
    }
}
