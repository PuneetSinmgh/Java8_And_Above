package src.designpatterns.creational.factory;

/*
*
Why Is It Useful?
Centralizes object creation logic.
Promotes Open-Closed Principle — you can add new notification types without changing client code.
Simplifies testing and mocking.
Makes code more maintainable and scalable.
* */
public class NotificationService {

    public static void main(String[] args) {
        try{
            NotificationFactory.createNotification("EMAIL").notifyUser();
            NotificationFactory.createNotification("SMS").notifyUser();
            NotificationFactory.createNotification("PUSH").notifyUser();
            NotificationFactory.createNotification("DEFAULT").notifyUser();
        } catch (Exception e) {
            System.out.println("default is not defined notification type");
        }

    }
}
