package src.designpatterns.creational.singleton;

public class DatabaseConnectionEager {

    // Eager initialization at time of class loading
    private static final DatabaseConnectionEager databaseConnection = new DatabaseConnectionEager();

    // private constructor
    private DatabaseConnectionEager(){

    }

    // static method to get instance
    public static DatabaseConnectionEager getInstance(){
        return databaseConnection;
    }
}
