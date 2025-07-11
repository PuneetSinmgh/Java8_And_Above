package src.designpatterns.creational.factory;


/*
* When to Make Factory Singleton:
    If the factory class holds state (like cached config, database connection pools, or object mappings).
    If you want to avoid unnecessary multiple factory objects, since object creation logic is central and doesn’t need multiple factory instances.
    Example: LoggerFactory, ConnectionFactory, NotificationFactory when each instance would behave identically.
    It ensures:
        Consistency (same config, same behavior)
        Resource efficiency
*
* When It Doesn’t Have to Be Singleton:
    If the factory class is stateless, and you don't mind creating multiple instances.
    If different factory instances could be configured differently (e.g., different regional notification settings).
* */
public class NotificationFactory {

    private static volatile NotificationFactory notificationFactory ;

    // private constructor
    private NotificationFactory(){

    }

    // static method to get instance
    public static NotificationFactory getInstance() {
        if (notificationFactory == null) {

            synchronized (NotificationFactory.class) {
                if (notificationFactory == null) {
                    notificationFactory = new NotificationFactory();
                }
            }
        }

        return notificationFactory;
    }

    public static Notification createNotification(String type){
        if ( type.equals("EMAIL")) {
            return new EmailNotification();
        } else if ( type.equals("SMS")) {
            return new SMSNotification();
        } else if ( type.equals("PUSH")) {
            return new PushNotification();
        }
        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}
