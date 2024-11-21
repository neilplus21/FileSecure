package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myconnection {
    public static Connection connection;

    public static Connection getConnection() {
        try {
            // Load the MySQL driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FILESECURE?useSSL=false",
                    "root",
                    "neilmp21"
            );

            System.out.println("Connection established successfully!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("MySQL Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to establish a connection.");
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error closing connection.");
        }
    }

//    public static void main(String[] args) {
//        getConnection();
//        closeConnection();
//    }
}
