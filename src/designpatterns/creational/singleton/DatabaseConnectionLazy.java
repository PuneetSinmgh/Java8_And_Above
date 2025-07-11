package src.designpatterns.creational.singleton;

public class DatabaseConnectionLazy {

    // lazy initialization
    private static volatile DatabaseConnectionLazy databaseConnection ;

    // private constructor
    private DatabaseConnectionLazy(){
    }

    // static method to get instance
    public static DatabaseConnectionLazy getInstance(){
        if ( databaseConnection == null){
            // synchronized locking
            synchronized( DatabaseConnectionLazy.class ){
                if ( databaseConnection == null){
                    databaseConnection = new DatabaseConnectionLazy();
                }
            }
        }

        return databaseConnection;
    }
}
