package org.example;

import org.example.container.DIContainer;
import org.example.notification.EmailSender;
import org.example.notification.OrderNotificationService;
import org.example.notification.SmsSender;
import org.example.payment.CreditCardProcessor;
import org.example.payment.PayPalProcessor;
import org.example.payment.PaymentProcessor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.lang.reflect.InvocationTargetException;

public class Main {
    static void main() {
        // Dependency injection via constructors
        PaymentProcessor creditCardProcessor = new CreditCardProcessor();
        PaymentProcessor paypalProcessor = new PayPalProcessor();

        OrderNotificationService emailService = new EmailSender();
        OrderNotificationService smsService = new SmsSender();

        OrderService orderService1 = new OrderService(creditCardProcessor, emailService);
        OrderService orderService2 = new OrderService(paypalProcessor, smsService);

        printSectionHeader("DEL 1: CONSTRUCTOR DEPENDENCY INJECTION");
        orderService1.placeOrder();
        orderService2.placeOrder();

        // Custom dependency injection container
        try {
            DIContainer diContainer = new DIContainer();
            diContainer.registerBinding(PaymentProcessor.class, CreditCardProcessor.class);
            diContainer.registerBinding(OrderNotificationService.class, EmailSender.class);

            var orderService = diContainer.getInstanceOfClass(OrderService.class);

            printSectionHeader("DEL 2: CUSTOM DEPENDENCY INJECTION CONTAINER");
            orderService.placeOrder();
        } catch(NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            IO.println(e.getMessage());
        }

        // CDI with Weld
        Weld weld = new Weld();
        try (WeldContainer container = weld.initialize()) {
            var orderService = container.select(OrderService.class).get();
            printSectionHeader("DEL 3: CDI WITH WELD");
            orderService.placeOrder();
        }
    }

    private static void printSectionHeader(String headerText) {
        IO.print("""
                
                """ + headerText +
                """
                

                """);
    }
}
