package src.designpatterns.creational.factory;

public class PushNotification implements Notification{
    @Override
    public void notifyUser(){
        // send Push notification
        System.out.println("Created Push notification");
    }
}
