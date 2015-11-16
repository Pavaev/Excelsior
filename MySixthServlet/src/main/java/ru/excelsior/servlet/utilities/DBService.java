package ru.excelsior.servlet.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBService {
    private static Connection connection;

    private static final String URI = "jdbc:mysql://localhost:3306/guest_book";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URI, USERNAME, PASSWORD);

        } catch (SQLException e) {
            System.err.println("Не удалось подключить драйвер бд");
        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер не найден");
        }

        return connection;
    }
}
