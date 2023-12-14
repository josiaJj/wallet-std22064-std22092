package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection(){
        if(connection != null)
            return connection;
        try{
            connection = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_PASSWORD"),
                    System.getenv("DB_USERNAME")
            );
            return connection;
        }
        catch (SQLException error){
            System.out.println(error.getMessage());
            throw new RuntimeException("Database connection failed");
        }
    }

    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
