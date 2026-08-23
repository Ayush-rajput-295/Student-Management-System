package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection connection = null;

        try {

            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return connection;
    }
}