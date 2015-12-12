package Utilities;


import java.sql.*;


/**
 * Created by Daniel Shchepetov on 21.11.2015.
 */


public class DBService {

    private static Connection connection;
    private static final String URI = "jdbc:sqlserver://localhost:1433;databaseName=LaborExchange;integratedSecurity=true;";

    public static Connection connect() {


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


            connection = DriverManager.getConnection(URI);
        } catch (SQLException e) {
            System.err.println("Не удалось подключить драйвер БД");

        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер не найден");
        }


        return connection;
    }


}
