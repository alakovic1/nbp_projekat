package com.nbp.db;

import java.sql.*;

public class NBPdao {
    public static NBPdao instance = null;
    public static Connection connection;

    public static void initialize() {
        instance = new NBPdao();
    }

    public static NBPdao getInstance() {
        if(instance == null) initialize();
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }

    public NBPdao() {
        String connectionUrl = "jdbc:oracle:thin:@ora-02.db.lab.etf.unsa.ba:1521:cdb1";
        connection = null;

        try {
            //oracle jdbc driver needs to be added to project
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(connectionUrl, "nbp", "etfnbp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (connection != null) {
            System.out.println("Connected");
        }
    }
}
