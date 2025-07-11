package src.designpatterns.creational.factory;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser(){
        // send email notification
        System.out.println("Created email notification");

    }
}

