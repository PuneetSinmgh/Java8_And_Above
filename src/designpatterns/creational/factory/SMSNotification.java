package src.designpatterns.creational.factory;

public class SMSNotification implements Notification{
    @Override
    public void notifyUser(){
        // send SMS notification
        System.out.println("Created SMS notification");
    }
}
